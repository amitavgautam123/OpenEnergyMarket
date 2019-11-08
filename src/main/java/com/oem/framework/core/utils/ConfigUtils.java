package com.oem.framework.core.utils;

import com.oem.framework.core.base.Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.stream.Collectors;

public class ConfigUtils implements Base {
    public static HashMap<String, String> getConfigForExecutionEnvironment() throws IOException {
        HashMap<String, String> configs = loadConfigs();
        configs = overrideIfSpecifiedAsEnvVariable(configs);
        System.out.println(configs);
        return configs;
    }

    private static HashMap<String, String> overrideIfSpecifiedAsEnvVariable(HashMap<String, String> mergedEnvConfig) {
        for (String key : mergedEnvConfig.keySet()) {
            String updatedValue = (null != System.getenv(key)) ? System.getenv(key) : mergedEnvConfig.get(key);
            mergedEnvConfig.put(key, updatedValue);
        }
        return mergedEnvConfig;
    }


    public static HashMap<String, String> loadConfigs() throws IOException {

        HashMap<String, String> propertyMap = new HashMap<String, String>();

        Properties p = new Properties();
        FileInputStream inputStream = new FileInputStream("src/test/resources/config.properties");
        p.load(inputStream);

        propertyMap.putAll(p.entrySet()
                .stream()
                .collect(Collectors.toMap(e -> e.getKey().toString(),
                        e -> e.getValue().toString())));
        inputStream.close();

        return propertyMap;

    }

    public static HashMap<String, String> loadConfigs(String file) throws IOException {

        HashMap<String, String> propertyMap = new HashMap<String, String>();

        Properties p = new Properties();
        FileInputStream inputStream = new FileInputStream(file);
        p.load(inputStream);

        propertyMap.putAll(p.entrySet()
                .stream()
                .collect(Collectors.toMap(e -> e.getKey().toString(),
                        e -> e.getValue().toString())));
        inputStream.close();

        return propertyMap;

    }
}
