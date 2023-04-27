package com.example.demo;


public class Parser {
    public String parseDTO(MyDTO myDTO) {
        String request = "SELECT * FROM cars\n" +
                "WHERE ";
        if (myDTO.power != null) {
            char c = myDTO.power.charAt(0);
            String s = myDTO.power.substring(1);
            request += "powerhp " + c + s + " " + "AND ";

        }
        if (myDTO.category != null) {
            request += "category = " + "'" + myDTO.category + "'" + " AND ";

        }
        if (myDTO.numberofseats != null) {
            char c = myDTO.numberofseats.charAt(0);
            String s = myDTO.numberofseats.substring(1);
            request += "numberofseats " + c + s + " " + "AND ";

        }
        if (myDTO.price != null) {
            char c = myDTO.price.charAt(0);
            String s = myDTO.price.substring(1);
            request += "price " + c + s + " " + "AND ";

        }
        if (myDTO.model != null) {
            request += "model = " + "'" + myDTO.model + "'" + " AND ";

        }
        if (myDTO.year_build != null) {
            char c = myDTO.year_build.charAt(0);
            String s = myDTO.year_build.substring(1);
            request += "year_build " + c + "'" + s + "'" + " " + "AND ";
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
