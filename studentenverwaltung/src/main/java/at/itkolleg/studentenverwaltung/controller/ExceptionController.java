package at.itkolleg.studentenverwaltung.controller;

import at.itkolleg.studentenverwaltung.exceptions.ExceptionDTO;
import at.itkolleg.studentenverwaltung.exceptions.StudentNichtGefundenException;
import at.itkolleg.studentenverwaltung.exceptions.StudentValidierungFehlgeschlagenException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/*
 * Damit weiß SpringBoot, dass es sich bei der Klasse um einen Exception Controller handelt.
 */
@ControllerAdvice
public class ExceptionController {

    /*
     * Diese Methode wird nun aufgerufen, wenn eine StudentNichtGefundenException geworfen wird -
     * wir können nun also steuern, wie unsere Fehlermeldung aussieht.
     */
    @ExceptionHandler(StudentNichtGefundenException.class)
    public ResponseEntity<ExceptionDTO> studentNichtGefunden(StudentNichtGefundenException studentNichtGefunden) {
        return new ResponseEntity<>(new ExceptionDTO("1000", studentNichtGefunden.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(StudentValidierungFehlgeschlagenException.class)
    public ResponseEntity<ExceptionDTO> studentValidierungFehlgeschlagen(StudentValidierungFehlgeschlagenException studentValidierungFehlgeschlagen) {
        return new ResponseEntity<>(new ExceptionDTO("9000", studentValidierungFehlgeschlagen.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
