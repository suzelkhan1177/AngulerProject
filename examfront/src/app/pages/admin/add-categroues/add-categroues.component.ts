import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { switchMap } from 'rxjs';
import { CategoryService } from 'src/app/services/category.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-add-categroues',
  templateUrl: './add-categroues.component.html',
  styleUrls: ['./add-categroues.component.css']
})
export class AddCategrouesComponent implements OnInit {

  category ={

     title :'',
     description :''
  };

  constructor(private categorys: CategoryService, private snack : MatSnackBar) { }

  ngOnInit(): void {
  }

  formSubmit(){

  if(this.category.title.trim()=='' || this.category.title == null){

    this.snack.open("Title is Required !!",'',{
      duration :3000
    });
 
     return;
  }

  //add new Category
    
    this.categorys.addCategory(this.category).subscribe(
   
      (data:any) =>{
        this.category.title= '';
        this.category.description = '';
        Swal.fire("Success !!", "Category is Add Successfully", 'success');
      },
      (error) =>{
        console.log(error);
        Swal.fire("Error !!", "Server Error", 'error');
      }

    )

  }

}


