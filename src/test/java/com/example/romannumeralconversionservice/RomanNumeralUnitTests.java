package com.example.romannumeralconversionservice;

import com.example.romannumeralconversionservice.controller.RomanNumeralController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.server.ResponseStatusException;

public class RomanNumeralUnitTests {

    private final RomanNumeralController cont = new RomanNumeralController();

    @Test
    @DisplayName("Valid Tests for Integer to Roman Conversion")
    public void testConversionToRoman_ValidNumber(){
        Assertions.assertEquals("I", cont.romanNumeral(1).toString());
        Assertions.assertEquals("V", cont.romanNumeral(5).toString());
        Assertions.assertEquals("VIII", cont.romanNumeral(8).toString());
        Assertions.assertEquals("X", cont.romanNumeral(10).toString());
        Assertions.assertEquals("XII", cont.romanNumeral(12).toString());
        Assertions.assertEquals("L", cont.romanNumeral(50).toString());
        Assertions.assertEquals("LV", cont.romanNumeral(55).toString());
        Assertions.assertEquals("C", cont.romanNumeral(100).toString());
        Assertions.assertEquals("CV", cont.romanNumeral(105).toString());
        Assertions.assertEquals("CD", cont.romanNumeral(400).toString());
        Assertions.assertEquals("D", cont.romanNumeral(500).toString());
        Assertions.assertEquals("MMM", cont.romanNumeral(3000).toString());
        Assertions.assertEquals("MMMCMXCIX", cont.romanNumeral(3999).toString());
    }

    @Test
    @DisplayName("In-Valid Tests for Integer to Roman Conversion")
    public void testConversionToRoman_InvalidNumber(){
        Assertions.assertThrows(ResponseStatusException.class, ()-> {
           cont.romanNumeral(0);
        });
        Assertions.assertThrows(ResponseStatusException.class, ()-> {
            cont.romanNumeral(-10);
        });
        Assertions.assertThrows(ResponseStatusException.class, ()-> {
            cont.romanNumeral(-200);
        });
        Assertions.assertThrows(ResponseStatusException.class, ()-> {
            cont.romanNumeral(5999);
        });
    }
}
