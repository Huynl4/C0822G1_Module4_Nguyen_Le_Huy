package com.example.freshbe.service.impl;

import com.example.freshbe.model.Oder;
import com.example.freshbe.model.OderDetail;
import com.example.freshbe.repository.IOrderDetailRepository;
import com.example.freshbe.repository.IOrderRepository;
import com.example.freshbe.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements IOrderService {
    @Autowired
    private IOrderRepository orderRepository;

    @Autowired
    private IOrderDetailRepository orderDetailRepository;


    @Override
    public void addBill(Oder bill) {
        orderRepository.save(bill);
    }

    @Override
    public void addBillHistory(OderDetail billHistory) {
        orderDetailRepository.save(billHistory);
    }

    @Override
    public Page<Oder> findAllByAccountId(Integer account_id, Pageable pageable) {
        return orderRepository.findAllByAccountId(account_id, pageable);
    }
}
