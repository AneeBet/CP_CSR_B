package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.GuestGrievance;

@Repository
public interface GuestGrievanceRepository extends JpaRepository<GuestGrievance, Long> {
	@Query(value = "select * from guest_grievance where resolution_status = 'PENDING'", nativeQuery = true)
	public List<GuestGrievance> getAllPendingGuestGrievances();
	
    @EntityGraph(attributePaths = {"guestProfile"})
    List<GuestGrievance> findAll();


}
