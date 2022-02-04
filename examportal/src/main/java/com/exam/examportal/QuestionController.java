package com.exam.examportal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.action.internal.CollectionAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionController {
	
	@Autowired
	private QuestionServices services ;
	
	@Autowired
	private QuizServices quizServices;
	
	
	     //add question
		@PostMapping("/")
		public ResponseEntity<Question> addQuestion(@RequestBody Question question){
			
			return ResponseEntity.ok(this.services.addQuestion(question));
		}
		
		 //Update question
		@PutMapping("/")
		public ResponseEntity<Question> updateQuestion(@RequestBody Question question){
			
			return ResponseEntity.ok(this.services.updateQuestion(question));
		}
		
		
		//get all of Question of any Quid
		@GetMapping("/quiz/{qid}")
		public ResponseEntity<?> getQuestionOfQuiz(@PathVariable("qid") Long qid){
			
//			Quiz quiz = new Quiz();
//			quiz.setQid(quesid);
//		   Set<Question> questionOfQuiz =	this.questionService.getQuestionofQuiz(quiz);
//		   return ResponseEntity.ok(questionOfQuiz);
			
			
			Quiz quiz =  this.quizServices.getQuiz(qid);
			Set<Question> question = quiz.getQeustion();
			
			List<Question> list = new ArrayList(question);
			if(list.size() > Integer.parseInt(quiz.getQuetionsCount())) 
			{
				list =list.subList(0,Integer.parseInt(quiz.getQuetionsCount() +1));
				
			}
			
			list.forEach((q) ->{
				
				q.setAnswer("");
			});
			
			Collections.shuffle(list);
			
			return ResponseEntity.ok(list);
		}
		
		//get all of Question of any Quid Admin
				@GetMapping("/quiz/all/{qid}")
				public ResponseEntity<?> getQuestionOfQuizAdmin(@PathVariable("qid") Long qid){
					
					Quiz quiz = new Quiz();
					quiz.setQid(qid);
				   Set<Question> questionOfQuiz =	this.services.getQuestionofQuiz(quiz);
				   return ResponseEntity.ok(questionOfQuiz);
					
					
				}
		
	//get single Question
     @GetMapping("/{quesId}")
	public Question getQuetion(@PathVariable("quesId") Long quesid) {
    	 
    	 return this.services.getQuestion(quesid);
		
	}
		
		
   //Delete Question
     @DeleteMapping("/{quesId}")
	public void delete(@PathVariable("quesId") Long quesid) {
    	 
    	  this.services.deleteQuestion(quesid);
		
	}	
     
     
     //Eval quiz
     @PostMapping("/evel-quiz")
     public ResponseEntity<?> evelQuiz(@RequestBody List<Question> questions){
    	 
    	    System.out.println(questions);
    	    
    	   double marksGot = 0;
    	   int correctAnswer =  0;
    	   int Attempted = 0;
    	    
    	  for(Question q : questions){
    	    	
//    	    	System.out.println(q.getGivenAnswer());
    	    	
    	    	    Question question = this.services.getQ(q.getQesid());
    	    	    
    	    	    if(question.getAnswer().equals(q.getGivenAnswer())) {
    	    	    	
    	    	    	//correct 
    	    	    	correctAnswer++;
    	    	    	
    	    	  double singleMarks = Double.parseDouble(questions.get(0).getQuiz().getMaxMarks())/ questions.size();
    	    	  
    	    	     marksGot += singleMarks;
    	    	    	
    	    	    }
    	    	    	
    	    	    	if(q.getGivenAnswer() !=null) {
    	    	    		
    	    	    		Attempted++;
    	    	    	}
    	    	    	
    	    	    
    	    };
    	    
    	    Map<String, Object> map = Map.of("marksGot",marksGot, "correctAnswer", correctAnswer, 
    	    		 "attemped", Attempted);
    	    
    	    return ResponseEntity.ok(map);
    	    		
     }
		

}
