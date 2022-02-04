package com.exam.examportal;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class AuthenticationController {

	 @Autowired
	private AuthenticationManager authenticationManger;
	 
	 @Autowired
	 private  UserDeatilsServicesImpl userDeatailsServices;
	 
	 @Autowired
	 private JwtUtils jwtUtils;
	 
	 
	 //genrate token
	 @PostMapping("/generate-token")
	public ResponseEntity<?> genratetoken(@RequestBody JwtRequest jwtRequest) throws Exception{
		
		 try {
			 
			 authenticate(jwtRequest.username, jwtRequest.password);
			 
		 }catch(UsernameNotFoundException e) {
			 
			 e.printStackTrace();
		 throw new Exception("User Not Found !!");
		 }
		 
		UserDetails uersDetails = this.userDeatailsServices.loadUserByUsername(jwtRequest.getUsername());
		String token = this.jwtUtils.generateToken(uersDetails);
		 
		return ResponseEntity.ok(new JwtResponse(token));
	}
	
	private void  authenticate(String username, String password) throws Exception {
		
		try {
			
			authenticationManger.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			
		}catch(DisabledException e) {
			
			throw new Exception("USER DISABLED"+ e.getMessage());
		}catch(BadCredentialsException e) {
			
			throw new Exception("USER DISABLED"+ e.getMessage());
		}
		
	}

	// return Current User details
	
	@GetMapping("/current-user")
	public UsersEntity getCurrentUser(Principal principal) {
		
		return ((UsersEntity) this.userDeatailsServices.loadUserByUsername(principal.getName()));
	}
	
}
