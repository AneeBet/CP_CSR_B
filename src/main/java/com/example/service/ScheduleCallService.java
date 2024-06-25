package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.dto.CustomerScheduleCallDTO;
import com.example.dto.GuestScheduleCallDTO;
import com.example.model.CustomerScheduleCall;
import com.example.model.GuestScheduleCall;
import com.example.model.ResolutionStatus;
import com.example.repository.CustomerScheduleCallRepository;
import com.example.repository.GuestScheduleCallRepository;

@Service
public class ScheduleCallService {

	private final CustomerScheduleCallRepository customerScheduleCallRepository;

	private final GuestScheduleCallRepository guestScheduleCallRepository;
	@Autowired
	private JavaMailSender mailSender;

	public ScheduleCallService(CustomerScheduleCallRepository customerScheduleCallRepository,
			GuestScheduleCallRepository guestScheduleCallRepository) {
		super();
		this.customerScheduleCallRepository = customerScheduleCallRepository;
		this.guestScheduleCallRepository = guestScheduleCallRepository;
	}

	public List<CustomerScheduleCallDTO> getAllCustomerScheduleCall() {
		List<CustomerScheduleCall> calls = customerScheduleCallRepository.findAll();
		return calls.stream().map(this::convertToCustomerDTO).toList();
	}

	public List<CustomerScheduleCallDTO> getAllPendingCustomerScheduleCall() {
		List<CustomerScheduleCall> calls = customerScheduleCallRepository.findAllByStatus(ResolutionStatus.PENDING);
		return calls.stream().map(this::convertToCustomerDTO).toList();
	}

	private CustomerScheduleCallDTO convertToCustomerDTO(CustomerScheduleCall call) {
		CustomerScheduleCallDTO dto = new CustomerScheduleCallDTO();
		dto.setScheduleCallId(call.getScheduleCallId());
		dto.setCustomerName(call.getCustomerCardAccount().getCustomerProfile().getName());
		dto.setCustomerEmail(call.getCustomerCardAccount().getCustomerProfile().getEmail());
		dto.setCustomerPhone(call.getCustomerCardAccount().getCustomerProfile().getMobileNumber());
		dto.setSubject(call.getSubject());
		dto.setDescription(call.getDescription());
		dto.setTimeSlot(call.getTimeSlot());
		dto.setStatus(call.getStatus());
		return dto;
	}

	public List<GuestScheduleCallDTO> getAllGuestScheduleCall() {
		List<GuestScheduleCall> calls = guestScheduleCallRepository.findAll();
		return calls.stream().map(this::convertToGuestDTO).toList();
	}

	public List<GuestScheduleCallDTO> getAllPendingGuestScheduleCall() {
		List<GuestScheduleCall> calls = guestScheduleCallRepository.getAllPendingGuestScheduleCall();
		return calls.stream().map(this::convertToGuestDTO).toList();
	}

	private GuestScheduleCallDTO convertToGuestDTO(GuestScheduleCall call) {
		GuestScheduleCallDTO dto = new GuestScheduleCallDTO();
		dto.setScheduleCallId(call.getScheduleCallId());
		dto.setGuestName(call.getGuestProfile().getName());
		dto.setGuestEmail(call.getGuestProfile().getGuestEmail());
		dto.setGuestPhone(call.getGuestProfile().getMobileNumber());
		dto.setSubject(call.getSubject());
		dto.setDescription(call.getDescription());
		dto.setTimeSlot(call.getTimeSlot());
		dto.setStatus(call.getStatus());
		return dto;
	}

	public Boolean resolveCustomerScheduleCall(Long id) {
		Optional<CustomerScheduleCall> old = customerScheduleCallRepository.findById(id);
		if (old.isPresent()) {
			CustomerScheduleCall scheduleCall = old.get();
			scheduleCall.setStatus(ResolutionStatus.RESOLVED);
			customerScheduleCallRepository.save(scheduleCall);
			sendEmail(scheduleCall.getCustomerCardAccount().getCustomerProfile().getEmail(), "Customer Support Call",
					"Our customer support called. If you need any further assistance, please schedule another appointment.");
			return true;
		}
		return false;
	}

	public Boolean resolveGuestScheduleCall(Long id) {
		Optional<GuestScheduleCall> old = guestScheduleCallRepository.findById(id);
		if (old.isPresent()) {
			GuestScheduleCall scheduleCall = old.get();
			scheduleCall.setStatus(ResolutionStatus.RESOLVED);
			guestScheduleCallRepository.save(scheduleCall);
			sendEmail(scheduleCall.getGuestProfile().getGuestEmail(), "Customer Support Call",
					"Our customer support called. If you need any further assistance, please schedule another appointment.");
			return true;
		}
		return false;
	}

	private void sendEmail(String to, String subject, String text) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		mailSender.send(message);
	}
}