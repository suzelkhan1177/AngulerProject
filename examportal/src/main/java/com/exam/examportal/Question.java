package com.exam.examportal;



import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private  Long qesid;
	
	@Column(length = 5000)
	private String content;
	
	private String image;
	private String Option1;
	
	private String Option2;
	private String Option3;
	private String Option4;
	
	@Transient
	private String givenAnswer;
	
	
	private String answer;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Quiz quiz;
	
	public Question() {
		
	}
	
	

	public String getGivenAnswer() {
		return givenAnswer;
	}



	public void setGivenAnswer(String givenAnswer) {
		this.givenAnswer = givenAnswer;
	}



	public Long getQesid() {
		return qesid;
	}

	public void setQesid(Long qesid) {
		this.qesid = qesid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getOption1() {
		return Option1;
	}

	public void setOption1(String option1) {
		Option1 = option1;
	}

	public String getOption3() {
		return Option3;
	}

	public void setOption3(String option3) {
		Option3 = option3;
	}

	public String getOption4() {
		return Option4;
	}

	public void setOption4(String option4) {
		Option4 = option4;
	}

	 
	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	public String getOption2() {
		return Option2;
	}

	public void setOption2(String option2) {
		Option2 = option2;
	}
	
	

}

