package com.exam.examportal;

import java.util.Set;

public interface QuestionServices {

	     public Question addQuestion(Question question);
		
		public Question updateQuestion(Question question);
		
		public Set<Question>  getQuestions();
		
		
		public Question getQuestion(Long questionId);
		
		public Set<Question>  getQuestionofQuiz(Quiz quiz);
		
		public void deleteQuestion(Long quesid);
		
	 public Question getQ(Long questionId);
}
