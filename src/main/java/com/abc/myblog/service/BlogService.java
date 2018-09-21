package com.abc.myblog.service;

import java.util.List;

import com.abc.myblog.dto.BlogDto;

public interface BlogService {

	String saveBlog(BlogDto blogdto);
	
	BlogDto getBlogById(long id);
	
	List<BlogDto> getAllBlog(); 
	
	String updateBlog(BlogDto blogDto);
	
	void deleteBlog(long id);
}
