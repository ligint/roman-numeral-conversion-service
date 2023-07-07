package com.example.romannumeralconversionservice;

import com.example.romannumeralconversionservice.controller.RomanNumeralController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;


public class RomanNumeralUnitTests {

    private final RomanNumeralController cont = new RomanNumeralController();

    /**
     * Test to check if the conversion is Valid and
     * returns proper Roman Numeral
     * **/
    @Test
    @DisplayName("Valid Tests for Integer to Roman Conversion")
    public void testConversionToRoman_ValidNumber(){
        Assertions.assertEquals("{\"input\":\"1\",\"output\":\"I\"}", cont.romanNumeral(1).getBody());
        Assertions.assertEquals("{\"input\":\"5\",\"output\":\"V\"}", cont.romanNumeral(5).getBody());
        Assertions.assertEquals("{\"input\":\"8\",\"output\":\"VIII\"}", cont.romanNumeral(8).getBody());
        Assertions.assertEquals("{\"input\":\"10\",\"output\":\"X\"}", cont.romanNumeral(10).getBody());
        Assertions.assertEquals("{\"input\":\"12\",\"output\":\"XII\"}", cont.romanNumeral(12).getBody());
        Assertions.assertEquals("{\"input\":\"50\",\"output\":\"L\"}", cont.romanNumeral(50).getBody());
        Assertions.assertEquals("{\"input\":\"55\",\"output\":\"LV\"}", cont.romanNumeral(55).getBody());
        Assertions.assertEquals("{\"input\":\"100\",\"output\":\"C\"}", cont.romanNumeral(100).getBody());
        Assertions.assertEquals("{\"input\":\"105\",\"output\":\"CV\"}", cont.romanNumeral(105).getBody());
        Assertions.assertEquals("{\"input\":\"400\",\"output\":\"CD\"}", cont.romanNumeral(400).getBody());
        Assertions.assertEquals("{\"input\":\"500\",\"output\":\"D\"}", cont.romanNumeral(500).getBody());
        Assertions.assertEquals("{\"input\":\"3000\",\"output\":\"MMM\"}", cont.romanNumeral(3000).getBody());
        Assertions.assertEquals("{\"input\":\"3999\",\"output\":\"MMMCMXCIX\"}", cont.romanNumeral(3999).getBody());
    }

    /**
     * Test to check if input in not Valid
     * returns proper Roman Numeral
     * **/
    @Test
    @DisplayName("In-Valid Input Tests for Integer to Roman Conversion")
    public void testConversionToRoman_InvalidNumber(){

        Assertions.assertEquals(HttpStatus.BAD_REQUEST, cont.romanNumeral(0).getStatusCode());
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, cont.romanNumeral(-10).getStatusCode());
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, cont.romanNumeral(-200).getStatusCode());
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, cont.romanNumeral(5999).getStatusCode());
    }
}
