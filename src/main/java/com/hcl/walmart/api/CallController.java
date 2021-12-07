/*package com.hcl.walmart.api;


 import  org.springframework.boot.autoconfigure.data.web.SpringDataWebAutoConfiguration;

import java.net.URI;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
@RestController
@RequestMapping("/user")
public class CallController implements ApplicationRunner {
	   private final static String ACCOUNT_SID = "ACb3e617fd46b7685c3399dd2cbde0e357";
	   private final static String AUTH_ID = "0b6f143147fe0f64f691b0ba0e84b565";

	   static {
	      Twilio.init(ACCOUNT_SID, AUTH_ID);
	   }
	  
	  // @Override
	 //  @RequestMapping("/call")
	/*   public void run(ApplicationArguments arg0) throws Exception {
	      Message.creator(new PhoneNumber("+918919073035"), new PhoneNumber("+13476730212"),
	         "Message from Spring Boot Application").create();*/
		/*    @Override
	   @RequestMapping("/voiceCall")
	   public void run(ApplicationArguments arg0) throws Exception {
	      Call.creator(new PhoneNumber("+918919073035"), new PhoneNumber("+13476730212"),
	         new URI("http://demo.twilio.com/docs/voice.xml")).create();*/
	 //  }
	 //  }
	
