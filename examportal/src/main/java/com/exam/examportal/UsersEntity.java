package com.exam.examportal;

import java.util.*;

import javax.persistence.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users")
public class UsersEntity implements UserDetails{

	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String phone;
	private boolean enable = true;
	private String emailId;
	private String profile;
	
	
	//users Many Roles
	@OneToMany(cascade = CascadeType.ALL , fetch = FetchType.EAGER , mappedBy ="user")
	@JsonIgnore
	private Set<UserRoleEntity> userRoles = new HashSet<>();
	
	
	
	public Set<UserRoleEntity> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRoleEntity> userRoles) {
		this.userRoles = userRoles;
	}

	public UsersEntity(long id, String username, String password, String firstname, String lastname, String phone,
			boolean enable, String emailId, String profile) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.phone = phone;
		this.enable = enable;
		this.emailId = emailId;
		this.profile = profile;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	
	
	public UsersEntity() {
		
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	
		 Set<Authority> set = new HashSet<>();
		 
		 this.userRoles.forEach(userRoles -> {
			 
			 set.add(new Authority(userRoles.getRoles().getRollname()));
		 });
		
		return set;
	}

	@Override
	public boolean isAccountNonExpired() {
	
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
	
		return enable;
	}

}
