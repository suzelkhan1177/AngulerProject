package com.exam.examportal;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

@Service
public class QuizServiceImp  implements QuizServices{

	 @Autowired
	private QuizRepositry quizRepositry;
	
	@Override
	public Quiz addQuiz(Quiz quiz) {
		
		return this.quizRepositry.save(quiz);
	}

	@Override
	public Quiz updateQuiz(Quiz quiz) {
		
		return this.quizRepositry.save(quiz);
	}

	@Override
	public Set<Quiz> getQuiz() {
		
		return new HashSet<>(this.quizRepositry.findAll());
	}

	@Override
	public Quiz getQuiz(Long QuizId) {
		
		return this.quizRepositry.findById(QuizId).get();
	}

	@Override
	public void deleteQuiz(Long QuizId) {
		
		
		this.quizRepositry.deleteById(QuizId);;
		
	}

	@Override
	public List<Quiz> getQuizzesOfCategory(Category category) {
	
		return this.quizRepositry.findBycategory(category);
	}

	
	 // Get Active Quizzes
	
	@Override
	public List<Quiz> getActiveQuizzes() {
		
		return this.quizRepositry.findByActive(true);
	}

	@Override
	public List<Quiz> getActiveQuizzesOfCategory(Category c) {
	
		return this.quizRepositry.findByCategoryAndActive(c, true);
	}

}
