package com.example.mobiledemo.service;

import com.example.mobiledemo.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserService {

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

    Page<User> findAll(String genderSearch,String ageSearch,Pageable pageable);
}
