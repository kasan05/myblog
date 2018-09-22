package com.abc.myblog;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.abc.myblog.dto.BlogDto;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CucumberMyBlogStepDefinition {

	@Autowired
	RestTemplate restTemplate;
	
	static ResponseEntity<BlogDto> responseEntity = null;
	
	@When("^When We create a Blog") 
	public void create_Blog() {
		responseEntity = createBlog();
		
	}
	
	@Then("^I get a CREATED response")
	public void receive_status_code(int statusCode) {
		assertThat(responseEntity.getStatusCode().equals(HttpStatus.CREATED));
	}
	
	 private ResponseEntity<BlogDto> createBlog() {
	        BlogDto blogDTO = new BlogDto();
	        blogDTO.setSubject("sample");
	        blogDTO.setContent("sample content");
	        
	        return restTemplate.exchange(
	                "/blogs",
	                HttpMethod.POST,
	                new HttpEntity<>(blogDTO),
	                BlogDto.class);
	    }
}
