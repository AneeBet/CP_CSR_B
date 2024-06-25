package com.example.dto;

import com.example.model.ResolutionStatus;

public class GuestScheduleCallDTO {
	 private Long scheduleCallId;
	    private String guestName;
	    private String guestEmail;
	    private String guestPhone;
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
		public String getGuestName() {
			return guestName;
		}
		public void setGuestName(String guestName) {
			this.guestName = guestName;
		}
		public String getGuestEmail() {
			return guestEmail;
		}
		public void setGuestEmail(String guestEmail) {
			this.guestEmail = guestEmail;
		}
		public String getGuestPhone() {
			return guestPhone;
		}
		public void setGuestPhone(String guestPhone) {
			this.guestPhone = guestPhone;
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
