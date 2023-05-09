package com.example.freshbe.controller;

import com.example.freshbe.dto.CartDTO;
import com.example.freshbe.model.Account;
import com.example.freshbe.model.Cart;
import com.example.freshbe.model.Product;
import com.example.freshbe.service.IAccountService;
import com.example.freshbe.service.ICartService;
import com.example.freshbe.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/cart")
public class CartRestController {

    @Autowired
    private ICartService cartService;

    @Autowired
    private IAccountService accountService;

    @Autowired
    private IProductService productService;

    @PostMapping("/create")
    public ResponseEntity<?> createOrUpdate(@RequestBody CartDTO cartDto) {
        Cart cart = new Cart();
        Account account = accountService.findById(cartDto.getAccountId());
        Product product = productService.findById(cartDto.getProductId());
        BeanUtils.copyProperties(cartDto, cart);
        cart.setAccount(account);
        cart.setProduct(product);
        cart.setSize(cartDto.getSize());
        if (cartService.existsByProductIdAndAccountId(cart.getProduct().getId(),cart.getAccount().getId(),cart.getSize())) {
            Cart cart1 = cartService.findByProductIdAndAccountId(cart.getProduct().getId(),cart.getAccount().getId(),cart.getSize());
            cart1.setQuantity(cart1.getQuantity() + 1);
            cart1.setSize(cart1.getSize());
            cartService.createCart(cart1);
        }else {
            Cart cart1 = new Cart();
            cart1.setQuantity(cartDto.getQuantity());
            cart1.setSize(cartDto.getSize());
            cart1.setProduct(productService.findByIdProductDetail(cartDto.getProductId()));
            cart1.setAccount(accountService.findById(cartDto.getAccountId()));
            cartService.createCart(cart1);
        }
//        Cart cart1 = new Cart();
//        cart1.setQuantity(cartDto.getQuantity());
//        cart1.setProduct(productService.findById(cartDto.getProductId()));
//        cart1.setAccount(accountService.findById(cartDto.getAccountId()));
//        cartService.createCart(cart1);

        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/increase")
    public ResponseEntity<?> increaseQuantity(@RequestBody CartDTO cartDto) {
        Cart cart = new Cart();
        Account accounts = accountService.findById(cartDto.getAccountId());
        Product product = productService.findById(cartDto.getProductId());
        BeanUtils.copyProperties(cartDto, cart);
        cart.setAccount(accounts);
        cart.setProduct(product);
        Cart cart1 = cartService.findByProductIdAndAccountId(cart.getProduct().getId(),cart.getAccount().getId(),cart.getSize());
        if (cart1 != null) {
            cart1.setQuantity(cart1.getQuantity() + 1);
        } else {
            cart1 = new Cart();
            cart1.setProduct(cart.getProduct());
            cart1.setAccount(cart.getAccount());
            cart1.setSize(cart.getSize());
            cart1.setQuantity(cartDto.getQuantity()+1);
        }

        cartService.createCart(cart1);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/reduce")
    public ResponseEntity<?> reduceQuantity(@RequestBody CartDTO cartDto) {
        Cart cart = new Cart();
        Account accounts = accountService.findById(cartDto.getAccountId());
        Product product = productService.findById(cartDto.getProductId());
        BeanUtils.copyProperties(cartDto, cart);
        cart.setAccount(accounts);
        cart.setProduct(product);
        Cart cart1 = cartService.findByProductIdAndAccountId(cart.getProduct().getId(),cart.getAccount().getId(),cart.getSize());
        if (cart1 != null) {
            cart1.setQuantity(cart1.getQuantity() - 1);
        } else {
            cart1 = new Cart();
            cart1.setProduct(cart.getProduct());
            cart1.setAccount(cart.getAccount());
            cart1.setSize(cart.getSize());
            cart1.setQuantity(cartDto.getQuantity()+1);
        }

        cartService.createCart(cart1);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<List<Cart>> showList(@PathVariable("id") Integer id){
        List<Cart> carts = cartService.findCartByAccountId(id);
        return new ResponseEntity<>(carts, HttpStatus.OK);
    }
    @DeleteMapping("/deleteCart/{id}")
    public ResponseEntity<?> deleteCart(@PathVariable("id") Integer id){
        cartService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
