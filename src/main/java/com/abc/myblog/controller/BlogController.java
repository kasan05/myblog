package com.abc.myblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.abc.myblog.dto.BlogDto;
import com.abc.myblog.service.BlogService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api/v1")
@Api(value="Blog Rest Api")
public class BlogController {

	@Autowired
	private BlogService blogService;
	
	@PostMapping(value="/blogs")
	@ApiOperation(value="Creating New Blog")
	public void addBlog(@RequestBody BlogDto blogDto) {
		blogService.saveBlog(blogDto);
	}
	
	@GetMapping(value="/blogs")
	@ApiOperation(value="Getting All Blogs in The System")
	public List<BlogDto> getAllBlogs() {
		return blogService.getAllBlog();
	}
	
	@GetMapping(value="/blog{id}")
	@ApiOperation(value="Getting a Single Blog By Its Id")
	public BlogDto getBlog(@PathVariable long id) {
		return blogService.getBlogById(id);
	}
	
	@PatchMapping(value="/blog/{id}")
	@ApiOperation(value="Updating The Existing Blog")
	public void updateBlog(@RequestBody BlogDto blogDto,@PathVariable long id) {
		blogDto.setId(id);
		blogService.updateBlog(blogDto);
	}

	@DeleteMapping(value="/blog/{id}")
	@ApiOperation(value="Deleting A Single Blog using Its Id")
	public void deleteBlog(@PathVariable long id) {
	 blogService.deleteBlog(id);
	}
	
}
