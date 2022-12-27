package com.example.exercise.service.impl;

import com.example.exercise.model.Book;
import com.example.exercise.model.Oder;
import com.example.exercise.repository.IOderRepository;
import com.example.exercise.service.IOderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class OderService implements IOderService {
    @Autowired
    private IOderRepository iOderRepository;

    @Override
    public int getIdRent(Book book) {
        Oder oder = new Oder();
        int idRent = ThreadLocalRandom.current().nextInt(10000, 99999);
        oder.setIdRent(idRent);
        oder.setBook(book);
        iOderRepository.save(oder);
        return idRent;
    }

    @Override
    public Oder findByIdRent(int idRent) {
        List<Oder> oderList = iOderRepository.findAll();
        for (Oder oder : oderList) {
            if (oder.getIdRent() == idRent) {
                return oder;
            }
        }
        return null;
    }

    @Override
    public List<Oder> findAllOder() {
        return iOderRepository.findAllOder();
    }

    @Override
    public void deleteOder(Oder oder) {
        iOderRepository.deleteOder(oder.getIdRent());
    }
}
