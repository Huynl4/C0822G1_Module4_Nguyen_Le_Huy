package com.example.ketthuc.dto;

import com.example.ketthuc.model.DanhMuc;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class TintucDto implements Validator {
    private Long id;
    @NotBlank(message = "không được để trống, không quá 50 kí tự")
    @Size(max = 50)
    private String tieuDe;

    @NotBlank(message = "không dược để trống")
    @Size(max = 500, message = "Nội dung không quá 500 kí tự")
    private String noiDung;

    @NotBlank(message = "ngày nhập đúng định dạng")
    private String ngayDang;

    private String phongVien;
    private DanhMuc danhMuc;

    public TintucDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getNgayDang() {
        return ngayDang;
    }

    public void setNgayDang(String ngayDang) {
        this.ngayDang = ngayDang;
    }

    public String getPhongVien() {
        return phongVien;
    }

    public void setPhongVien(String phongVien) {
        this.phongVien = phongVien;
    }

    public DanhMuc getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(DanhMuc danhMuc) {
        this.danhMuc = danhMuc;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
