package com.example.demo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor

public class MyDTO implements Serializable {

    //для параметров, в которых уместно задать фильтрацию "от", "до" или "равно" пишем <>=
    // price >10000 значит, что ищем модели, цена которых больше 10000
    // программа будет парсить строку и делать фильтрацию с нужными параметрами.
    // если хотим оставить параметр пустым, то передаем в json пустую строку.
    Integer id;
    String producer;
    String power;
    String model;
    String price;
    String year_build;
    String category;
    String numberofseats;


    public MyDTO(int id, String producer, String model, String price, String year_build, String category, String numberofseats, String power) {
        super();
        this.id = id;
        this.producer = producer;
        this.model = model;
        this.price = price;
        this.power = power;
        this.year_build = year_build;
        this.category = category;
        this.numberofseats = numberofseats;
    }

}