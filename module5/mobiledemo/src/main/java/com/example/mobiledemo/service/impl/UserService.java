package com.example.mobiledemo.service.impl;

import com.example.mobiledemo.model.User;
import com.example.mobiledemo.repository.IUserRepository;
import com.example.mobiledemo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;

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

    @Override
    public Page<User> findAll(String genderSearch,String ageSearch,Pageable pageable) {
        return userRepository.findAll(genderSearch,ageSearch,pageable);
    }
}
