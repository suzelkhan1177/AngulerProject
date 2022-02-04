import { asLiteral } from "@angular/compiler/src/render3/view/util";
import { Component, OnInit } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { QuizService } from "src/app/services/quiz.service";
import Swal from "sweetalert2";

@Component({
  selector: "app-instruction",
  templateUrl: "./instruction.component.html",
  styleUrls: ["./instruction.component.css"],
})
export class InstructionComponent implements OnInit {
  qId: any;
  quiz: any;

  constructor(private _route: ActivatedRoute, private _quiz: QuizService, private _router :Router) {}

  ngOnInit(): void {
    this.qId = this._route.snapshot.params["qid"];
    // console.log(this.qId);

    this._quiz.getQuiz(this.qId).subscribe(
      (data: any) => {
        this.quiz = data;
      },
      (error: any) => {
        console.log(error);
      }
    );
  }

  public startQuiz(){
    
    Swal.fire({
      title: 'Do you want to start tha quiz?',
      showDenyButton: true,
      // showCancelButton: true,
      confirmButtonText: 'Start',
      denyButtonText: `Don't Start`,
      icon :"info"
    }).then((result) => {
      /* Read more about isConfirmed, isDenied below */
      if (result.isConfirmed) {
        Swal.fire('Started !!', '', 'question');
   
        this._router.navigate(['/start/'+ this.qId]);

      } else if (result.isDenied) {
        Swal.fire(`Don't Start`, '', 'info')
      }
    })
  }

}
