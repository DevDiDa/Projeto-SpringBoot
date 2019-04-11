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
			createUser("Diego", "diego.diniz@novaandradina.org");
			createUser("Maria", "maria.fe@gmail.com");
			createUser("Carol", "caroline@hotmial.com");
			createUser("Dorgil", "dodo@hotmail.com");
			
		}
		
		
			///*usado para deletar por Id*/
//		  userRepository.deleteById(3L);
		
		///*Metodo usado para buscar por ID*/
		//User user = userRepository.getOne(2L);
		///*setando direto no get o nome */
	    //user.setNome("CARALEO");
	    
	 //   /*adicionando no repository o usuario*/
	    //userRepository.save(user);
		
	  //  /*buscando pelo inicial de letras*/
		
		User user = userRepository.findByNome("c");
		System.out.println(user.getNome());
		
		
	}
	
	public void createUser(String nome, String email) {
		User user = new User(nome, email);
	    userRepository.save(user);
	}

}
