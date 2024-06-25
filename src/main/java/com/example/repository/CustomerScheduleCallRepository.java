package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.CustomerScheduleCall;
import com.example.model.ResolutionStatus;

@Repository
public interface CustomerScheduleCallRepository extends JpaRepository<CustomerScheduleCall, Long> {
	
	@EntityGraph(attributePaths = {"customerCardAccount.customerProfile"})
    List<CustomerScheduleCall> findAll();

    @EntityGraph(attributePaths = {"customerCardAccount.customerProfile"})
    List<CustomerScheduleCall> findAllByStatus(ResolutionStatus status);

}
