package com.example.thithu1.controller;

import com.example.thithu1.dto.BookDto;
import com.example.thithu1.model.Book;
import com.example.thithu1.model.BookType;
import com.example.thithu1.service.IBookService;
import com.example.thithu1.service.IBookTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private IBookTypeService bookTypeService;

//    @GetMapping("")
//    public String show(Model model, Pageable pageable) {
//        model.addAttribute("books", bookService.findAll(pageable));
//        model.addAttribute("bookType", bookTypeService.findAll());
//        return "book/list";
//    }

    @GetMapping("")
    public String showSearchList(@RequestParam(required = false, defaultValue = "") String title,
                                 @RequestParam(required = false, defaultValue = "") String bookTypeId,
                                 Model model, @PageableDefault(size = 2) Pageable pageable) {
        Page<Book> books = bookService.search(pageable, title, bookTypeId);
        model.addAttribute("books", books);
        model.addAttribute("title", title);
        model.addAttribute("bookTypeId", bookTypeId);
        model.addAttribute("bookType", bookTypeService.findAll());
        return "book/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        List<BookType> bookTypeList = bookTypeService.findAll();
        model.addAttribute("bookDto", new BookDto());
        model.addAttribute("bookTypeList", bookTypeList);
        return "book/create";
    }

    @PostMapping("/create")
    public String save(@Validated @ModelAttribute("bookDto") BookDto bookDto, BindingResult bindingResult,
                       RedirectAttributes redirectAttributes, Model model) {
        new BookDto().validate(bookDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("bookTypeList", bookTypeService.findAll());
            return "book/create";
        }
        Book book = new Book();
        book.setFlagDelete(true);
        BeanUtils.copyProperties(bookDto, book);
        bookService.save(book);
        redirectAttributes.addFlashAttribute("mess", "thêm mới ok");
        return "redirect:/book";
    }


    @PostMapping("/delete")
    public String delete(@RequestParam("deleteId") Long id, RedirectAttributes redirectAttributes) {
        bookService.remove(id);
        redirectAttributes.addFlashAttribute("mess", "xóa ok");
        return "redirect:/book";
    }
}
