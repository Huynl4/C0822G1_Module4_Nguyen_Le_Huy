package com.example.freshbe.service;

import com.example.freshbe.model.Oder;
import com.example.freshbe.model.OderDetail;
import org.hibernate.criterion.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IOrderService {
    void addBill(Oder bill);

    void addBillHistory(OderDetail billHistory);
    Page<Oder> findAllByAccountId(Integer account_id, Pageable pageable);

}
