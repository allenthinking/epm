package org.easyworld.pm.bean;

public class PmPropertyEventBean {
	
	private String propertyId;
	private String validationId;
	private String validationType;
	private String validationWay;
	private String eventName;
	private String eventId;
	private String eventType;
	private String eventLogic;
	
	public String getValidationWay() {
		return validationWay;
	}
	public void setValidationWay(String validationWay) {
		this.validationWay = validationWay;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getValidationType() {
		return validationType;
	}
	public void setValidationType(String validationType) {
		this.validationType = validationType;
	}
	public String getValidationId() {
		return validationId;
	}
	public void setValidationId(String validationId) {
		this.validationId = validationId;
	}
	public String getPropertyId() {
		return propertyId;
	}
	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
	}
	public String getEventId() {
		return eventId;
	}
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public String getEventLogic() {
		return eventLogic;
	}
	public void setEventLogic(String eventLogic) {
		this.eventLogic = eventLogic;
	}
}
