package com.example.dto;

import com.example.model.ResolutionStatus;

public class CustomerScheduleCallDTO {
    private Long scheduleCallId;
    private String customerName;
    private String customerEmail;
    private String customerPhone;
    private String subject;
    private String description;
    private String timeSlot;
    private ResolutionStatus status;


    public Long getScheduleCallId() {
        return scheduleCallId;
    }

    public void setScheduleCallId(Long scheduleCallId) {
        this.scheduleCallId = scheduleCallId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public ResolutionStatus getStatus() {
        return status;
    }

    public void setStatus(ResolutionStatus status) {
        this.status = status;
    }
}
