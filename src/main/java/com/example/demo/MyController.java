package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

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
    public void filterData(@RequestBody MyDTO md) {
        Parser parser = new Parser();
        String req = parser.parseDTO(md);
        try {
            Connection connection = dataSource.getConnection();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                System.out.print(rs.getString(1) + " ");
                System.out.print(rs.getString(2) + " ");
                System.out.print(rs.getString(3) + " ");
                System.out.print(rs.getString(4) + " ");
                System.out.print(rs.getString(5) + " ");
                System.out.print(rs.getString(6) + " ");
                System.out.print(rs.getString(7) + " ");
                System.out.print(rs.getString(8));
                System.out.println();
            }
        } catch (Exception ex) {
            System.out.println("l");
        }

    }


}