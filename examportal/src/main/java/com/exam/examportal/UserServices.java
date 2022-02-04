package com.exam.examportal;
import java.util.*;

public interface UserServices {
	
	//Create user
	public UsersEntity  createUser(UsersEntity  user, Set<UserRoleEntity> userRoles) throws Exception;
	
	
	
	//Get User
	public UsersEntity getUser(String userName);
	
	//Delete User
	public void deleteUser(Long userId);
	
	//update user
	public UsersEntity updataUser(UsersEntity user );

}
