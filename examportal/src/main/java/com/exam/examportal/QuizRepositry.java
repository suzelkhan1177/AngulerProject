package com.exam.examportal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepositry extends JpaRepository<Quiz, Long> {
	
	public List<Quiz> findBycategory(Category category);
	
	public List<Quiz> findByActive(Boolean b);	
	
	public List<Quiz> findByCategoryAndActive(Category c, Boolean b);		

}
