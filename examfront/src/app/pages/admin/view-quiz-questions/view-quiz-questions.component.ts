import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute } from '@angular/router';
import { QuestionService } from 'src/app/services/question.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-view-quiz-questions',
  templateUrl: './view-quiz-questions.component.html',
  styleUrls: ['./view-quiz-questions.component.css']
})
export class ViewQuizQuestionsComponent implements OnInit {

   qId =0;
   qTitle :any;
   question : any;
  constructor(private _question : QuestionService,private route : ActivatedRoute,
    private _snake : MatSnackBar
    ) { }

  ngOnInit(): void {

    this.qId = this.route.snapshot.params['qid'];
    this.qTitle = this.route.snapshot.params['title'];
   
     this._question.getQuestionOfQuiz(this.qId).subscribe(
   
      (data : any) =>{
     
        this.question = data;
        console.log(this._question);

      },(error) =>{
        console.log(error);
      }

     );
    
  }

  deleteQuestion(qids :any){
    Swal.fire({
      icon : 'info',
      title : "Are you sure ?",
      confirmButtonText :'Delete',
      showCancelButton : true
    }).then((result) =>{
        
      if(result.isConfirmed){
      
        // delete ..
       this._question.deleteQuestion(qids).subscribe(
         (data: any) => {
          
    

           this.question = this.question.filter((q: any) => q.qesid != qids )
           Swal.fire("Success !!", " Question Delete Successfully !!", "success");

         },
         (error : any) => {
           console.log(error);
           Swal.fire("Error !!", "Error Quiz Delete", "error");
         }
       );
     }
    })
  }
}
