/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tatmedia.code.utils;

import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author nekedio
 */
public class ReadProperties {

    static final String PROPERTIES = "/app.properties";

    public String getProperty() {
        final Properties property = new Properties();

        String hosts = "";

        try {
            property.load(ReadProperties.class.getResourceAsStream(PROPERTIES));
            hosts = property.getProperty("hosts");
        } catch (IOException ex) {
            System.out.println("Нет конфига :(");
        }

        return hosts;
    }

}
