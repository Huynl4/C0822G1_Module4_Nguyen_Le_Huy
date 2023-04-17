package com.example.mobiledemo.repository;

import com.example.mobiledemo.model.BillHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface IBillHistoryRepository extends JpaRepository<BillHistory, Integer> {
    @Query(value = "select sum(bill.quantity) as total_quantity, user.name, user.age,user.gender, user.phone_number,user.email, bill.buy_date, commodity.name, sum(commodity.price * bill.quantity) as total from user join bill on user.id = bill.user_id join bill_history on bill.id = bill_history.bill_id join commodity on bill_history.commodity_id = commodity.id group by user.id")
    List<BillHistory> findAll();
}
