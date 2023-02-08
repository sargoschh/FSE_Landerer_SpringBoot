package at.itkolleg.growmanager.controller;

import at.itkolleg.growmanager.exceptions.ExceptionsDTO;
import at.itkolleg.growmanager.exceptions.FormValidationExceptionDTO;
import at.itkolleg.growmanager.exceptions.PlantTypeNotFound;
import at.itkolleg.growmanager.exceptions.PlantTypeValidationFailed;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ExceptionController {

    @ExceptionHandler(PlantTypeNotFound.class)
    public ResponseEntity<ExceptionsDTO> plantTypeNotFound(PlantTypeNotFound plantTypeNotFound) {
        return new ResponseEntity<>(new ExceptionsDTO("1000", plantTypeNotFound.getMessage()), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(PlantTypeValidationFailed.class)
    public ResponseEntity<FormValidationExceptionDTO> plantTypeValidationFailed(PlantTypeValidationFailed plantTypeValidationFailed) {
        return new ResponseEntity<>(plantTypeValidationFailed.getErrorMap(), HttpStatus.BAD_REQUEST);
    }
}
