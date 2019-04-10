package br.com.springboot.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.springboot.model.User;
import br.com.springboot.repository.UserRepository;



@Component
public class DataInitilizr implements ApplicationListener<ContextRefreshedEvent>{


	@Autowired
	UserRepository userRepository;
	
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		List<User> users = userRepository.findAll();
		
		if (users.isEmpty()) {
			User user = new User();
			user.setNome("Diego Danniel");
			user.setEmail("diego.diniz.dev@gmail.com");
			
			userRepository.save(user);
		}
		
	}

}
