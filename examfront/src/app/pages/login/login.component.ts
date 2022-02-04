import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  constructor(private  snack:MatSnackBar , private login:LoginService, private router : Router) { }

  ngOnInit(): void {
  }

loginData={
  
  username : "",
  password : "",

};

formSubmit(){
  console.log("Login Button Click");
  if(this.loginData.username.trim() == "" || this.loginData.username== null){

      this.snack.open("Username is Required !! ",'',{
        duration : 3000,
      });

      return;
  }

  if(this.loginData.password.trim() == "" || this.loginData.password== null){

    this.snack.open("Password is Required !! ",'',{
      duration : 3000,
    });

    return;
}
  //request to server gerate  token
  this.login.generateToken(this.loginData).subscribe(
   (data:any)=>{
    console.log("success");
    console.log(data);

// log in
   this.login.loginUser(data.token);
 this.login.getCurrentUser().subscribe(
   (user:any)=>{
  this.login.setUser(user);
   console.log(user);
  
   //rederect - Admin Dishbord
  //rederct - User Dishbord

     if(this.login.getUserRole() == 'Admin'){

      //  window.location.href ='/admin';
   this.router.navigate(['admin'])
   this.login.loginStatusSubject.next(true);
    
     }else if(this.login.getUserRole() == 'Normal'){

      
      // window.location.href ='/user-dishbord';
      this.router.navigate(['user-dishbord/0'])
      this.login.loginStatusSubject.next(true);
     }else{

      this.login.logoOut();
     }

   });

   }, 

   (error)=>{

    console.log("Error !!");
    console.log(error);

    Swal.fire("Error !!", "Server Error", 'error');
    // this.snack.open("Inviled Details !! tyr angin ",'',{
    //   duration : 3000,
    // });

   }
    
  );

}

 

}
