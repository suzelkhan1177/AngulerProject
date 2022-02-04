package com.exam.examportal;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private  UserServices userService;
	
	@Autowired
	private BCryptPasswordEncoder  bcryptPasswordEncoder;
	
	
	@GetMapping("/test")
	public String test() {
		return "Welcome to backend api of Examportal";
	}
	
	//create User
	@PostMapping("/")
	public UsersEntity createUser(@RequestBody UsersEntity user) throws Exception {
		
		  user.setProfile("default.png");
		  //encoding pasword by bcryptpassswordencoder
		  
		  user.setPassword(this.bcryptPasswordEncoder.encode(user.getPassword()));
		  
		Set<UserRoleEntity>  roles = new HashSet<>();
		
		  RoleEntity role = new RoleEntity();
		   role.setRollid(46L);
		   role.setRollname("Normal");
		   
		   UserRoleEntity useRole =  new UserRoleEntity();
		     useRole.setUser(user);
		      useRole.setRoles(role);
		      
		      roles.add(useRole);
		  
		
		return this.userService.createUser(user, roles );
	}
	 
	    @GetMapping("/{username}")
	   public  UsersEntity  getUser(@PathVariable("username") String userName) {
	    	
	    	return this.userService.getUser(userName);
		   
	   }
	    
	    @DeleteMapping("/{userId}")
	  public void deleteUser(@PathVariable("userId") Long userId) {
	    	
	    	this.userService.deleteUser(userId);
		  
	  }
	    
	     @PutMapping("/{userId}")
	    public UsersEntity updateUser(@PathVariable("userId")UsersEntity user) {
	    	 
	    	  return this.userService.updataUser(user);
	     }

}
