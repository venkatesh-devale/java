package com.venkatesh.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?serverTimezone=UTC";
        String user = "hbstudent";
        String pass = "hbstudent";

        try {

            Connection con = DriverManager.getConnection(jdbcUrl, user, pass);
            System.out.println("Successfully Connected"+con);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
