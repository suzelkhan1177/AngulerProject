import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { CategoryService } from 'src/app/services/category.service';
import { QuizService } from 'src/app/services/quiz.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-add-quiz',
  templateUrl: './add-quiz.component.html',
  styleUrls: ['./add-quiz.component.css']
})
export class AddQuizComponent implements OnInit {

  categories : any;

   quizData= {

       title :'',
       description :"",
       maxMarks : "",
       quetionsCount : "",
       active : true,
       category : {
         cid :'',
       }
   };

  constructor(private cat : CategoryService ,private snack : MatSnackBar, private _quiz :QuizService) { }

  ngOnInit(): void {
   
    this.cat.categories().subscribe(

      (data:any) =>{
       
        // categories load
       this.categories = data;


      //  console.log(this.categories);
      },
      (error) =>{
        console.log(error);
        Swal.fire("Error !!", "Server Error", 'error');
      }
    )

  }

  addQuiz(){
     
    
  if(this.quizData.title.trim()=='' || this.quizData.title == null){

    this.snack.open("Title is Required !!",'',{
      duration :3000
    });
    return;
  }

  this._quiz.addQuiz(this.quizData).subscribe(
   
    (data:any) =>{
      
      Swal.fire("Success !!", "Quiz is Add Successfully", 'success');
      this.quizData= {

        title :'',
        description :"",
        maxMarks : "",
        quetionsCount : "",
        active : true,
        category : {
          cid :'',
        }
    };
    },
    (error) =>{
      console.log(error);
      Swal.fire("Error !!", " Error while add quiz", 'error');
    }

  );
     
  

  }

}
