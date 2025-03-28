package com.ramesh.dao.impl;
import java.sql.SQLException;
import com.ramesh.dao.CurrencyDAO;
import com.ramesh.db.JDBCTemplate;
import com.ramesh.models.Currency;

public class CurrencyDAOIMPL implements CurrencyDAO {
   
    @Override
    public int save(Currency currency) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO Currency (iso3, name, unit) VALUES (?, ?, ?)";
        return JDBCTemplate.execute(sql, new Object[]{
            currency.getIso3(),currency.getName(),currency.getUnit()
        });


        
    
}
}
