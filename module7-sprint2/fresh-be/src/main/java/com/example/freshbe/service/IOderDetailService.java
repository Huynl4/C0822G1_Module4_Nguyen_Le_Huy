package com.example.freshbe.service;

import com.example.freshbe.model.Oder;
import com.example.freshbe.model.OderDetail;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IOderDetailService {
    List<OderDetail> oderDetailById(Integer oder_id);

}
