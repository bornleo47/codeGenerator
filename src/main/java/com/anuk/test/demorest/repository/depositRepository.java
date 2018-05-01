package com.anuk.test.demorest.repository;

import com.anuk.test.demorest.deposit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author anukshakya
 */
public class depositRepository {

    Connection con = null;

    public depositRepository() { //db properties initialization

        String url = "jdbc:mysql://localhost:3306/depositRest";
        String username = "root";
        String password = "root";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<deposit> readAll() {

        List<deposit> depoList = new ArrayList<>();

        String sql = "Select * from deposit";

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                deposit d = new deposit();
                d.setId(rs.getInt(1));
                d.setCode(rs.getString(2));
                d.setAmount(rs.getDouble(3));

                depoList.add(d);

            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return depoList;
    }

    public void createDeposit(deposit a) {

        String sql = "insert into deposit values (?, ?, ?)";

        try {
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, a.getId());
            st.setString(2, a.getCode());
            st.setDouble(3, a.getAmount());
            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    public String generateCode(String candidateChars, int length) {
        {
            StringBuilder sb = new StringBuilder();
            Random random = new Random();
            for (int i = 0; i < length; i++) {

                sb.append(candidateChars.charAt(random.nextInt(candidateChars
                        .length())));
            }

            return sb.toString();
        }
    }

   
    //this code is having some issues dai...
    public boolean checker(String p) throws SQLException {

        String sql = "select code from deposit where code=" + p;
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        if (rs.getRow()>0) {
            return true;
        } else {
            return false;
        }

    }
}
