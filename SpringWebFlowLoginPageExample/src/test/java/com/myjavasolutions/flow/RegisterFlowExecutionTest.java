package com.myjavasolutions.flow;

import org.junit.Test;
import org.springframework.webflow.config.FlowDefinitionResource;
import org.springframework.webflow.config.FlowDefinitionResourceFactory;
import org.springframework.webflow.test.MockExternalContext;
import org.springframework.webflow.test.execution.AbstractXmlFlowExecutionTests;

import com.myjavasolutions.actions.UserRegisterationAction;
import com.myjavasolutions.actions.UserLoginAction;
import com.myjavasolutions.bean.LoginInfo;
import com.myjavasolutions.bean.UserInfo;

public class RegisterFlowExecutionTest  extends AbstractXmlFlowExecutionTests{

	@Override
	protected FlowDefinitionResource getResource(
			FlowDefinitionResourceFactory resourceFactory) {
		return resourceFactory.createFileResource("src/main/webapp/WEB-INF/flows/register.xml");
	}
	
	@Test
	public void test_User_Registered_Successfully() throws Exception {
		
		setCurrentState("registerUser");
		
		UserInfo userInfo = new UserInfo();
		userInfo.setFirstName("nev");
		userInfo.setLastName("pin");
		userInfo.setUserId("npinar");
		userInfo.setEmail("nev@yahoo.com");
		userInfo.setPassword("12345");
		
		getFlowScope().put("userAction", new UserRegisterationAction());
		getFlowScope().put("userInfo", userInfo);
		
		MockExternalContext context = new MockExternalContext();
	    context.setEventId("submitRegistration");
	    resumeFlow(context);

	    assertFlowExecutionEnded();
	}
	
	@Test
	public void test_Invalid_Password() throws Exception {
		
		setCurrentState("registerUser");
		
		UserInfo userInfo = new UserInfo();
		userInfo.setFirstName("nev");
		userInfo.setLastName("pin");
		userInfo.setUserId("npinar");
		userInfo.setEmail("nev@yahoo.com");
		userInfo.setPassword("1234");
		
		getFlowScope().put("userAction", new UserRegisterationAction());
		getFlowScope().put("userInfo", userInfo);
		
		MockExternalContext context = new MockExternalContext();
	    context.setEventId("submitRegistration");
	    resumeFlow(context);

	    assertCurrentStateEquals("invalidPassword");
	}
	
	@Test
	public void test_Cancel_Registeration() throws Exception {
		
		setCurrentState("registerUser");
		
		UserInfo userInfo = new UserInfo();
		userInfo.setFirstName("nev");
		userInfo.setLastName("pin");
		userInfo.setUserId("npinar");
		userInfo.setEmail("nev@yahoo.com");
		userInfo.setPassword("12345");
		
		getFlowScope().put("userAction", new UserRegisterationAction());
		getFlowScope().put("userInfo", userInfo);
		
		MockExternalContext context = new MockExternalContext();
	    context.setEventId("cancel");
	    resumeFlow(context);

	    assertFlowExecutionEnded();
	    assertEquals("",userInfo.getUserId());
	    assertEquals("",userInfo.getFirstName());
	    assertEquals("",userInfo.getLastName());
	    assertEquals("",userInfo.getPassword());
	    assertEquals("",userInfo.getEmail());
	}
	
	@Test
	public void test_Reset() throws Exception {
		
		setCurrentState("registerUser");
		
		UserInfo userInfo = new UserInfo();
		userInfo.setFirstName("nev");
		userInfo.setLastName("pin");
		userInfo.setUserId("npinar");
		userInfo.setEmail("nev@yahoo.com");
		userInfo.setPassword("12345");
		
		getFlowScope().put("userAction", new UserRegisterationAction());
		getFlowScope().put("userInfo", userInfo);
		
		MockExternalContext context = new MockExternalContext();
	    context.setEventId("reset");
	    resumeFlow(context);

	    assertCurrentStateEquals("registerUser");
	    assertEquals("",userInfo.getUserId());
	    assertEquals("",userInfo.getFirstName());
	    assertEquals("",userInfo.getLastName());
	    assertEquals("",userInfo.getPassword());
	    assertEquals("",userInfo.getEmail());
	}
	

}
