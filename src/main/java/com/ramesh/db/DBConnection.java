package com.ramesh.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnection {
    private Connection conn;
    private PreparedStatement stmt;

    public  void connect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String dbURL = "jdbc:mysql://localhost/nrb_forex_rate";
        String user = "root";
        String pass = "#SERamesh@2004";
        conn = DriverManager.getConnection(dbURL, user, pass);

    }
    public void prepare(String sql) throws SQLException{
        stmt =conn.prepareStatement(sql);

    }
    public void setParamater(int index , Object value) throws SQLException{
        stmt.setObject(index, value);

    }
    public int execute() throws SQLException{
        return stmt.executeUpdate();
    }
    public void close() throws SQLException{
        if (conn!=null) {
            stmt.close();
            conn.close();
            conn=null;
            
        }

    }
    
}
