package com.myjavasolutions.actions;

import java.io.Serializable;

import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;

import com.myjavasolutions.bean.LoginInfo;

public class UserLoginAction implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public void init(String accountType, LoginInfo loginInfo) {
		System.out.println("Account Type: " + accountType);
		loginInfo.setAccountType(accountType);
	}

	public boolean validateUserEntry(LoginInfo loginInfo, MessageContext messageContext) {
		
		if(loginInfo.getUserId() == null || loginInfo.getUserId().equals("")){
			messageContext.addMessage(
					new MessageBuilder().error().source("userId").defaultText("please enter your user id").build());
			return false;
			
		}
		if(loginInfo.getPassword() == null || loginInfo.getPassword().equals("")){
			messageContext.addMessage(
					new MessageBuilder().error().source("password").defaultText("please enter your password").build());
			return false;
		}
		
		//access the database and verify the password
		if(!loginInfo.getUserId().equalsIgnoreCase("npinar") && !loginInfo.getPassword().equals("12345")) {
			messageContext.addMessage(
					new MessageBuilder().error().source("password").defaultText("invalid password - enter 12345 for valid password").build());
		}
		
		return !messageContext.hasErrorMessages();
	}
	
	public boolean validateUserId(LoginInfo loginInfo,  MessageContext messageContext) {
		//check the database to see if the user id exists
		if(loginInfo.getUserId().equalsIgnoreCase("npinar")) {
			//npinar is NOT in the database, so returning false
			return false;
		}
		//userId is existing
		return true;
	}
	
	
	public void reset(LoginInfo loginInfo) {
		loginInfo.setUserId("");
		loginInfo.setPassword("");
	}
	
	public String populateUserIsNotExistingMessage() {
		return "We could not find your user id in our database. Please register!";
	}
}
