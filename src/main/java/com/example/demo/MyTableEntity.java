package com.example.demo;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cars")

public class MyTableEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "attSeq")
    @SequenceGenerator(
            name = "attSeq",
            sequenceName = "attendance_seq",
            allocationSize = 1
    )
    @Column(name = "id")
    Integer id;

    @Column(name = "producer")
    String producer;
    @Column(name = "model")
    String model;
    @Column(name = "powerhp")
    Integer power;
    @Column(name = "price$")
    Integer price;
    @Column(name = "year_build")
    Integer year_build;
    @Column(name = "category")
    String category;
    @Column(name = "numberofseats")
    Integer numberofseats;

    public MyTableEntity(int id, String producer, String model, Integer price, Integer year_build, String category, Integer numberOfSeats, Integer power) {
        super();
        this.id = id;
        this.producer = producer;
        this.model = model;
        this.price = price;
        this.year_build = year_build;
        this.category = category;
        this.numberofseats = numberOfSeats;
        this.power = power;

    }

}
