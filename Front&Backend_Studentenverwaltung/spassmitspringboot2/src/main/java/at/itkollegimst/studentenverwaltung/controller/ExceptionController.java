package at.itkollegimst.studentenverwaltung.controller;

import at.itkollegimst.studentenverwaltung.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(StudentNichtGefunden.class)
    public ResponseEntity<ExceptionDTO> studentNichtGefunden(StudentNichtGefunden studentNichtGefunden)
    {
        return new ResponseEntity<>(new ExceptionDTO("1000",studentNichtGefunden.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(StudentValidierungFehlgeschlagen.class)
    public ResponseEntity<FormValidierungExceptionDTO> studentValidierungFehlgeschlagen(StudentValidierungFehlgeschlagen studentValidierungFehlgeschlagen)
    {
        return new ResponseEntity<>(studentValidierungFehlgeschlagen.getErrorMap(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(KursNichtGefunden.class)
    public ResponseEntity<ExceptionDTO> kursNichtGefunden(KursNichtGefunden kursNichtGefunden) {

        return new ResponseEntity<>(new ExceptionDTO("1500", kursNichtGefunden.getMessage()), HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<FormValidierungExceptionDTO> kursValidierungFehlgeschlagen(KursValidierungFehlgeschlagen kursValidierungFehlgeschlagen) {

        return new ResponseEntity<>(kursValidierungFehlgeschlagen.getErrorMap(), HttpStatus.BAD_REQUEST);
    }
}
