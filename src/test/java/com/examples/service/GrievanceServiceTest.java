package com.examples.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.example.dto.CustomerGrievanceDTO;
import com.example.dto.GuestGrievanceDTO;
import com.example.model.*;
import com.example.repository.CustomerGrievanceRepository;
import com.example.repository.GuestGrievanceRepository;
import com.example.service.GrievanceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class GrievanceServiceTest {

    @Mock
    private CustomerGrievanceRepository customerGrievanceRepository;

    @Mock
    private GuestGrievanceRepository guestGrievanceRepository;

    @InjectMocks
    private GrievanceService grievanceService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllCustomerGrievances() {
        CustomerGrievance grievance = new CustomerGrievance();
        grievance.setGrievanceId(1L);
        grievance.setCustomerCardAccount(new CustomerCardAccount());
        grievance.getCustomerCardAccount().setCustomerProfile(new CustomerProfile());
        grievance.getCustomerCardAccount().getCustomerProfile().setName("John Doe");
        grievance.getCustomerCardAccount().getCustomerProfile().setEmail("john.doe@example.com");
        grievance.getCustomerCardAccount().getCustomerProfile().setMobileNumber("1234567890");
        grievance.setSubject("Subject");
        grievance.setDescription("Description");
        grievance.setTimestamp(new Date());
        grievance.setStatus(ResolutionStatus.PENDING);

        when(customerGrievanceRepository.findAll()).thenReturn(Arrays.asList(grievance));

        List<CustomerGrievanceDTO> grievances = grievanceService.getAllCustomerGrievances();

        assertEquals(1, grievances.size());
        verify(customerGrievanceRepository, times(1)).findAll();
    }

    @Test
    void testGetAllPendingCustomerGrievances() {
        CustomerGrievance grievance = new CustomerGrievance();
        grievance.setGrievanceId(1L);
        grievance.setCustomerCardAccount(new CustomerCardAccount());
        grievance.getCustomerCardAccount().setCustomerProfile(new CustomerProfile());
        grievance.getCustomerCardAccount().getCustomerProfile().setName("John Doe");
        grievance.getCustomerCardAccount().getCustomerProfile().setEmail("john.doe@example.com");
        grievance.getCustomerCardAccount().getCustomerProfile().setMobileNumber("1234567890");
        grievance.setSubject("Subject");
        grievance.setDescription("Description");
        grievance.setTimestamp(new Date());
        grievance.setStatus(ResolutionStatus.PENDING);

        when(customerGrievanceRepository.getAllPendingCustomerGrievances()).thenReturn(Arrays.asList(grievance));

        List<CustomerGrievanceDTO> grievances = grievanceService.getAllPendingCustomerGrievances();

        assertEquals(1, grievances.size());
        verify(customerGrievanceRepository, times(1)).getAllPendingCustomerGrievances();
    }

   
    @Test
    void testGetAllGuestGrievances() {
        GuestGrievance grievance = new GuestGrievance();
        grievance.setGrievanceId(1L);
        grievance.setGuestProfile(new GuestProfile());
        grievance.getGuestProfile().setName("Jane Doe");
        grievance.getGuestProfile().setGuestEmail("jane.doe@example.com");
        grievance.getGuestProfile().setMobileNumber("0987654321");
        grievance.setSubject("Subject");
        grievance.setDescription("Description");
        grievance.setTimestamp(new Date());
        grievance.setStatus(ResolutionStatus.PENDING);

        when(guestGrievanceRepository.findAll()).thenReturn(Arrays.asList(grievance));

        List<GuestGrievanceDTO> grievances = grievanceService.getAllGuestGrievances();

        assertEquals(1, grievances.size());
        verify(guestGrievanceRepository, times(1)).findAll();
    }

    @Test
    void testGetAllPendingGuestGrievances() {
        GuestGrievance grievance = new GuestGrievance();
        grievance.setGrievanceId(1L);
        grievance.setGuestProfile(new GuestProfile());
        grievance.getGuestProfile().setName("Jane Doe");
        grievance.getGuestProfile().setGuestEmail("jane.doe@example.com");
        grievance.getGuestProfile().setMobileNumber("0987654321");
        grievance.setSubject("Subject");
        grievance.setDescription("Description");
        grievance.setTimestamp(new Date());
        grievance.setStatus(ResolutionStatus.PENDING);

        when(guestGrievanceRepository.getAllPendingGuestGrievances()).thenReturn(Arrays.asList(grievance));

        List<GuestGrievanceDTO> grievances = grievanceService.getAllPendingGuestGrievances();

        assertEquals(1, grievances.size());
        verify(guestGrievanceRepository, times(1)).getAllPendingGuestGrievances();
    }

    
}
