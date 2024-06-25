package com.example.dto;



public class CustomerGrievanceDTO {
	 private Long grievanceId;
	    private String customerName;
	    private String customerEmail;
	    private String customerPhone;
	    private String subject;
	    private String description;
	    private String timestamp;
	    private String status;
		public Long getGrievanceId() {
			return grievanceId;
		}
		public void setGrievanceId(Long grievanceId) {
			this.grievanceId = grievanceId;
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
		public String getTimestamp() {
			return timestamp;
		}
		public void setTimestamp(String timestamp) {
			this.timestamp = timestamp;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
	    
	    
}
