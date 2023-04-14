package com.example.backend.controller;

import com.example.backend.dto.CoSoDTO;
import com.example.backend.dto.ICoSoDTO;
import com.example.backend.model.CoSo;
import com.example.backend.service.ICoSoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("coso")
@CrossOrigin("*")
public class CoSoRestController {
    @Autowired
    private ICoSoService coSoService;

    @GetMapping("/list")
    public ResponseEntity<List<CoSo>> getAllCoSo() {
        List<CoSo> coSoList = coSoService.getAllCoSo();
        if (coSoList == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(coSoList, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<CoSo>> findAll() {
        List<CoSo> coSoList = coSoService.findAll();
        return new ResponseEntity<>(coSoList, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<CoSo> delete(@PathVariable("id") Integer id) {
        coSoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<CoSo> findById(@PathVariable("id") Integer id) {
        CoSo coSo = coSoService.findId(id);
        return new ResponseEntity<>(coSo, HttpStatus.OK);
    }


    @GetMapping("/search")
    public ResponseEntity<List<ICoSoDTO>> search(@RequestParam(defaultValue = "") String coSoName,
                                                 @RequestParam(defaultValue = "") String coSoPerson) {
        List<ICoSoDTO> coSoDTOList = coSoService.search(coSoName, coSoPerson);
        if (coSoDTOList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(coSoDTOList, HttpStatus.OK);
    }


    @PostMapping("/createCoSo")
    public ResponseEntity<CoSo> createCoSo(@Validated @RequestBody CoSoDTO coSoDTO, BindingResult bindingResult) {
        new CoSoDTO().validate(coSoDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        CoSo coSo = new CoSo();
        BeanUtils.copyProperties(coSoDTO, coSo);
        coSoService.addCoSo(coSo.getAddress(), coSo.getDateOpen(), coSo.getName(), coSo.getPerson(), coSo.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
