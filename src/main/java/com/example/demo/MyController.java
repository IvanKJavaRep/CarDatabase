package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/myservice")
public class MyController {

    @Autowired
    MyTableService myTableService;
    @Autowired
    DataSource dataSource;

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public MyTableEntity getMyData(@PathVariable int id) {
        return myTableService.getEntity(id);
    }

    @RequestMapping(value = "/filter", method = RequestMethod.POST)
    @ResponseBody
    public List<MyTableEntity> filterData(@RequestBody MyDTO md) {
        Parser parser = new Parser();
        String req = parser.parseDTO(md);
        ArrayList<MyTableEntity> arr = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                MyTableEntity entity = new MyTableEntity();
                entity.setId(Integer.valueOf(rs.getString(1)));
                entity.setProducer(rs.getString(2));
                entity.setModel(rs.getString(3));
                entity.setPower(Integer.valueOf(rs.getString(4)));
                entity.setNumberofseats(Integer.valueOf(rs.getString(5)));
                entity.setYear_build(Integer.valueOf(rs.getString(6)));
                entity.setCategory(rs.getString(7));
                entity.setNumberofseats(Integer.valueOf(rs.getString(8)));
                arr.add(entity);
            }

        } catch (Exception ex) {
            System.out.println("l");
        }
        return arr;


    }


}