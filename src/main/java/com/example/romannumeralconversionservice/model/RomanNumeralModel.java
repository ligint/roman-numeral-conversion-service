package com.example.romannumeralconversionservice.model;

import java.util.Map;
import java.util.TreeMap;

public class RomanNumeralModel {

    private final Integer number;
    private  final String romanValue;

    /** Create TreeMap for storing the Roman Numerals and their Integer Value **/
    private final static TreeMap<Integer, String > romanValueMap = new TreeMap<>();

    static {
        /**
         * Initialize the TreeMap with Roman numerals
         * and their corresponding integer values
         * reference: https://en.wikipedia.org/wiki/Roman_numerals
         * **/

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

    public String getRomanValue(){
        return  this.romanValue;
    }


    /**
     * Override toString() Method since output is expected in below format
     * {
     * “input” : “1”,
     * “output” : “I”
     * }
     */
    @Override
    public String toString(){
       String input = this.getNumber().toString();
       String output = this.romanValue;

       return String.format("{\"input\":\"%s\",\"output\":\"%s\"}", input,output);
    }


    /**
     * convertToRoman()
     * Convert the number to Roman numeral.
     *
     * @param  Integer value between 1 to 3999.
     *
     * @return  Roman Numeral in String format.
    **/
    private String convertToRoman(int number){

        StringBuilder romanNumeral = new StringBuilder();

        for (Map.Entry<Integer, String> entry: romanValueMap.descendingMap().entrySet()){

            int value = entry.getKey();
            String roman = entry.getValue();

            while (number >= value){
                romanNumeral.append(roman);
                number -= value;
            }
        }
        return romanNumeral.toString();
    }
}
