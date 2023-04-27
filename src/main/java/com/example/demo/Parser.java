package com.example.demo;


public class Parser {
    public String parseDTO(MyDTO myDTO) {
        String request = "SELECT * FROM cars\n" + "WHERE ";
        if (myDTO.power != null) {
            request += "powerhp " + myDTO.power.charAt(0) + myDTO.power.substring(1) + " " + "AND ";
        }
        if (myDTO.category != null) {
            request += "category = " + "'" + myDTO.category + "'" + " AND ";
        }
        if (myDTO.numberofseats != null) {
            request += "numberofseats " + myDTO.numberofseats.charAt(0) + myDTO.numberofseats.substring(1) + " " + "AND ";
        }
        if (myDTO.price != null) {
            request += "price$ " + myDTO.price.charAt(0) + "'" + myDTO.price.substring(1) + "'" + " " + "AND ";
        }
        if (myDTO.model != null) {
            request += "model = " + "'" + myDTO.model + "'" + " AND ";
        }
        if (myDTO.year_build != null) {
            request += "year_build " + myDTO.year_build.charAt(0) + "'" + myDTO.year_build.substring(1) + "'" + " " + "AND ";
        }
        if (myDTO.producer != null) {
            request += "producer = " + "'" + myDTO.producer + "'";
        }
        if (request.substring(request.length() - 5).equals(" AND ")) {
            request = request.substring(0, request.length() - 5);
        }
        request += ";";
        System.out.println(request);
        return request;
    }
}
