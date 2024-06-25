package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.GuestScheduleCall;

@Repository
public interface GuestScheduleCallRepository extends JpaRepository<GuestScheduleCall, Long> {
	@Query(value = "select * from guest_schedule_call where resolution_status = 'PENDING'", nativeQuery = true)
	public List<GuestScheduleCall> getAllPendingGuestScheduleCall();
	
    @EntityGraph(attributePaths = {"guestProfile"})
    List<GuestScheduleCall> findAll();

	
}
