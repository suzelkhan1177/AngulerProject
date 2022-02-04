import { LocationStrategy } from "@angular/common";
import { Component, OnInit } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { QuestionService } from "src/app/services/question.service";
import Swal from "sweetalert2";

@Component({
  selector: "app-start",
  templateUrl: "./start.component.html",
  styleUrls: ["./start.component.css"],
})
export class StartComponent implements OnInit {
  qId: any;
  questions: any;

  marksGot = 0;
  correctAnswer = 0;
  Attempted = 0;

  isSubmit = false;

  timer: any;

  constructor(
    private locationSt: LocationStrategy,
    private _route: ActivatedRoute,
    private _question: QuestionService
  ) {}

  ngOnInit(): void {
    this.preventBackButton();

    this.qId = this._route.snapshot.params["qid"];
    // console.log(this.qId);

    this.loadQuestion();
    this.startTimer();
  }

  loadQuestion() {
    this._question.getQuestionOfQuiz(this.qId).subscribe(
      (data: any) => {
        //success
        this.questions = data;

        this.timer = this.questions.length * 2 * 60;

        // this.questions.forEach((q: any) => {
        //   q["givenAnswer"] = "";
        // });

        // console.log(this.questions);
      },
      (error: any) => {
        //error
        console.log(error);
        Swal.fire("Error", "Some Thing Went Wrong....", "error");
      }
    );
  }

  preventBackButton() {
    history.pushState(null, location.href);

    this.locationSt.onPopState(() => {
      history.pushState(null, location.href);
    });
  }

  public SubmitQuiz() {
    Swal.fire({
      title: "Do you want to submit tha quiz?",

      showCancelButton: true,
      confirmButtonText: "Submit",
      icon: "info",
    }).then((e) => {
      if (e.isConfirmed) {
        this.evilQuiz();
      }
    });
  }

  startTimer() {
    let t = window.setInterval(() => {
      if (this.timer <= 0) {
        this.evilQuiz();
        clearInterval(t);
      } else {
        this.timer--;
      }
    }, 1000);
  }

  getFormatTime() {
    let mm = Math.floor(this.timer / 60);
    let ss = this.timer - mm * 60;

    return `${mm} mm : ${ss} ss`;
  }

  evilQuiz() {
    

    this._question.evelQuiz(this.questions).subscribe(
      (data: any) => {
         this.isSubmit = true;
         this.Attempted = data.attemped;
         this.correctAnswer = data.correctAnswer;
         this.marksGot = parseFloat(Number(data.marksGot).toFixed(2));
         
      },
       (error) => {
        console.log(error);
      }
    );

    // this.questions.forEach((q: any) => {
    //   if (q.givenAnswer == q.answer) {
    //     this.correctAnswer++;
    //     let marksSingle =
    //       this.questions[0].quiz.maxMarks / this.questions.length;

    //     this.marksGot += marksSingle;
    //   }

    //   if (q.givenAnswer.trim() != "") {
    //     this.Attempted++;
    //   }
    // });
  }

printPage(){
 
    window.print();
}

}
