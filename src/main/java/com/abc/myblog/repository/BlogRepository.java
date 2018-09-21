package com.abc.myblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abc.myblog.model.Blog;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {

	
}
