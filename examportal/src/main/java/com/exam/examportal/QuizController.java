package com.exam.examportal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class QuizController {
	
	@Autowired
	private QuizServices quizService;
	
	//add Quiz
	@PostMapping("/")
	public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz quiz){
		
		return ResponseEntity.ok(this.quizService.addQuiz(quiz));
	   }
	
	    //Update Quiz
		@PutMapping("/")
		public ResponseEntity<Quiz> updateQuiz(@RequestBody Quiz quiz){
			
			return ResponseEntity.ok(this.quizService.updateQuiz(quiz));
		}
		
		
		//get All Quiz
		@GetMapping("/")
		public ResponseEntity<?> quizzes(){
			
			return ResponseEntity.ok(this.quizService.getQuiz());
		}
		
		//get quiz
		@GetMapping("/{qid}")
		public Quiz getQuiz(@PathVariable("qid") Long qid) {
			
			return this.quizService.getQuiz(qid);
		}
		
		@DeleteMapping("/{qid}")
		public void deleteQuiz(@PathVariable("qid") Long qid) {
			
			this.quizService.deleteQuiz(qid);
		}
		
		 @GetMapping("/category/{cid}")
		public List<Quiz> getQuizOfCategory(@PathVariable("cid") Long  cid)
		 {
			 Category category = new Category();
			 category.setCid(cid);
			 
			 return this.quizService.getQuizzesOfCategory(category);
			
		}
		 
		 //get Active Quiz
		 
	  @GetMapping("/active")
	  public List<Quiz> getActiveQuizzes() {
			
			return this.quizService.getActiveQuizzes();
		}
	  

		 @GetMapping("/category/active/{cid}")
		public List<Quiz> getActiveQuizzes(@PathVariable("cid") Long  cid)
		 {
			 Category category = new Category();
			 category.setCid(cid);
			 
			 return this.quizService.getActiveQuizzesOfCategory(category);
			
		}
		

}
