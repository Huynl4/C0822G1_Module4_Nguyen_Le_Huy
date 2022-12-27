package com.example.exercise.controller;

import com.example.exercise.model.Book;
import com.example.exercise.model.Oder;
import com.example.exercise.service.IBookService;
import com.example.exercise.service.IOderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService iBookService;
    @Autowired
    private IOderService iOderService;

    @RequestMapping("")
    public String showList(@RequestParam(defaultValue = "") String search, @PageableDefault(size = 5) Pageable pageable,
                           Model model) {
        Page<Book> books = iBookService.findAllByNameContaining(search, pageable);
        model.addAttribute("books", books);
        return "/book/list";
    }

    @GetMapping("/rent/{id}")
    public String showRent(@PathVariable("id") int id, Model model) {
        Optional<Book> book = iBookService.findById(id);
        if (book.isPresent()) {
            model.addAttribute("book", book.get());
            return "/book/rent";
        } else {
            return "/error";
        }
    }

    @PostMapping("/rent")
    public String rent(@ModelAttribute("book") Book book, RedirectAttributes redirectAttributes) throws Exception {
        if (book.getAmount() == 0) {
            throw new Exception();
        }
        int idRent = iOderService.getIdRent(book);
        iBookService.rentBook(book.getId());
        redirectAttributes.addFlashAttribute("mess", "Rent book success - ID Rent book :" + idRent);
        return "redirect:/book";
    }

    @GetMapping("/pay")
    public String showPay(Model model) {
        Oder oder = new Oder();
        model.addAttribute("payBook", oder);
        List<Oder> oderList = iOderService.findAllOder();
        model.addAttribute("oderList", oderList);
        return "/book/pay";
    }

    @PostMapping("/pay")
    public String pay(@ModelAttribute("payBook") Oder oder, RedirectAttributes redirectAttributes) throws Exception {
        Oder oder1 = iOderService.findByIdRent(oder.getIdRent());
        if (oder1 == null) {
            throw new Exception();
        }
        Optional<Book> book = iBookService.findById((int) oder1.getBook().getId());
        iBookService.payBook(book.get().getId());
        iOderService.deleteOder(oder1);
        redirectAttributes.addFlashAttribute("mess", "Pay book success");
        return "redirect:/book";
    }
}
