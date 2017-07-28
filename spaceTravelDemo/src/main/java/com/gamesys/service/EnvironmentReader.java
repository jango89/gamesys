package com.gamesys.service;

import java.util.Properties;

public class EnvironmentReader {

    public static EnvironmentReader INSTANCE = new EnvironmentReader();

    private EnvironmentReader() {
    }

    public String getValue(String key) {

        try {

            Properties properties = new Properties();

            properties.load(getClass().getClassLoader().getResourceAsStream("DATA/env.properties"));

            return properties.getProperty(key);

        } catch (Exception e) {

            e.printStackTrace();

            throw new RuntimeException(e);
        }
    }
}
