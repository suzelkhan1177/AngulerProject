package com.exam.examportal;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepositry extends JpaRepository<Question, Long> {

	Set<Question> findByQuiz(Quiz quiz);

}
