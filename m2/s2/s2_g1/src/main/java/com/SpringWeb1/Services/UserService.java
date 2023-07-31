package com.SpringWeb1.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import com.SpringWeb1.models.User;
import com.SpringWeb1.Configs.UserConfig;
import com.SpringWeb1.Repos.UserRepo;

@Service
public class UserService {
	
	@Autowired UserRepo repo;
	@Autowired @Qualifier("empty_user") private ObjectProvider<User> empty_user;
	
	public User createEmptyUser() {
		return empty_user.getObject();
	}
	
	public User createFullUser(String _username, String _name, String _lastname, Integer _age, String _description) {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(UserConfig.class);
		User u = (User) appContext.getBean("createUser", _username, _name, _lastname, _age, _description);
		appContext.close();
		return u;
	}
	
	public User getById(Long id) {
		Optional<User> opt = repo.findById(id);
		return opt.isPresent() ? opt.get() : null;
	}
	
	public List<User> getAllUsers() {
		return (List<User>) repo.findAll();
	}
	
	public void save(User u) {
		if (repo.findByUsername(u.getUsername()) == null) {
			repo.save(u);
			System.out.println("** User " + u.getUsername() + " saved correctly **");
		} else {
			System.out.println("** >> ERROR << User " + u.getUsername() + " already exists **");
		}
	}
}






















