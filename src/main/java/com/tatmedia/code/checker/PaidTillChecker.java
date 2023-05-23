/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tatmedia.code.checker;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 *
 * @author nekedio
 */
public class PaidTillChecker {

    public String check(String host) {
        String dateFormat = "";
        try {
            URL url = new URL("https://api.whois.vu/?q=" + host);
            String paidTill = getWhois(url).get("expires").toString();
            Date date = new Date(Long.parseLong(paidTill) * 1000);

            String pattern = "dd.MM.yyyy";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

            dateFormat = simpleDateFormat.format(date);

        } catch (MalformedURLException ex) {
            System.out.println("Не удалось получить ответ от API :(");
        }
        return dateFormat;
    }

    private Map<String, Object> getWhois(URL url) {
        Map<String, Object> jsonMap = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            jsonMap = mapper.readValue(url, Map.class);
        } catch (IOException ex) {
            System.out.println("Не удалось получить ответ от API :(");
        }
        return jsonMap;

    }

}
