package com.example.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.dto.CustomerGrievanceDTO;
import com.example.dto.CustomerScheduleCallDTO;
import com.example.dto.GuestGrievanceDTO;
import com.example.dto.GuestScheduleCallDTO;
import com.example.model.CustomerSupport;
import com.example.service.CustomerSupportService;
import com.example.service.GrievanceService;
import com.example.service.ScheduleCallService;

public class CustomerSupportControllerTest {

    @Mock
    private ScheduleCallService scheduleCallService;

    @Mock
    private CustomerSupportService customerSupportService;

    @Mock
    private GrievanceService grievanceService;

    @InjectMocks
    private CustomerSupportController customerSupportController;

    private CustomerSupport customerSupport;
    private Map<String, String> requestBody;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        customerSupport = new CustomerSupport();
        customerSupport.setUsername("support@example.com");
        customerSupport.setPassword("password");

        requestBody = Map.of("message", "Resolution message");
    }

    @Test
    void testLoginCustomerService() {
        when(customerSupportService.loginCustomerService(any(CustomerSupport.class)))
                .thenReturn(ResponseEntity.ok("Login Successful"));

        ResponseEntity<String> response = customerSupportController.loginCustomerService(customerSupport);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Login Successful", response.getBody());
        verify(customerSupportService, times(1)).loginCustomerService(customerSupport);
    }

    @Test
    void testGetAllCustomerScheduleCall() {
        List<CustomerScheduleCallDTO> scheduleCalls = List.of(new CustomerScheduleCallDTO());
        when(scheduleCallService.getAllCustomerScheduleCall()).thenReturn(scheduleCalls);

        List<CustomerScheduleCallDTO> response = customerSupportController.getAllCustomerScheduleCall();

        assertEquals(scheduleCalls, response);
        verify(scheduleCallService, times(1)).getAllCustomerScheduleCall();
    }

    @Test
    void testGetAllPendingCustomerScheduleCall() {
        List<CustomerScheduleCallDTO> scheduleCalls = List.of(new CustomerScheduleCallDTO());
        when(scheduleCallService.getAllPendingCustomerScheduleCall()).thenReturn(scheduleCalls);

        List<CustomerScheduleCallDTO> response = customerSupportController.getAllPendingCustomerScheduleCall();

        assertEquals(scheduleCalls, response);
        verify(scheduleCallService, times(1)).getAllPendingCustomerScheduleCall();
    }

    @Test
    void testResolveCustomerScheduleCall() {
        when(scheduleCallService.resolveCustomerScheduleCall(1L)).thenReturn(true);

        ResponseEntity<Boolean> response = customerSupportController.resolveCustomerScheduleCall(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody());
        verify(scheduleCallService, times(1)).resolveCustomerScheduleCall(1L);
    }

    @Test
    void testGetAllGuestScheduleCall() {
        List<GuestScheduleCallDTO> scheduleCalls = List.of(new GuestScheduleCallDTO());
        when(scheduleCallService.getAllGuestScheduleCall()).thenReturn(scheduleCalls);

        List<GuestScheduleCallDTO> response = customerSupportController.getAllGuestScheduleCall();

        assertEquals(scheduleCalls, response);
        verify(scheduleCallService, times(1)).getAllGuestScheduleCall();
    }

    @Test
    void testGetAllPendingGuestScheduleCall() {
        List<GuestScheduleCallDTO> scheduleCalls = List.of(new GuestScheduleCallDTO());
        when(scheduleCallService.getAllPendingGuestScheduleCall()).thenReturn(scheduleCalls);

        List<GuestScheduleCallDTO> response = customerSupportController.getAllPendingGuestScheduleCall();

        assertEquals(scheduleCalls, response);
        verify(scheduleCallService, times(1)).getAllPendingGuestScheduleCall();
    }

    @Test
    void testResolveGuestScheduleCall() {
        when(scheduleCallService.resolveGuestScheduleCall(1L)).thenReturn(true);

        ResponseEntity<Boolean> response = customerSupportController.resolveGuestScheduleCall(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody());
        verify(scheduleCallService, times(1)).resolveGuestScheduleCall(1L);
    }

    @Test
    void testGetAllCustomerGrievances() {
        List<CustomerGrievanceDTO> grievances = List.of(new CustomerGrievanceDTO());
        when(grievanceService.getAllCustomerGrievances()).thenReturn(grievances);

        List<CustomerGrievanceDTO> response = customerSupportController.getAllCustomerGrievances();

        assertEquals(grievances, response);
        verify(grievanceService, times(1)).getAllCustomerGrievances();
    }

    @Test
    void testGetAllPendingCustomerGrievances() {
        List<CustomerGrievanceDTO> grievances = List.of(new CustomerGrievanceDTO());
        when(grievanceService.getAllPendingCustomerGrievances()).thenReturn(grievances);

        List<CustomerGrievanceDTO> response = customerSupportController.getAllPendingCustomerGrievances();

        assertEquals(grievances, response);
        verify(grievanceService, times(1)).getAllPendingCustomerGrievances();
    }

    @Test
    void testResolveCustomerGrievance() {
        when(grievanceService.resolveCustomerGrievance(1L, "Resolution message")).thenReturn(true);

        ResponseEntity<Boolean> response = customerSupportController.resolveCustomerGrievance(1L, requestBody);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody());
        verify(grievanceService, times(1)).resolveCustomerGrievance(1L, "Resolution message");
    }

    @Test
    void testGetAllGuestGrievances() {
        List<GuestGrievanceDTO> grievances = List.of(new GuestGrievanceDTO());
        when(grievanceService.getAllGuestGrievances()).thenReturn(grievances);

        List<GuestGrievanceDTO> response = customerSupportController.getAllGuestGrievances();

        assertEquals(grievances, response);
        verify(grievanceService, times(1)).getAllGuestGrievances();
    }

    @Test
    void testGetAllPendingGuestGrievances() {
        List<GuestGrievanceDTO> grievances = List.of(new GuestGrievanceDTO());
        when(grievanceService.getAllPendingGuestGrievances()).thenReturn(grievances);

        List<GuestGrievanceDTO> response = customerSupportController.getAllPendingGuestGrievances();

        assertEquals(grievances, response);
        verify(grievanceService, times(1)).getAllPendingGuestGrievances();
    }

    @Test
    void testResolveGuestGrievance() {
        when(grievanceService.resolveGuestGrievance(1L, "Resolution message")).thenReturn(true);

        ResponseEntity<Boolean> response = customerSupportController.resolveGuestGrievance(1L, requestBody);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody());
        verify(grievanceService, times(1)).resolveGuestGrievance(1L, "Resolution message");
    }
}
