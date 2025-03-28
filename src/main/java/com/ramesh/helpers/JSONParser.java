package com.ramesh.helpers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import org.json.JSONObject;

public class JSONParser {
    private static List<JSONObject> pageJsonobjectArrays=new ArrayList<>();
    private static String content; 
    private static String next; 

    public static List<JSONObject> getJsonArray(String link) throws IOException{
        
        content=URLReader.getContent(link);
        JSONObject json = new JSONObject(content);
        int per_pagedata = json.getJSONObject("data").getJSONArray("payload").length();

        for (int index = 0; index < per_pagedata; index++) {
            
            JSONObject jsonobject = json.getJSONObject("data").getJSONArray("payload").getJSONObject(index);
            
            pageJsonobjectArrays.add(jsonobject);
        }
       
        next = json.getJSONObject("pagination").getJSONObject("links").optString("next",null);
        
        if(next == null){
            return pageJsonobjectArrays;

        }
    
        



         return getJsonArray(next);
        
    }

   
    
}
