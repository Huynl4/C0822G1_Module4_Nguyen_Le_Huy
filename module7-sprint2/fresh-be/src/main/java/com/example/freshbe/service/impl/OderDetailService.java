package com.example.freshbe.service.impl;

import com.example.freshbe.model.Oder;
import com.example.freshbe.model.OderDetail;
import com.example.freshbe.repository.IOrderDetailRepository;
import com.example.freshbe.service.IOderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.Action;
import java.util.List;

@Service
public class OderDetailService implements IOderDetailService {
    @Autowired
    private IOrderDetailRepository orderDetailRepository;


    @Override
    public List<OderDetail> oderDetailById(Integer oder_id) {
        return orderDetailRepository.oderDetailById(oder_id);
    }
}
