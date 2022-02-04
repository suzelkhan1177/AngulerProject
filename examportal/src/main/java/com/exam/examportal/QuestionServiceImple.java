 package com.exam.examportal;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImple implements QuestionServices {

	@Autowired
	private QuestionRepositry questionRepositry;
	
	@Override
	public Question addQuestion(Question question) {
		
		return this.questionRepositry.save(question);
	}

	@Override
	public Question updateQuestion(Question question) {
	
		return this.questionRepositry.save(question);
	}

	@Override
	public Set<Question> getQuestions() {
		
		return new HashSet<>(this.questionRepositry.findAll());
	}

	@Override
	public Question getQuestion(Long questionId) {
		
		return this.questionRepositry.findById(questionId).get();
	}

	@Override
	public Set<Question> getQuestionofQuiz(Quiz quiz) {
	
		return this.questionRepositry.findByQuiz(quiz);
	}

	@Override
	public void deleteQuestion(Long quesid) {
		Question question = new Question();
		
		question.setQesid(quesid);
		this.questionRepositry.delete(question);
	}

	@Override
	public Question getQ(Long questionId) {
		// TODO Auto-generated method stub
		return this.questionRepositry.getOne(questionId);
	}

}
