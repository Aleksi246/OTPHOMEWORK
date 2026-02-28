package com.example;

public class TemperatureConverterApp {
    public static void main(String[] args) {
        TemperatureConverter converter = new TemperatureConverter();

        double freezingF = 32.0;
        double boilingC = 100.0;
        double roomK = 300.0;

        System.out.println("F to C (32F): " + converter.fahrenheitToCelsius(freezingF));
        System.out.println("C to F (100C): " + converter.celsiusToFahrenheit(boilingC));
        System.out.println("K to C (300K): " + converter.kelvinToCelsius(roomK));
        System.out.println("Extreme? (60C): " + converter.isExtremeTemperature(60.0));
    }
}
