package com.protocol.example.java;

import example.enumerations.EnumExample;

public class EnumMain {
    public static void main(String[] args) {
        System.out.println("Example for enums");
        EnumExample.EnumMessage.Builder builder = EnumExample.EnumMessage.newBuilder();

        builder.setId(345);
        builder.setDayOfTheWeek(EnumExample.DayOfTheWeek.FRIDAY);

        EnumExample.EnumMessage message = builder.build();
        System.out.println(message);
    }
}
