package com.example.mobiledemo.controller;

import com.example.mobiledemo.model.User;
import com.example.mobiledemo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/users")
public class UserRestController {

    @Autowired
    private IUserService userService;

    /**
     * Create by: HuyNL
     * Date create: 27/2/2023
     * Function: list customer & list bill history
     *
     * @param genderSearch
     * @param ageSearch
     * @param pageable
     * @return HttpStatus.OK if result is not error
     */

    @GetMapping("search/{gender}&{age}")
    public ResponseEntity<Page<User>> findAll(@PathVariable(name = "gender") String genderSearch,
                                              @PathVariable(name = "ageSearch") String ageSearch,
                                              Pageable pageable) {
        Page<User> userPage = userService.findAll(genderSearch, ageSearch, pageable);
        return new ResponseEntity<>(userPage, HttpStatus.OK);
    }
}
