package com.example.freshbe.dto.request;

import com.example.freshbe.model.Account;
import org.springframework.validation.Errors;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class SignUpForm {
    @NotBlank(message = "Tên không được để trống")
    private String name;
    @NotBlank(message = "Vui lòng nhập tên đăng nhập")
    private String username;
    @NotBlank(message = "Vui lòng nhập email")
    private String email;
    @NotBlank(message = "Vui lòng nhập mật khẩu")
    private String password;

    private Set<String> roles;

    public SignUpForm() {
    }

    public SignUpForm(String name, String username, String email, String password, Set<String> roles) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
    public void validate(List<Account> list, SignUpForm signInForm, Errors errors){
        for (Account account : list) {
            if (Objects.equals(account.getUsername(), signInForm.getUsername())) {
                errors.rejectValue("username", "username", "Tên đăng nhập đã được sử dụng");
            }
            if (Objects.equals(account.getEmail(), signInForm.getEmail())) {
                errors.rejectValue("email", "email", "Email đã được sử dụng");
            }
        }

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
}
