package com.exam.examportal;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ExamportalApplication  implements CommandLineRunner{
	
	@Autowired
	private UserServices userservice;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		
		SpringApplication.run(ExamportalApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
	
		System.out.println("Start Runing");
		
//		UsersEntity  user = new UsersEntity();
//
//		user.setUsername("suzel11");
//		user.setFirstname("suzel");
//		user.setLastname("Khan");
//		user.setEmailId("suzelkhan44@gmail.com");
//		user.setPassword(this.bCryptPasswordEncoder.encode("abc"));
//		user.setProfile("deafult.png");
//		user.setPhone("7830876003");
//
//		RoleEntity role1 = new RoleEntity();
//
//		role1.setRollid(44L);
//		role1.setRollname("Admin");
//
//		Set<UserRoleEntity> userRoleSet = new HashSet<>();
//
//		UserRoleEntity userRole = new UserRoleEntity();
//
//		userRole.setRoles(role1);
//		userRole.setUser(user);
//
//		userRoleSet.add(userRole);
//
//		UsersEntity user1 = this.userservice.createUser(user, userRoleSet);
//
//		System.out.println(user1.getUsername());
		
	}

}
