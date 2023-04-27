package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyTableService {
    @Autowired
    MyTableDao myTableDao;
    @Autowired
    MyTableMapper myTableMapper;


    public MyTableEntity getEntity(int id) {
        return myTableDao.get(id);
    }
}