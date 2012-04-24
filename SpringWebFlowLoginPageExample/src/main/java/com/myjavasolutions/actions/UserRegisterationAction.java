package com.myjavasolutions.actions;

import java.io.Serializable;

import org.springframework.webflow.core.collection.MutableAttributeMap;
import org.springframework.webflow.execution.RequestContext;
import org.springframework.webflow.scope.FlowScope;

import com.myjavasolutions.bean.UserInfo;

public class UserRegisterationAction implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public boolean validatePassword(UserInfo userInfo) {
		
		//password has to be 5 digits
		if(userInfo.getPassword().length() >= 5) {
			return true;
		}
		return false;
	}
	
	public void reset(UserInfo userInfo) {
		//clear the form
		userInfo.setEmail("");
		userInfo.setFirstName("");
		userInfo.setLastName("");
		userInfo.setPassword("");
		userInfo.setUserId("");
	}
}