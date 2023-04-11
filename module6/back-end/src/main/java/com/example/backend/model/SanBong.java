package com.example.backend.model;

import javax.persistence.*;

@Entity
public class SanBong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;
    private boolean flagDelete;

    @ManyToOne
    private KhuVuc khuVuc;
    @ManyToOne
    private LoaiSan loaiSan;
    @ManyToOne
    private Time time;

    public SanBong() {
    }

    public LoaiSan getLoaiSan() {
        return loaiSan;
    }

    public void setLoaiSan(LoaiSan loaiSan) {
        this.loaiSan = loaiSan;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(boolean flagDelete) {
        this.flagDelete = flagDelete;
    }

    public KhuVuc getKhuVuc() {
        return khuVuc;
    }

    public void setKhuVuc(KhuVuc khuVuc) {
        this.khuVuc = khuVuc;
    }
}
