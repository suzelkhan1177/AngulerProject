package com.exam.examportal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	//add Category
	@PostMapping("/")
	public ResponseEntity<Category> addCategory(@RequestBody Category category){
		
		Category category1 = this.categoryService.addCategory(category);
		return ResponseEntity.ok(category1);
	}
	
	//get Category
	@GetMapping("/{categoryId}")
	public Category getCategory(@PathVariable("categoryId") Long categoryId) {
		
		return this.categoryService.getCategory(categoryId);
	}
	
	
	//get All Category
	@GetMapping("/")
    public ResponseEntity<?> getCategorys(){
    	
    	return ResponseEntity.ok(this.categoryService.getCategory());
    }
	
	//Upadte category
	@PutMapping("/")
	public  Category updateCategory(@RequestBody Category category) {
		
		return this.categoryService.updateCategory(category);
	}
	
	
	//Delete Category
		@DeleteMapping("/{categoryId}")
		public void deleteCategory(@PathVariable("categoryId") Long categoryId) {
			
			this.categoryService.deleteCategory(categoryId); 
		}
	
	
	
	

}
