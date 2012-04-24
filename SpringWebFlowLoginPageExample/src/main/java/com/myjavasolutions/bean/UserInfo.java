package com.myjavasolutions.bean;

import java.io.Serializable;

import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.binding.validation.ValidationContext;


public class UserInfo implements Serializable{

	private static final long serialVersionUID = 1L;

	private String firstName;
	private String lastName;
	private String email;
	private String userId;
	private String password;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Model Validation method. Method name has to be validate plus the stateId of the flow.
	 * 
	 */
	public void validateRegisterUser(ValidationContext context) {
		MessageContext messages = context.getMessageContext();
		
		if(this.getFirstName() == null || this.getFirstName().equals("")) {
			messages.addMessage(new MessageBuilder().error().source("firstName").
	                defaultText("first name cannot be empty").build());
		}
		
		if(this.getLastName() == null || this.getLastName().equals("")) {
			messages.addMessage(new MessageBuilder().error().source("lastName").
	                defaultText("last name cannot be empty").build());
		}
		
		if(this.getEmail() == null || this.getEmail().equals("")) {
			messages.addMessage(new MessageBuilder().error().source("email").
	                defaultText("email cannot be empty").build());
		}
		
		if(this.getUserId() == null || this.getUserId().equals("")) {
			messages.addMessage(new MessageBuilder().error().source("userId").
	                defaultText("user id cannot be empty").build());
		}
		
		if(this.getPassword() == null || this.getPassword().equals("")) {
			messages.addMessage(new MessageBuilder().error().source("password").
	                defaultText("password cannot be empty").build());
		}
		
	}
}
