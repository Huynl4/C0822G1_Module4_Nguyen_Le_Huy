package com.example.exercise2.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SongDto implements Validator {
    private Long id;
    @NotEmpty(message = "Tên bài hát không được để trống")
    @Pattern(regexp = "[A-Za-z ]+",message = "Nhập sai định dạng33")
    private String nameSong;

    @NotEmpty(message = "Tên ca sĩ không được để trống")
    @Pattern(regexp = "[A-Za-z ]+",message = "Nhập sai định dạng")
    private String singer;

    @NotEmpty(message = "Thể loại nhạc không được để trống")
    @Size(max = 100)
    private String music;

    public SongDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
