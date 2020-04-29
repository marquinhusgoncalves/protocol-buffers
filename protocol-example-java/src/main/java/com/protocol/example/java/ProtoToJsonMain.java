package com.protocol.example.java;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import example.simple.Simple;

import java.util.Arrays;

public class ProtoToJsonMain {
    public static void main(String[] args) throws InvalidProtocolBufferException {
        System.out.println("Proto to Json Example");

        Simple.SimpleMessage.Builder builder = Simple.SimpleMessage.newBuilder();
        builder.setId(42)
                .setIsSimple(true)
                .setName("My Simple Message Name");

        builder.addSampleList(1)
                .addSampleList(2)
                .addSampleList(3)
                .addAllSampleList(Arrays.asList(4, 5, 6));

        String jsonString = JsonFormat.printer()
//                .includingDefaultValueFields()
                .print(builder);
        System.out.println(jsonString);

        Simple.SimpleMessage.Builder builder2 = Simple.SimpleMessage.newBuilder();
        JsonFormat.parser()
                .ignoringUnknownFields()
                .merge(jsonString, builder2);

        System.out.println(jsonString);
    }
}
