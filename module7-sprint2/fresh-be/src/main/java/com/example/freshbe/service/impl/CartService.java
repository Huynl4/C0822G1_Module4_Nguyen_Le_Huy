package com.example.freshbe.service.impl;

import com.example.freshbe.model.Account;
import com.example.freshbe.model.Cart;
import com.example.freshbe.model.Product;
import com.example.freshbe.repository.ICartRepository;
import com.example.freshbe.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService implements ICartService {
    @Autowired
    private ICartRepository cartRepository;

    @Override
    public List<Cart> findAllByAccount(Account account) {
        return cartRepository.findAllByAccount(account);
    }

    @Override
    public List<Cart> findCartByAccountId(long accountId) {
        return cartRepository.findCartByAccountId(accountId);
    }

    @Override
    public Boolean existsByProductIdAndAccountId(int productId, Integer accountId, String size) {
        return cartRepository.existsByProductIdAndAccountIdAndSize(productId, accountId, size);
    }

    @Override
    public Cart findByProductIdAndAccountId(int productId, Integer accountId, String size) {
        return cartRepository.findByProductIdAndAccountIdAndSize(productId, accountId, size);
    }

    @Override
    public void deleteById(int id) {
        cartRepository.deleteById(id);
    }

    @Override
    public void createCart(Cart cart) {
        cartRepository.save(cart);
    }

    @Override
    public Cart findById(int id) {
        return cartRepository.findById(id).orElse(null);
    }

    @Override
    public List<Cart> findAll(Long id) {
        return cartRepository.findAllCart(id);
    }

    @Override
    public void updateSize(int id, String size) {
        cartRepository.updateCart(id, size);
    }

    @Override
    public void deleteCartByIdUser(Long account) {
        cartRepository.deleteCartById(account);
    }

    @Override
    public List<Cart> findAllByUser(Account account) {
        return cartRepository.findAllByAccount(account);
    }
}
