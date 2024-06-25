package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.dto.CustomerGrievanceDTO;
import com.example.dto.GuestGrievanceDTO;
import com.example.model.CustomerGrievance;
import com.example.model.GuestGrievance;
import com.example.model.ResolutionStatus;
import com.example.repository.CustomerGrievanceRepository;
import com.example.repository.GuestGrievanceRepository;

@Service
public class GrievanceService {

	private final CustomerGrievanceRepository customerGrievanceRepository;
	@Autowired
	private JavaMailSender mailSender;
	private final GuestGrievanceRepository guestGrievanceRepository;

	public GrievanceService(CustomerGrievanceRepository customerGrievanceRepository,
			GuestGrievanceRepository guestGrievanceRepository) {
		this.customerGrievanceRepository = customerGrievanceRepository;
		this.guestGrievanceRepository = guestGrievanceRepository;
	}

	public List<CustomerGrievanceDTO> getAllCustomerGrievances() {
		List<CustomerGrievance> grievances = customerGrievanceRepository.findAll();
		return grievances.stream().map(this::convertToCustomerDTO).toList();
	}

	public List<CustomerGrievanceDTO> getAllPendingCustomerGrievances() {
		List<CustomerGrievance> grievances = customerGrievanceRepository.getAllPendingCustomerGrievances();
		return grievances.stream().map(this::convertToCustomerDTO).toList();
	}

	private CustomerGrievanceDTO convertToCustomerDTO(CustomerGrievance grievance) {
		CustomerGrievanceDTO dto = new CustomerGrievanceDTO();
		dto.setGrievanceId(grievance.getGrievanceId());
		dto.setCustomerName(grievance.getCustomerCardAccount().getCustomerProfile().getName());
		dto.setCustomerEmail(grievance.getCustomerCardAccount().getCustomerProfile().getEmail());
		dto.setCustomerPhone(grievance.getCustomerCardAccount().getCustomerProfile().getMobileNumber());
		dto.setSubject(grievance.getSubject());
		dto.setDescription(grievance.getDescription());
		dto.setTimestamp(grievance.getTimestamp().toString());
		dto.setStatus(grievance.getStatus().toString());
		return dto;
	}

	public List<GuestGrievanceDTO> getAllGuestGrievances() {
		List<GuestGrievance> grievances = guestGrievanceRepository.findAll();
		return grievances.stream().map(this::convertToGuestDTO).toList();
	}

	public List<GuestGrievanceDTO> getAllPendingGuestGrievances() {
		List<GuestGrievance> grievances = guestGrievanceRepository.getAllPendingGuestGrievances();
		return grievances.stream().map(this::convertToGuestDTO).toList();
	}

	private GuestGrievanceDTO convertToGuestDTO(GuestGrievance grievance) {
		GuestGrievanceDTO dto = new GuestGrievanceDTO();
		dto.setGrievanceId(grievance.getGrievanceId());
		dto.setGuestName(grievance.getGuestProfile().getName());
		dto.setGuestEmail(grievance.getGuestProfile().getGuestEmail());
		dto.setGuestPhone(grievance.getGuestProfile().getMobileNumber());
		dto.setSubject(grievance.getSubject());
		dto.setDescription(grievance.getDescription());
		dto.setTimestamp(grievance.getTimestamp().toString());
		dto.setStatus(grievance.getStatus().toString());
		return dto;
	}

	public Boolean resolveCustomerGrievance(Long id, String message) {
		Optional<CustomerGrievance> old = customerGrievanceRepository.findById(id);
		if (old.isPresent()) {
			CustomerGrievance grievance = old.get();
			grievance.setStatus(ResolutionStatus.RESOLVED);
			customerGrievanceRepository.save(grievance);
			sendEmail(grievance.getCustomerCardAccount().getCustomerProfile().getEmail(), "Grievance Resolved",
					message);
			return true;
		}
		return false;
	}

	public Boolean resolveGuestGrievance(Long id, String message) {
		Optional<GuestGrievance> old = guestGrievanceRepository.findById(id);
		if (old.isPresent()) {
			GuestGrievance grievance = old.get();
			grievance.setStatus(ResolutionStatus.RESOLVED);
			guestGrievanceRepository.save(grievance);
			sendEmail(grievance.getGuestProfile().getGuestEmail(), "Grievance Resolved", message);
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
