package com.example.mobiledemo.repository;

import com.example.mobiledemo.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;


@Transactional
public interface IUserRepository extends JpaRepository<User, Integer> {
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

    @Query(value = "select * from `user` where gender = :genderSearch and age = :ageSearch", nativeQuery = true)
    Page<User> findAll(@Param("genderSearch") String genderSearch,@Param("ageSearch") String ageSearch,  Pageable pageable);
}
