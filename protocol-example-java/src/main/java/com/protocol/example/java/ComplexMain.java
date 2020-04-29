package com.protocol.example.java;

import example.complex.Complex.*;

import java.util.Arrays;

public class ComplexMain {
    public static void main(String[] args) {
        System.out.println("Example for complex");

        DummyMessage oneDummy = newDummyMessage(55, "one dummy message");
        ComplexMessage.Builder builder = ComplexMessage.newBuilder();

        builder.setOneDummy(oneDummy);

        builder.addMultipleDummy(newDummyMessage(66, "second dummy message"));
        builder.addMultipleDummy(newDummyMessage(67, "third dummy message"));
        builder.addMultipleDummy(newDummyMessage(68, "forth dummy message"));

        builder.addAllMultipleDummy(Arrays.asList(
                newDummyMessage(98, "other dummy message"),
                newDummyMessage(99, "other dummy message")
        ));

        ComplexMessage message = builder.build();

        System.out.println(message.toString());
    }

    public static DummyMessage newDummyMessage(Integer id, String name) {
        DummyMessage.Builder dummyMessageBuilder = DummyMessage.newBuilder();

        DummyMessage message = dummyMessageBuilder.setName(name)
                .setId(id)
                .build();

        return message;
    }
}
