package com.example.exercise_blog.repository;

import com.example.exercise_blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IBlogRepository extends JpaRepository<Blog, Long> {
    @Query(value = "select * from blog  where blog.title like concat('%', :title,'%') ", nativeQuery = true)
    Page<Blog> findAllByTitleContaining(Pageable pageable, @Param("title") String title);
}
