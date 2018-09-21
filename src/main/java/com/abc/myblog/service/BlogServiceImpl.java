package com.abc.myblog.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abc.myblog.dto.BlogDto;
import com.abc.myblog.model.Blog;
import com.abc.myblog.repository.BlogRepository;

@Service
@Transactional
public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogRepository blogRepository;
	
	@Override
	public String saveBlog(BlogDto blogDto) {
		Blog blog = new Blog();
		blog.setContent(blogDto.getContent());
		blog.setSubject(blog.getSubject());
		Blog createdBlog  = blogRepository.save(blog);
		return String.valueOf(createdBlog.getId());
	}

	@Override
	public BlogDto getBlogById(long id) {
		Blog blog =  null;
		try {
			 blog = blogRepository.getOne(id);
		}catch(Exception e) {
			return null;
		}
		BlogDto blogDto = new BlogDto();

		blogDto.setContent(blog.getContent());
		blogDto.setId(blog.getId());
		blogDto.setSubject(blog.getSubject());
		return blogDto;
	}

	@Override
	public List<BlogDto> getAllBlog() {
		List<Blog> blogList = blogRepository.findAll();
		List<BlogDto> blogDtoList = new ArrayList<BlogDto>();
		for(Blog blog : blogList) {
			BlogDto blogDto = new BlogDto();
			blogDto.setContent(blog.getContent());
			blogDto.setId(blog.getId());
			blogDto.setSubject(blog.getSubject());
			blogDtoList.add(blogDto);
		}
		return blogDtoList;
	}

	@Override
	public String updateBlog(BlogDto blogDto) {
		Blog blog = new Blog();
		blog.setId(blogDto.getId());
		blog.setSubject(blogDto.getSubject());
		blog.setContent(blogDto.getContent());
		blog = blogRepository.save(blog);
		return String.valueOf(blog.getId());
	}

	@Override
	public void deleteBlog(long id) {
		blogRepository.deleteById(id);
	}

	
}
