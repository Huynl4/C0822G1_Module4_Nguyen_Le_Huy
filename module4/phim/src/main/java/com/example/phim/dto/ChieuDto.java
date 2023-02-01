package com.example.phim.dto;

import com.example.phim.model.Phim;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class ChieuDto implements Validator {
    private Long id;
    @NotBlank(message = "ko được trống")
    @Pattern(regexp = "^[C][I][0-9]{4}")
    private String code;

    @NotBlank(message = "ngày phải đúng định dạng")
    private String date;

    @Min(value = 1,message = "số lượng vé phải là số dương")
    private String amount;

    private Phim phim;

    public ChieuDto() {
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Phim getPhim() {
        return phim;
    }

    public void setPhim(Phim phim) {
        this.phim = phim;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
