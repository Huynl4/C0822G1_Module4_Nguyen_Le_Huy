package com.example.exercise.controller;

import com.example.exercise.dto.CartDto;
import com.example.exercise.dto.ProductDto;
import com.example.exercise.model.Product;
import com.example.exercise.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/shop")
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @ModelAttribute("cart")
    public CartDto initCart() {
        return new CartDto();
    }

    @GetMapping("/add/{id}")
    public String addCart(@PathVariable Long id, @SessionAttribute("cart") CartDto cartDto) {
        System.out.println(id);
        Product product = iProductService.findById(id);
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product, productDto);
        cartDto.addProduct(productDto);
        return "redirect:/cart";
    }

    @GetMapping("/detail/{id}")
    public String showDetail(@PathVariable("id") long id, HttpServletResponse response,
                             Model model) {
        Cookie cookie = new Cookie("idProduct", String.valueOf(id));
        cookie.setMaxAge(30);
        cookie.setPath("/");
        response.addCookie(cookie);

        model.addAttribute("product", iProductService.findById(id));
        return "/shop/detail";
    }

    @GetMapping("")
    public ModelAndView showListPage(Model model, @CookieValue(value = "idProduct", defaultValue = "-1") Long idProduct) {
        if (idProduct != -1) {
            model.addAttribute("historyProduct", iProductService.findById(idProduct));
        }
        return new ModelAndView("/shop/home", "productList", iProductService.findAll());
    }

}

