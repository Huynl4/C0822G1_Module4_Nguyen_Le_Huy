package com.example.exercise1.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserDto implements Validator {
    private Long id;

    @NotEmpty(message = "tên không được trống")
    @Size(min = 5, max = 45, message = "độ dài 5 và tối đa 45 kí tự")
    private String firstName;

    @NotEmpty(message = "tên không được trống")
    @Size(min = 5, max = 45, message = "độ dài 5 và tối đa 45 kí tự")
    private String lastName;

    @NotEmpty(message = "SĐT không được trống")
    @Pattern(regexp = "^[0][0-9]{9}$")
    private String phoneNumber;

    @Min(18)
    private int age;

    @NotEmpty(message = "email không được trống")
    @Pattern(regexp = "^[a-zA-Z0-9]+@gmail.com$")
    private String email;

    public UserDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
