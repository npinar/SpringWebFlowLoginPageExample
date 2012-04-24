package com.myjavasolutions.flow;
import org.junit.Test;
import org.springframework.webflow.config.FlowDefinitionResource;
import org.springframework.webflow.config.FlowDefinitionResourceFactory;
import org.springframework.webflow.engine.Flow;
import org.springframework.webflow.engine.RequestControlContext;
import org.springframework.webflow.engine.State;
import org.springframework.webflow.execution.FlowExecutionException;
import org.springframework.webflow.test.MockExternalContext;
import org.springframework.webflow.test.MockFlowBuilderContext;
import org.springframework.webflow.test.execution.AbstractXmlFlowExecutionTests;

import com.myjavasolutions.actions.UserLoginAction;
import com.myjavasolutions.bean.LoginInfo;


public class LoginFlowExecutionTest extends AbstractXmlFlowExecutionTests {

	@Override
	protected FlowDefinitionResource getResource(FlowDefinitionResourceFactory resourceFactory) {

		return resourceFactory.createFileResource("src/main/webapp/WEB-INF/flows/login.xml");
	}

	@Override
	protected void configureFlowBuilderContext(MockFlowBuilderContext builderContext) {

		//creating a stub subflow and registering it with builder context
		Flow registerme = new Flow("registerme");
		
		 State start = new State(registerme, "registerUser") {
		        @Override
		        protected void doEnter(RequestControlContext context)
		                throws FlowExecutionException {
		            // empty
		        }
		    };
		    
		    registerme.setStartState(start);
		    builderContext.registerSubflow(registerme);
		
	}

	@Test
	public void test_User_Logined_Successfully() throws Exception {
		
		setCurrentState("login");
		
		LoginInfo loginInfo = new LoginInfo();
		loginInfo.setUserId("someuser");
		loginInfo.setPassword("12345");
		
		getFlowScope().put("userLoginAction", new UserLoginAction());
		getFlowScope().put("loginInfo", loginInfo);
		
		MockExternalContext context = new MockExternalContext();
	    context.setEventId("loginUser");
	    resumeFlow(context);

	    assertFlowExecutionEnded();
	}
	
	@Test
	public void test_user_Reset_Successfully() throws Exception {
		
		setCurrentState("login");
		
		LoginInfo loginInfo = new LoginInfo();
		loginInfo.setUserId("someuser");
		loginInfo.setPassword("12345");
		
		getFlowScope().put("userLoginAction", new UserLoginAction());
		getFlowScope().put("loginInfo", loginInfo);
		
		MockExternalContext context = new MockExternalContext();
	    context.setEventId("reset");
	    resumeFlow(context);

	   assertCurrentStateEquals("login");
	   assertEquals("", loginInfo.getUserId());
	   assertEquals("", loginInfo.getPassword());
	}
	
	@Test
	public void test_User_Logined_With_Invalid_Password() throws Exception {
		
		setCurrentState("login");
		
		LoginInfo loginInfo = new LoginInfo();
		loginInfo.setUserId("someuser");
		loginInfo.setPassword("123");
		
		getFlowScope().put("userLoginAction", new UserLoginAction());
		getFlowScope().put("loginInfo", loginInfo);
		
		MockExternalContext context = new MockExternalContext();
	    context.setEventId("loginUser");
	    resumeFlow(context);

	    assertCurrentStateEquals("login");
		assertEquals("someuser",loginInfo.getUserId());
		assertEquals("123", loginInfo.getPassword());
	}
	
	@Test
	public void test_User_Logined_With_Invalid_User_ID() throws Exception {
		
		setCurrentState("login");
		
		LoginInfo loginInfo = new LoginInfo();
		//npinar is not existing in the database
		loginInfo.setUserId("npinar");
		loginInfo.setPassword("12345");
		
		getFlowScope().put("userLoginAction", new UserLoginAction());
		getFlowScope().put("loginInfo", loginInfo);
		
		MockExternalContext context = new MockExternalContext();
	    context.setEventId("loginUser");
	    resumeFlow(context);

	    assertCurrentStateEquals("registerUser");
	}
	
	
	
	
}
