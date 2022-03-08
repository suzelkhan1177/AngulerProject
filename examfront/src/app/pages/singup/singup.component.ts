import { asLiteral } from '@angular/compiler/src/render3/view/util';
import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-singup',
  templateUrl: './singup.component.html',
  styleUrls: ['./singup.component.css']
})
export class SingupComponent implements OnInit {

  constructor(private router :Router, private userService :UserService, private snake :MatSnackBar) { }
 
  // Data Binding
  public user ={
    profile:'',
    username: '',
    password: '',
    firstname: '',
    lastname: '',
    emailId:'',
    phone:'',
  };

  ngOnInit(): void {
  }

  formSubmit(){
     console.log(this.user);
     if(this.user.username == '' || this.user.username == 'null'){
   
    
      Swal.fire("User is Required !!");
       return;
     }

     // AddUser :userService
     this.userService.adduser(this.user).subscribe(
       (data : any)=>{
         //success
         console.log(data);
          Swal.fire('Successfully Done !!', 'User Id is ' + data.id, 'success').then((e) =>{
            this.router.navigate(['/login']);
         });
       },
       (error)=>{
         //error
         console.log(error);
         Swal.fire('Error', 'Some Thing Went Wrong....', 'error');
         
       }
     )
    
  }

}
