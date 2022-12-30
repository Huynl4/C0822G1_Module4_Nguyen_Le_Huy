package com.example.exercise_blog.controller.rest;

import com.example.exercise_blog.model.Blog;
import com.example.exercise_blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogs")
@CrossOrigin("*")
public class BlogRestController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public ResponseEntity<List<Blog>> getList() {
        List<Blog> blogList = blogService.findAll();
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<Blog> findByIDBlog(@PathVariable("id") Long id) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> add(@RequestBody Blog blog) {
        blogService.save(blog);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("")
    public ResponseEntity<?> edit(@RequestBody Blog blog) {
        blogService.save(blog);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Blog> delete(@PathVariable("id") Long id) {
        Blog blog = blogService.findById(id);
        blogService.save(blog);
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Blog>> blogSearch(@RequestParam String title) {
        return new ResponseEntity<>(blogService.searchTitle(title), HttpStatus.OK);
    }
}
