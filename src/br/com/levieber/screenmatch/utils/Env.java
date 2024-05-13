package br.com.levieber.screenmatch.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Env {
    private final Properties envVars = new Properties();

    public Env() throws IOException {
        loadEnvVars();
    }

    private void loadEnvVars() throws IOException {
        try (var fis = new FileInputStream(".env")) {
            envVars.load(fis);
        }
    }

    public String get(String key) {
        return envVars.getProperty(key);
    }
}