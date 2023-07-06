package com.example.romannumeralconversionservice.controller;

import com.example.romannumeralconversionservice.model.RomanNumeralModel;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class RomanNumeralController implements ErrorController {

    private static final String PATH = "/error";

    @RequestMapping("/romannumeral")
    public RomanNumeralModel romanNumeral(@RequestParam(value = "query", defaultValue = "1") Integer query) {
        if(query <=0 || query > 3999){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Input. Please provide a number between 1 and 3999.");
        }
        return new RomanNumeralModel(query);
    }

    @RequestMapping(value = PATH)
    public ResponseEntity<String> handleError() {
        // Custom error handling logic
        String errorMessage = "Invalid Input. Please provide a number between 1 and 3999.";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }
}
