package com.example.exercise.controller;

import com.example.exercise.dto.CartDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/cart")
public class CartController {
    @GetMapping("")
    public String showCart(@SessionAttribute("cart") CartDto cart, Model model) {
        model.addAttribute("cart",cart);
        return "/cart/list";
    }
    @GetMapping("pay")
    public String remove(@SessionAttribute("cart")CartDto cart, RedirectAttributes redirectAttributes){
        cart.delete();
        redirectAttributes.addFlashAttribute("mess", "Thanh toán thành công");
        return "redirect:/shop";
    }
}
