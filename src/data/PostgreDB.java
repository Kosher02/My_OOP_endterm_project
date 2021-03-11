package data;

import data.interfaces.IDB;

import java.sql.*;

class PostgresDB implements IDB {
    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        String connectionUrl = "jdbc:postgresql://localhost:5432/students";
        try {
            // Here we load the driver’s class file into memory at the runtime
            Class.forName("org.postgresql.Driver");

            // Establish the connection
            Connection con = DriverManager.getConnection(connectionUrl, "postgres", "502568");

            return con;
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        }
    }
}