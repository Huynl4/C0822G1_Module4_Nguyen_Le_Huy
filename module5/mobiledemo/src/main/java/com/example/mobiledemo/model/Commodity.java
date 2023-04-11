package com.example.mobiledemo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Commodity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String cpu;
    private String capacity;
    private String trademArk;
    private double price;
    private String image;
    private String camera;
    private String selfie;
    private String screensize;
    private String guarantee;
    private String origin;
    private String decription;
    private String codeQr;
    private int quantity;

}
