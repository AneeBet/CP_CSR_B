package com.example.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.CustomerGrievanceDTO;
import com.example.dto.CustomerScheduleCallDTO;
import com.example.dto.GuestGrievanceDTO;
import com.example.dto.GuestScheduleCallDTO;
import com.example.model.CustomerSupport;
import com.example.service.CustomerSupportService;
import com.example.service.GrievanceService;
import com.example.service.ScheduleCallService;

@RestController
@RequestMapping("/customersupport")
@CrossOrigin(origins = "*")
public class CustomerSupportController {
	private ScheduleCallService scheduleCallService;

	private CustomerSupportService customerSupportService;

	private GrievanceService grievanceService;

	public CustomerSupportController(ScheduleCallService scheduleCallService,
			CustomerSupportService customerSupportService, GrievanceService grievanceService) {
		this.scheduleCallService = scheduleCallService;
		this.customerSupportService = customerSupportService;
		this.grievanceService = grievanceService;
	}

	@PostMapping("/customerservice/login")
	public ResponseEntity<String> loginCustomerService(@RequestBody CustomerSupport loginRequest) {
		return customerSupportService.loginCustomerService(loginRequest);
	}

	@GetMapping("/customerschedulecall/readall")
	public List<CustomerScheduleCallDTO> getAllCustomerScheduleCall() {
		return scheduleCallService.getAllCustomerScheduleCall();
	}

	@GetMapping("/customerschedulecall/readallpending")
	public List<CustomerScheduleCallDTO> getAllPendingCustomerScheduleCall() {
		return scheduleCallService.getAllPendingCustomerScheduleCall();
	}

	@PutMapping("/customerschedulecall/resolve/{id}")
	public ResponseEntity<Boolean> resolveCustomerScheduleCall(@PathVariable Long id) {
		return ResponseEntity.ok(scheduleCallService.resolveCustomerScheduleCall(id));
	}

	@GetMapping("/guestschedulecall/readall")
	public List<GuestScheduleCallDTO> getAllGuestScheduleCall() {
		return scheduleCallService.getAllGuestScheduleCall();
	}

	@GetMapping("/guestschedulecall/readallpending")
	public List<GuestScheduleCallDTO> getAllPendingGuestScheduleCall() {
		return scheduleCallService.getAllPendingGuestScheduleCall();
	}

	@PutMapping("/guestschedulecall/resolve/{id}")
	public ResponseEntity<Boolean> resolveGuestScheduleCall(@PathVariable Long id) {
		return ResponseEntity.ok(scheduleCallService.resolveGuestScheduleCall(id));
	}

	@GetMapping("/customergrievance/readall")
	public List<CustomerGrievanceDTO> getAllCustomerGrievances() {
		return grievanceService.getAllCustomerGrievances();
	}

	@GetMapping("/customergrievance/readallpending")
	public List<CustomerGrievanceDTO> getAllPendingCustomerGrievances() {
		return grievanceService.getAllPendingCustomerGrievances();
	}

	@PutMapping("/customergrievance/resolve/{id}")
    public ResponseEntity<Boolean> resolveCustomerGrievance(@PathVariable Long id, @RequestBody Map<String, String> body) {
        String message = body.get("message");
        return ResponseEntity.ok(grievanceService.resolveCustomerGrievance(id, message));
    }

	@GetMapping("/guestgrievance/readall")
	public List<GuestGrievanceDTO> getAllGuestGrievances() {
		return grievanceService.getAllGuestGrievances();
	}

	@GetMapping("/guestgrievance/readallpending")
	public List<GuestGrievanceDTO> getAllPendingGuestGrievances() {
		return grievanceService.getAllPendingGuestGrievances();
	}

	@PutMapping("/guestgrievance/resolve/{id}")
    public ResponseEntity<Boolean> resolveGuestGrievance(@PathVariable Long id, @RequestBody Map<String, String> body) {
        String message = body.get("message");
        return ResponseEntity.ok(grievanceService.resolveGuestGrievance(id, message));
    }
}