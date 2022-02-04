import { HttpClient } from '@angular/common/http';
import { Token } from '@angular/compiler/src/ml_parser/tokens';
import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  public loginStatusSubject = new  Subject<boolean>();

  constructor(private http:HttpClient) { }

//current user: which is loggin
public getCurrentUser(){
  return this.http.get(`${baseUrl}/current-user`);
}

 //generate Token
 public generateToken(loginData: any){

   return this.http.post(`${baseUrl}/generate-token`,loginData);
   
 }

 

 //login User : Set token in LocalStorage
public loginUser(token :any){
  
  localStorage.setItem('token',token);

   return true;
}

 //isLogin : user is logged  in or Not
 public isLoggedIn(){

  let tokenStr = localStorage.getItem("token");

  if(tokenStr == undefined || tokenStr =="" || tokenStr==null){
    return false;
  }else{
    return true;
  }

 }

 //logout: remove tokrn local Stroge

 public logoOut(){

  localStorage.removeItem("token");
  localStorage.removeItem("user");
  return true;
 }

 //get token
 public getToken(){
  return localStorage.getItem("token");
 }

 //set User Detiles

 public setUser(user: any){

   localStorage.setItem('user',JSON.stringify(user) );
 }

 // get user
 public getUser(){
  
   let userStr = localStorage.getItem("user");
   if(userStr != null){

     return JSON.parse(userStr);
   }else{
     this.logoOut();
     return null;
   }

 }

 //get User Role

 public getUserRole(){

  let user  = this.getUser();
 return user.authorities[0].authority;
}
 
  
}
