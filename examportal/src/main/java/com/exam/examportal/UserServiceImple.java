package com.exam.examportal;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImple implements UserServices{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	
	// Creating User
	@Override
	public UsersEntity createUser(UsersEntity user, Set<UserRoleEntity> userRoles) throws Exception{
		
		UsersEntity local = this.userRepository.findByUsername(user.getUsername());
		
		if(local != null) {
			
			System.out.println("User is already there !!");
			throw new Exception("User Already Present");
		}else {
			
			//userCreate
			for(UserRoleEntity ur : userRoles) {
				
				roleRepository.save(ur.getRoles());
			}
			
			user.getUserRoles().addAll(userRoles);
			local = this.userRepository.save(user);
			
		}
		
		return local;
	}


	  //View User and Get Mapping
	@Override
	public UsersEntity getUser(String userName) {
	
		return this.userRepository.findByUsername(userName);
	}


	@Override
	public void deleteUser(Long userId) {
	
		 this.userRepository.deleteById(userId);
	}

     // Update User
	@Override
	public UsersEntity updataUser(UsersEntity user) {
		
		return  this.userRepository.save(user);
	}

}
