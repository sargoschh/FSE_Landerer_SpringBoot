package at.hakimst.Studentenverwaltung.Controler;

import at.hakimst.Studentenverwaltung.Exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<CustomServerExceptionDto> studentNotFound(StudentNotFoundException studentNotFoundException) {
        return new ResponseEntity<>(new CustomServerExceptionDto("1000", studentNotFoundException.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(KursNotFoundException.class)
    public ResponseEntity<CustomServerExceptionDto> kursNotFound(KursNotFoundException kursNotFoundException) {
        return new ResponseEntity<>(new CustomServerExceptionDto("2000", kursNotFoundException.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BuchungNotFoundException.class)
    public ResponseEntity<CustomServerExceptionDto> buchungNotFound(BuchungNotFoundException buchungNotFoundException) {
        return new ResponseEntity<>(new CustomServerExceptionDto("3000", buchungNotFoundException.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(StudentenvalidierungException.class)
    public ResponseEntity<CustomServerExceptionDto> handleValidationExceptions(StudentenvalidierungException studentenvalidierungException) {
        return new ResponseEntity<>(new CustomServerExceptionDto("4000", studentenvalidierungException.getMessage()), HttpStatus.EXPECTATION_FAILED);
    }
}
