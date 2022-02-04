package com.exam.examportal;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


@Entity
public class UserRoleEntity {
	
	@Id
	@GeneratedValue  (strategy = GenerationType.AUTO)
	private Long userRoleId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private UsersEntity user;
	
	@ManyToOne
	private RoleEntity roles;
	
	public UserRoleEntity(){
		
	}

	public Long getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Long userRoleId) {
		this.userRoleId = userRoleId;
	}

	public UsersEntity getUser() {
		return user;
	}

	public void setUser(UsersEntity user) {
		this.user = user;
	}

	public RoleEntity getRoles() {
		return roles;
	}

	public void setRoles(RoleEntity roles) {
		this.roles = roles;
	}
	


}
