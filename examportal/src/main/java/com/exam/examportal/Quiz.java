package com.exam.examportal;




import java.util.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Quiz {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long qid;
	
	private String title;
	
	@Column(length = 5000)
	private String description;
	
	private String maxMarks;
	
	
	 
	private String quetionsCount ;
	
	private boolean active = false;
	
	@ManyToOne(fetch = FetchType.EAGER )
	private Category category;
	
	@OneToMany(mappedBy = "quiz", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Question> qeustion = new  HashSet<>();
	
	
	
	public Set<Question> getQeustion() {
		return qeustion;
	}



	public void setQeustion(Set<Question> qeustion) {
		this.qeustion = qeustion;
	}



	public Quiz() {
		
	}
	
	
	
	
	

	public String getQuetionsCount() {
		return quetionsCount;
	}



	public void setQuetionsCount(String quetionsCount) {
		this.quetionsCount = quetionsCount;
	}



	public Long getQid() {
		return qid;
	}

	public void setQid(Long qid) {
		this.qid = qid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMaxMarks() {
		return maxMarks;
	}

	public void setMaxMarks(String maxMarks) {
		this.maxMarks = maxMarks;
	}



	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}



	public Category getCategory() {
		return category;
	}



	public void setCategory(Category category) {
		this.category = category;
	}
	
	
	

}

