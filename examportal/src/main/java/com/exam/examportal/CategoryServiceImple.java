package com.exam.examportal;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImple implements CategoryService {

	  
	@Autowired
	private CategoryRepositry categoryRepositary;
	
	@Override
	public Category addCategory(Category category) {
		
		return this.categoryRepositary.save(category);
	}

	@Override
	public Category updateCategory(Category category) {
		
		return this.categoryRepositary.save(category);
	}

	@Override
	public Set<Category> getCategory() {
		
		return new LinkedHashSet<>(this.categoryRepositary.findAll());
	}

	@Override
	public Category getCategory(Long categoryId) {
	
		return this.categoryRepositary.findById(categoryId).get();
	}

	@Override
	public void deleteCategory(Long categoryId) {
		
		Category category = new Category();
		category.setCid(categoryId);
		
		this.categoryRepositary.delete(category);
		
	}

}
