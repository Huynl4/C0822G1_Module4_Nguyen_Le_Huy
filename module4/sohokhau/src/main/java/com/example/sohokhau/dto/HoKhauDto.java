package com.example.sohokhau.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;

public class HoKhauDto implements Validator {
    private Long id;
    @NotBlank(message = "ko đc trống")
    private String code;
    @NotBlank(message = "ko đc trống nhé")
    private String name;
    @NotBlank(message = "số dương nhé ")
    private String amount;
    @NotBlank(message = "điền vào đi")
    private String date;
    @NotBlank(message = "nhập đúng địa chỉ đi")
    private String address;

    public HoKhauDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
