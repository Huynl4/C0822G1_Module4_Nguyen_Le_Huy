package com.example.exercise.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int amount;

    @OneToMany(mappedBy = "book")
    private Set<Oder> oderSet;

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Set<Oder> getOderSet() {
        return oderSet;
    }

    public void setOderSet(Set<Oder> oderSet) {
        this.oderSet = oderSet;
    }
}
