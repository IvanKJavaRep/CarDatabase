package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;



@Service
public class MyTableDao {
    @Autowired
    IMyDTORepository myDTORepository;


    @Cacheable(value = "MyTableEntity")
    public MyTableEntity get(int id) {
        return myDTORepository.findById(id).get();
    }


}
