package com.example.romannumeralconversionservice.controller;

import com.example.romannumeralconversionservice.model.RomanNumeralModel;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RomanNumeralController implements ErrorController {

    /**
     * Controller
     * Accepts an input number between 1 and 3999.
     *  returns the corresponding roman numeral.
     * @param  query input to convert to roman numeral
     * @return       json body that contains original number and roman numeral conversion.
     */


    private static final String PATH = "/error";

    @RequestMapping("/romannumeral")
    public ResponseEntity<String> romanNumeral(@RequestParam(value = "query", defaultValue = "1") Integer query){
        /** Validate the input number **/
        if (query <= 0 || query > 3999) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Invalid number. Please provide a Integer Value between 1 and 3999.");
        }
        /** Return the converted Roman numeral **/
        return ResponseEntity.ok(new RomanNumeralModel(query).toString());
    }


    /** Catches any exception that occurs during validation **/
    @ExceptionHandler
    public ResponseEntity<String> handleValidationException(Exception ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Input, Please provide a Integer Value between 1 and 3999.");
    }


    /**
     * Error handling logic for Actuator endpoints.
     **/

    @RequestMapping(PATH)
    public ResponseEntity<String> handleActuatorError() {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Actuator endpoint doesn't exist");
    }

}
