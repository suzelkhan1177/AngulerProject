import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CategoryService } from 'src/app/services/category.service';
import { QuizService } from 'src/app/services/quiz.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-update-quiz',
  templateUrl: './update-quiz.component.html',
  styleUrls: ['./update-quiz.component.css']
})
export class UpdateQuizComponent implements OnInit {

   qId =0;
   quiz : any;
   categories: any;
  constructor( private route : ActivatedRoute, private _quiz : QuizService ,private category : CategoryService
    , private router :Router) { }

  ngOnInit(): void {
  
    this.qId = this.route.snapshot.params['qid'];
  
     this._quiz.getQuiz(this.qId).subscribe(
      (data :any)=>{
        this.quiz = data;
        console.log(this.quiz);
      },(error) =>{
      
         console.log(error);
      }

     );

     this.category.categories().subscribe(
      (data) => {
        //css
        this.categories = data;

        // console.log(this.categories);
      },
      (error) => {
        console.log(error);
        Swal.fire("Erroe !!", "Error in Loding data", "error");
      }
    );

  }

 public updateData(){
    
       //validation

       this._quiz.updateQuiz(this.quiz).subscribe(
        (data) => {
     
          Swal.fire("Success !!", "Update Quiz Successfully", 'success').then((e) =>{
             this.router.navigate(['/admin/quizzes']);
          })
        },
        (error) => {
          console.log(error);
          Swal.fire("Error !!", "Error in Update quiz", "error");
        }
           
       );
  }

}
