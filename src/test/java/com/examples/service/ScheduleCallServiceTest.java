package com.examples.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.example.dto.CustomerScheduleCallDTO;
import com.example.dto.GuestScheduleCallDTO;
import com.example.model.*;
import com.example.repository.CustomerScheduleCallRepository;
import com.example.repository.GuestScheduleCallRepository;
import com.example.service.ScheduleCallService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class ScheduleCallServiceTest {

    @Mock
    private CustomerScheduleCallRepository customerScheduleCallRepository;

    @Mock
    private GuestScheduleCallRepository guestScheduleCallRepository;

    @InjectMocks
    private ScheduleCallService scheduleCallService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllCustomerScheduleCall() {
        CustomerScheduleCall call = new CustomerScheduleCall();
        call.setScheduleCallId(1L);
        call.setCustomerCardAccount(new CustomerCardAccount());
        call.getCustomerCardAccount().setCustomerProfile(new CustomerProfile());
        call.getCustomerCardAccount().getCustomerProfile().setName("John Doe");
        call.getCustomerCardAccount().getCustomerProfile().setEmail("john.doe@example.com");
        call.getCustomerCardAccount().getCustomerProfile().setMobileNumber("1234567890");
        call.setSubject("Subject");
        call.setDescription("Description");
        call.setTimeSlot("10:00 AM");
        call.setStatus(ResolutionStatus.PENDING);

        when(customerScheduleCallRepository.findAll()).thenReturn(Arrays.asList(call));

        List<CustomerScheduleCallDTO> calls = scheduleCallService.getAllCustomerScheduleCall();

        assertEquals(1, calls.size());
        verify(customerScheduleCallRepository, times(1)).findAll();
    }

    @Test
    void testGetAllPendingCustomerScheduleCall() {
        CustomerScheduleCall call = new CustomerScheduleCall();
        call.setScheduleCallId(1L);
        call.setCustomerCardAccount(new CustomerCardAccount());
        call.getCustomerCardAccount().setCustomerProfile(new CustomerProfile());
        call.getCustomerCardAccount().getCustomerProfile().setName("John Doe");
        call.getCustomerCardAccount().getCustomerProfile().setEmail("john.doe@example.com");
        call.getCustomerCardAccount().getCustomerProfile().setMobileNumber("1234567890");
        call.setSubject("Subject");
        call.setDescription("Description");
        call.setTimeSlot("10:00 AM");
        call.setStatus(ResolutionStatus.PENDING);

        when(customerScheduleCallRepository.findAllByStatus(ResolutionStatus.PENDING)).thenReturn(Arrays.asList(call));

        List<CustomerScheduleCallDTO> calls = scheduleCallService.getAllPendingCustomerScheduleCall();

        assertEquals(1, calls.size());
        verify(customerScheduleCallRepository, times(1)).findAllByStatus(ResolutionStatus.PENDING);
    }

   
    @Test
    void testResolveCustomerScheduleCall_NotFound() {
        when(customerScheduleCallRepository.findById(1L)).thenReturn(Optional.empty());

        Boolean result = scheduleCallService.resolveCustomerScheduleCall(1L);

        assertFalse(result);
        verify(customerScheduleCallRepository, times(1)).findById(1L);
        verify(customerScheduleCallRepository, times(0)).save(any(CustomerScheduleCall.class));
    }

    @Test
    void testGetAllGuestScheduleCall() {
        GuestScheduleCall call = new GuestScheduleCall();
        call.setScheduleCallId(1L);
        call.setGuestProfile(new GuestProfile());
        call.getGuestProfile().setName("Jane Doe");
        call.getGuestProfile().setGuestEmail("jane.doe@example.com");
        call.getGuestProfile().setMobileNumber("0987654321");
        call.setSubject("Subject");
        call.setDescription("Description");
        call.setTimeSlot("10:00 AM");
        call.setStatus(ResolutionStatus.PENDING);

        when(guestScheduleCallRepository.findAll()).thenReturn(Arrays.asList(call));

        List<GuestScheduleCallDTO> calls = scheduleCallService.getAllGuestScheduleCall();

        assertEquals(1, calls.size());
        verify(guestScheduleCallRepository, times(1)).findAll();
    }

    @Test
    void testGetAllPendingGuestScheduleCall() {
        GuestScheduleCall call = new GuestScheduleCall();
        call.setScheduleCallId(1L);
        call.setGuestProfile(new GuestProfile());
        call.getGuestProfile().setName("Jane Doe");
        call.getGuestProfile().setGuestEmail("jane.doe@example.com");
        call.getGuestProfile().setMobileNumber("0987654321");
        call.setSubject("Subject");
        call.setDescription("Description");
        call.setTimeSlot("10:00 AM");
        call.setStatus(ResolutionStatus.PENDING);

        when(guestScheduleCallRepository.getAllPendingGuestScheduleCall()).thenReturn(Arrays.asList(call));

        List<GuestScheduleCallDTO> calls = scheduleCallService.getAllPendingGuestScheduleCall();

        assertEquals(1, calls.size());
        verify(guestScheduleCallRepository, times(1)).getAllPendingGuestScheduleCall();
    }

   

    @Test
    void testResolveGuestGrievance_NotFound() {
        when(guestScheduleCallRepository.findById(1L)).thenReturn(Optional.empty());

        Boolean result = scheduleCallService.resolveGuestScheduleCall(1L);

        assertFalse(result);
        verify(guestScheduleCallRepository, times(1)).findById(1L);
        verify(guestScheduleCallRepository, times(0)).save(any(GuestScheduleCall.class));
    }
}
