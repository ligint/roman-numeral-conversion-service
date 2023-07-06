package com.example.romannumeralconversionservice.model;

import java.util.Map;
import java.util.TreeMap;

public class RomanNumeralModel {

    private  final String romanValue;
    private final Integer number;

    private final static TreeMap<Integer, String > romanValueMap = new TreeMap<>();
    // reference: https://en.wikipedia.org/wiki/Roman_numerals

    static {
        romanValueMap.put(1000, "M");
        romanValueMap.put(900, "CM");
        romanValueMap.put(500, "D");
        romanValueMap.put(400, "CD");
        romanValueMap.put(100, "C");
        romanValueMap.put(90, "XC");
        romanValueMap.put(50, "L");
        romanValueMap.put(40, "XL");
        romanValueMap.put(10, "X");
        romanValueMap.put(9, "IX");
        romanValueMap.put(5, "V");
        romanValueMap.put(4, "IV");
        romanValueMap.put(1, "I");
    }


    public RomanNumeralModel(int number){
        this.number = number;
        this.romanValue = convertToRoman(number);
    }

    public Integer getNumber() {
        return this.number;
    }
    public String getRomanValue(){return  this.romanValue;}

    public String toString(){return  this.romanValue;}



    private String convertToRoman(int number){

        StringBuilder romanNumeral = new StringBuilder();
        for (int key: romanValueMap.descendingKeySet()){
            while (number >= key){
                romanNumeral.append(romanValueMap.get(key));
                number -= key;
            }
        }

        return romanNumeral.toString();
    }
}
