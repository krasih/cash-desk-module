package com.example.cashdeskmodule.repository.impl;

import com.example.cashdeskmodule.utils.LocalDateTimeAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GenericRepository {

    static Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
            .create();

    public static <T> List<T> findAll(String filePath, Class<T> clazz) {

        List<T> objects = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                T object = gson.fromJson(line, clazz);
                objects.add(object);
            }
            return objects;

        } catch (IOException e) {

            System.out.println("------------- TODO: handle this properly -------------");
            return new ArrayList<>();
//            throw new RuntimeException(e);
        }
    }

    public static <T> T save(T object, String filePath) {

        String json = gson.toJson(object);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.append(json).append("\n");
            return object;
        } catch (IOException e) {
            System.out.println("------------- TODO: handle this properly -------------");
            return null; // Or return a specific error object
        }
    }

    public static void deleteContent(String filePath) {

        try (FileWriter fw = new FileWriter(filePath, false)) {
        } catch (IOException e) {
            System.out.println("------------- TODO: handle this properly -------------");
//            throw new RuntimeException(e);
        }
    }
}
