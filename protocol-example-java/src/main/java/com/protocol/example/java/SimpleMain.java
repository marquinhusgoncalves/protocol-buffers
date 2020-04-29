package com.protocol.example.java;

import example.simple.Simple;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class SimpleMain {
    public static void main(String[] args) {
        System.out.println("Hello world");

        Simple.SimpleMessage.Builder builder = Simple.SimpleMessage.newBuilder();
        builder.setId(42)
                .setIsSimple(true)
                .setName("My Simple Message Name");

        builder.addSampleList(1)
                .addSampleList(2)
                .addSampleList(3)
                .addAllSampleList(Arrays.asList(4, 5, 6));

        System.out.println(builder.toString());

        Simple.SimpleMessage message = builder.build();

        try {
            FileOutputStream outputStream = new FileOutputStream("simple message.bin");
            message.writeTo(outputStream);
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        byte[] bytes = message.toByteArray();

        try {
            System.out.println("Reading file...");
            FileInputStream fileInputStream = new FileInputStream("simple message.bin");
            Simple.SimpleMessage messageFromFile = Simple.SimpleMessage.parseFrom(fileInputStream);
            System.out.println(messageFromFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
