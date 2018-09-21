package com.abc.myblog;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.abc.myblog.dto.BlogDto;
import com.abc.myblog.service.BlogService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyblogApplicationTests {

	@Autowired
	private BlogService blogService;
	private String content;
	private BlogDto blogDTO;
	
	
	@Before
	public void  init() {
		 content = "testcontent";
		 blogDTO = new BlogDto();
		 blogDTO.setSubject("testsubject");
		 blogDTO.setContent(content);;
	}
	
	@Test
	public void  testSaveBlog() {
		String id = blogService.saveBlog(blogDTO);
		assertNotNull(id);
		assertEquals(content, blogDTO.getContent());
		assertEquals(content, blogDTO.getContent());
	}
	
	@Test
	public void testGetBlogById() {
		String id = blogService.saveBlog(blogDTO);
		blogDTO = blogService.getBlogById(Long.parseLong(id));
		assertNotNull(blogDTO);
		assertEquals(content, blogDTO.getContent());
	}
	
//	@Test
//	public void testDeleteBlog() {
//		String id = blogService.saveBlog(blogDTO);
//		blogService.deleteBlog(Long.parseLong(id));
//		assertNull( blogService.getBlogById(Long.parseLong(id)));
//	}

}
