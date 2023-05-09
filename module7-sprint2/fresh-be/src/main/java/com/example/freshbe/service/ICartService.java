package com.example.freshbe.service;

import com.example.freshbe.model.Account;
import com.example.freshbe.model.Cart;
import com.example.freshbe.model.Product;

import java.util.List;

public interface ICartService {
    List<Cart> findAllByAccount(Account account);
    List<Cart> findCartByAccountId(long accountId);

    Boolean existsByProductIdAndAccountId(int productId, Integer accountId, String size);

    Cart findByProductIdAndAccountId(int productId, Integer accountId,String size);
    void deleteById(int id);
    void createCart(Cart cart);

    Cart findById(int id);
}
