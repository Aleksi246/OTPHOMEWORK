package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TemperatureConverterTest 
{
    TemperatureConverter converter = new TemperatureConverter();    

    @Test
    public void TestFahrenheitToCelsius()
    {
        assertEquals(0.0, converter.fahrenheitToCelsius(32.0), 0.01);
        assertEquals(-40.0, converter.fahrenheitToCelsius(-40.0), 0.01);
        assertEquals(100.0, converter.fahrenheitToCelsius(212.0), 0.01);    
    }
    @Test
    public void TestCelsiusToFahrenheit()
    {
        assertEquals(32.0, converter.celsiusToFahrenheit(0.0), 0.01);
        assertEquals(-40.0, converter.celsiusToFahrenheit(-40.0), 0.01);
        assertEquals(212.0, converter.celsiusToFahrenheit(100.0), 0.01);    
    }  
    @Test
    public void TestIsExtremeTemperature()
    {
        assertTrue(converter.isExtremeTemperature(-50.0));
        assertTrue(converter.isExtremeTemperature(60.0));
        assertFalse(converter.isExtremeTemperature(20.0));
    }
    @Test
    public void TestKelvinToCelcius(){
        assertEquals(26.85,converter.kelvinToCelsius(300),0.01);
        assertEquals(826.85,converter.kelvinToCelsius(1000),0.01);
    }
}
