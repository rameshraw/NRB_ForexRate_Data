package com.ramesh.helpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class URLReader {
    public static String getContent(String link) throws  IOException{
        URLConnection urlconn = new URL(link).openConnection();
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(urlconn.getInputStream()))){
             String line="";

             StringBuilder content = new StringBuilder();
             while ((line=reader.readLine())!=null) {
                content.append(line).append("\r\n");

                
             }
            return content.toString();
        }
        


    }
    

 {
    
}
}
