package br.com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.springboot.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query("select u from User u where u.nome like %?1%")
	User findByNome(String nome);
	
	
}
