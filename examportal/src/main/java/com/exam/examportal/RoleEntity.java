package com.exam.examportal;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name ="roles")
public class RoleEntity {

	 @Id
	  private Long rollid;
	 private String rollname;
	 
	 
		@OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY , mappedBy ="roles")
		private Set<UserRoleEntity> userRoles = new HashSet<>();
		
		
		
		public Set<UserRoleEntity> getUserRoles() {
			return userRoles;
		}

		public void setUserRoles(Set<UserRoleEntity> userRoles) {
			this.userRoles = userRoles;
		}
	 
	 
	 
	 public RoleEntity(Long rollid, String rollname) {
		super();
		this.rollid = rollid;
		this.rollname = rollname;
	}

	RoleEntity(){
		 
	 }
	 
	  public Long getRollid() {
		return rollid;
	}
	public void setRollid(Long rollid) {
		this.rollid = rollid;
	}
	public String getRollname() {
		return rollname;
	}
	public void setRollname(String rollname) {
		this.rollname = rollname;
	}
	
	  
	  
	  
}
