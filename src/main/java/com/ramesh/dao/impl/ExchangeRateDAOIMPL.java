package com.ramesh.dao.impl;

import java.sql.SQLException;

import com.ramesh.dao.ExchangeRateDAO;
import com.ramesh.db.JDBCTemplate;
import com.ramesh.models.ExchangeRate;

public class ExchangeRateDAOIMPL  implements ExchangeRateDAO{

    @Override
    public int save(ExchangeRate exchangerate) throws SQLException, ClassNotFoundException {
            
        String sql = "INSERT INTO ExchangeRate (currency_id, buy_rate, sell_rate, rate_date) VALUES (?, ?, ?, ?)";

        return JDBCTemplate.execute(sql, new Object[]{
            exchangerate.getCurrencyID(),exchangerate.getBuyRate(),exchangerate.getSellRate(),exchangerate.getDate()
        });
    
       
        
    }

    
    
}
