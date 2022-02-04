import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import baseUrl from "./helper";

@Injectable({
  providedIn: "root",
})
export class QuestionService {
 
  constructor(private http: HttpClient) {}

  //get Question
  public getQuestionOfQuiz(qid: any) {
    return this.http.get(`${baseUrl}/question/quiz/all/${qid}`);
  }

  public getQuestionOfQuizTest(qid: any) {
    return this.http.get(`${baseUrl}/question/quiz/${qid}`);
  }

  // add Question
  public addQuestion(_question: any) {
    return this.http.post(`${baseUrl}/question/`, _question);
  }

  //delete Question
  public deleteQuestion(_questionId: any) {
    return this.http.delete(`${baseUrl}/question/${_questionId}`);
  }

  //evel Quiz

  public evelQuiz(question: any) {
    return this.http.post(`${baseUrl}/question/evel-quiz`,question);
  }
    
}
