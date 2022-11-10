package com.greatlearning.lab6.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;


import com.greatlearning.lab6.dao.StudentRepository;
import com.greatlearning.lab6.dao.UserRepository;
import com.greatlearning.lab6.entity.Role;
import com.greatlearning.lab6.entity.User;



@Configuration
public class BootStrapAppData {

	
	@Autowired
	private PasswordEncoder passwordencoder;
	
	@Autowired
	private UserRepository userRepository;

	@EventListener(ApplicationReadyEvent.class)
	public void insertUsers(ApplicationReadyEvent event)
	{
		 Role userrole = new Role();
		  userrole.setName("USER");
		  Role adminrole = new Role();
		  adminrole.setName("ADMIN");
		
		if(userRepository.findByUserName("vinay").isEmpty()) {
		  User vinay = new User(); 
		  vinay.setUserName("vinay");
		  vinay.setPassword(passwordencoder.encode("welcome"));
		  vinay.setEmailAddress("vinay@gmail.com");
		  vinay.addRole(adminrole);
		  vinay.addRole(userrole);
		  this.userRepository.save(vinay);
		  	
		}
		
		if(userRepository.findByUserName("sahal").isEmpty()) {
			 User sahal = new User();
			  sahal.setUserName("sahal");
			  sahal.setPassword(passwordencoder.encode("welcome"));
			  sahal.setEmailAddress("sahal@gmail.com");
			  sahal.addRole(userrole);
			
			  this.userRepository.save(sahal);
			  	
			}
	
		 
		
	}
	

	
}
