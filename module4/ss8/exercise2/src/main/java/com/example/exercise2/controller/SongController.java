package com.example.exercise2.controller;

import com.example.exercise2.dto.SongDto;
import com.example.exercise2.model.Song;
import com.example.exercise2.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/song")
public class SongController {
    @Autowired
    private ISongService iSongService;

    @GetMapping("")
    public String showFormSong(Model model) {
        model.addAttribute("song", new Song());
        model.addAttribute("songs", iSongService.findAll());
        return "/song/home";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        SongDto songDto = new SongDto();
        model.addAttribute("songDto", songDto);

        return "/song/create";
    }

    @PostMapping("/create")
    public String saveSong(@Validated @ModelAttribute("songDto") SongDto songDto, BindingResult bindingResult,
                           RedirectAttributes redirectAttributes, Model model) {

        new SongDto().validate(songDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "song/create";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        iSongService.save(song);
        redirectAttributes.addFlashAttribute("mess", "thêm thành công");
        return "redirect:/song";
    }

    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable Long id, Model model) {
        SongDto songDto = new SongDto();
        Song song = iSongService.findById(id).get();
        BeanUtils.copyProperties(song, songDto);
        model.addAttribute("songDto", songDto);
        return "/song/edit";
    }

    @PostMapping("/update")
    public String editSong(@Validated @ModelAttribute("songDto") SongDto songDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/song/edit";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        iSongService.save(song);
        return "redirect:/song";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("deleteId") Long id, RedirectAttributes redirectAttributes) {
        iSongService.remove(id);
        redirectAttributes.addFlashAttribute("mess", "Xóa thành công");
        return "redirect:/song";
    }

    @GetMapping("/view/{id}")
    public String showView(@PathVariable Long id, Model model) {
        SongDto songDto = new SongDto();
        Song song = iSongService.findById(id).get();
        BeanUtils.copyProperties(song, songDto);
        model.addAttribute("songDto", songDto);
        return "/song/view";
    }
}
