	package com.exam.examportal;

import java.util.List;
import java.util.Set;

import org.springframework.http.ResponseEntity;

public interface QuizServices {
	
    public Quiz addQuiz(Quiz quiz);
	
	public Quiz updateQuiz(Quiz quiz);
	
	public Set<Quiz>  getQuiz();
	
	public Quiz getQuiz(Long QuizId);
	
	public void deleteQuiz(Long QuizId);

	public List<Quiz> getQuizzesOfCategory(Category category);
	 
      public List<Quiz> getActiveQuizzes();	
	
	public List<Quiz> getActiveQuizzesOfCategory(Category c);

}
