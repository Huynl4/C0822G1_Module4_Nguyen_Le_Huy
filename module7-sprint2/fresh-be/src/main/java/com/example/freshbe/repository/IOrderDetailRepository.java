package com.example.freshbe.repository;

import com.example.freshbe.model.Oder;
import com.example.freshbe.model.OderDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IOrderDetailRepository extends JpaRepository<OderDetail, Long> {
    @Query(value = "select * from oder_detail where oder_id =:id",nativeQuery = true)
    List<OderDetail> oderDetailById(@Param("id") Integer oder_id);
}
