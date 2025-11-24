package com.napier.sem;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public final class SqlLoader {
    private SqlLoader() {}

    public static String load(String resourcePath) {
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        try (InputStream in = cl.getResourceAsStream(resourcePath)) {
            if (in == null) {
                throw new IllegalArgumentException("SQL resource not found: " + resourcePath);
            }
            try (Scanner sc = new Scanner(in, StandardCharsets.UTF_8)) {
                sc.useDelimiter("\\A");
                return sc.hasNext() ? sc.next() : "";
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to load SQL: " + resourcePath, e);
        }
    }
}
