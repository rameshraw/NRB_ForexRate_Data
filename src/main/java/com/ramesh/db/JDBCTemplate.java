package com.ramesh.db;

import java.sql.SQLException;

public class JDBCTemplate {
   private static DBConnection db =new DBConnection();

    public static int execute(String sql,Object[] params)throws ClassNotFoundException,SQLException{
     
        db.connect();
        db.prepare(sql);
        int i=1;
        for(Object o:params){
            db.setParamater(i,o);
            i++;
        }
        int result=db.execute();
        db.close();
        return result;
    }
}