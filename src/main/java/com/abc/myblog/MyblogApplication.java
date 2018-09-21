package com.abc.myblog;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class MyblogApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyblogApplication.class, args);
	}

	@Bean
	public Docket apiDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.regex("/api.*"))
				.build()
				.apiInfo(getApiInfo());
	}
	private ApiInfo getApiInfo() {
	    return new ApiInfo(
	            "MY BLOG API",
	            "BLOGS REST API",
	            "1.0",
	            "http://sample",
	            new Contact("Kasan","http://","kasan0506@gmail.com"),
	            "LICENSE",
	            "http://",
	            Collections.emptyList()
	    );
	}
}
