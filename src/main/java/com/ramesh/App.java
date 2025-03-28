package com.ramesh;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.ramesh.dao.impl.CurrencyDAOIMPL;
import com.ramesh.dao.impl.ExchangeRateDAOIMPL;
import com.ramesh.helpers.JSONParser;
import com.ramesh.models.Currency;
import com.ramesh.models.ExchangeRate;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        List<JSONObject> eachdatejsonarray = new ArrayList<>();
        CurrencyDAOIMPL currencyImpl = new CurrencyDAOIMPL();
        ExchangeRateDAOIMPL exchangeRateDAOIMPL =new ExchangeRateDAOIMPL();
        List<JSONObject> exchangeratearray = new ArrayList<>();
        List<JSONObject> currencyarray = new ArrayList<>();
        String link = "https://www.nrb.org.np/api/forex/v1/rates?per_page=100&page=1&from=2021-01-01&to=2025-05-27";
        try {

            eachdatejsonarray = JSONParser.getJsonArray(link);
            for (int i =0;i<eachdatejsonarray.size();i++) {
                int size = eachdatejsonarray.get(i).getJSONArray("rates").length();

                currencyarray.add( eachdatejsonarray.get(i).getJSONArray("rates").getJSONObject(0).getJSONObject("currency"));
                for(int j = 0 ; j < size; j++){
                    // exchangeratearray.add(eachdatejsonarray.get(i).getJSONArray("rates").getJSONObject(j).get)
                    exchangeRateDAOIMPL.save(new ExchangeRate(j+1,Double.parseDouble(eachdatejsonarray.get(i).getJSONArray("rates").getJSONObject(j).optString("buy","0.0")),Double.parseDouble(eachdatejsonarray.get(i).getJSONArray("rates").getJSONObject(j).optString("sell","0.0")),LocalDate.parse(eachdatejsonarray.get(i).getString("date"))));
                }
            // for(JSONObject currency : currencyarray){
            //     currencyImpl.save(new Currency(currency.getString("iso3"),currency.getString("name"),currency.getInt("unit")));
            // }

                
                
            }
          
       
        } catch (IOException | ClassNotFoundException | JSONException | SQLException e) {
            e.printStackTrace();
        }

    }
}
