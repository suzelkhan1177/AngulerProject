import { Component, OnInit } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { QuizService } from "src/app/services/quiz.service";
import Swal from "sweetalert2";

@Component({
  selector: "app-load-quiz",
  templateUrl: "./load-quiz.component.html",
  styleUrls: ["./load-quiz.component.css"],
})
export class LoadQuizComponent implements OnInit {
  catId: any;
  quizzes: any;
  constructor(private _route: ActivatedRoute, private _quiz: QuizService) {}

  ngOnInit(): void {
    this._route.params.subscribe((params) =>{
      
      this.catId = params["catid"];

      if (this.catId == 0) {
        console.log("Load All tha Quiz");
  
        this._quiz.getActiveQuizzes().subscribe(
          (data: any) => {
            this.quizzes = data;
            // console.log(this.quizzes);
          },
          (error) => {
            console.log(error);
            Swal.fire("Error !!", " Error Categorys Load ", "error");
          }
        );
      } else {
        console.log("Load Speacific Quiz");
       
        this._quiz.getActiveQuizzesOfCategory(this.catId).subscribe(
           
          (data: any) => {
            this.quizzes = data;
            console.log(this.quizzes);
          },
          (error) => {
            console.log(error);
            Swal.fire("Error !!", " Error Categorys Load ", "error");
          }
        );

      }
    })
    
  }
}
