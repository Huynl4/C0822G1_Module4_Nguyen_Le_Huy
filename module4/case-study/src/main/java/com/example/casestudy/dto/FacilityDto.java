package com.example.casestudy.dto;

import com.example.casestudy.model.facility.FacilityType;
import com.example.casestudy.model.facility.RentType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class FacilityDto implements Validator {
    private Long id;
    @NotBlank(message = "không được để trông")
    private String name;

    @NotBlank(message = "không được để trông")
    @Min(value = 1, message = "Diện tích phải là một số dương")
    private int area;

    @NotBlank(message = "không được để trông")
    @Min(value = 1, message = "Gía phải là một số dương")
    private double cost;

    @NotBlank(message = "không được để trông")
    @Min(value = 1, message = "Số người tối đa phải là một số dương")
    private int maxPeople;

    @NotBlank(message = "không được để trông")
    private String standardRoom;

    @NotBlank(message = "không được để trông")
    private String description;

    @NotBlank(message = "không được để trông")
    @Min(value = 1, message = "Diện tích bể bơi phải là một số dương")
    private double poolArea;

    @NotBlank(message = "không được để trông")
    @Min(value = 1, message = "Số tầng phải là một số dương")
    private int numberFloor;

    private String facilityFree;
    private RentType rentType;
    private FacilityType facilityType;

    public FacilityDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberFloor() {
        return numberFloor;
    }

    public void setNumberFloor(int numberFloor) {
        this.numberFloor = numberFloor;
    }

    public String getFacilityFree() {
        return facilityFree;
    }

    public void setFacilityFree(String facilityFree) {
        this.facilityFree = facilityFree;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
