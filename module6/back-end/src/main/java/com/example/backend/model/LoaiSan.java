package com.example.backend.model;

import javax.persistence.*;

@Entity
public class LoaiSan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String catelory;


    public LoaiSan() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCatelory() {
        return catelory;
    }

    public void setCatelory(String catelory) {
        this.catelory = catelory;
    }

}
