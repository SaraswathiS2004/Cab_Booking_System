package com.zsgs.cabbooking.data.repository.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
     private static DB dataBase = null;
     Connection connection = null;

    private DB() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/RIDEX";
        String user = "root";
        String password = "Sarah@2004";
        connection = DriverManager.getConnection(url , user , password);
    }

    public static DB getInstance() throws SQLException, ClassNotFoundException {
        if(dataBase == null){
            dataBase = new DB();
        }
        return dataBase;
    }

    public Connection getConnection() {
        return connection;
    }
}
