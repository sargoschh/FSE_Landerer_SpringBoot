package at.itkolleg.studentenverwaltung.controller;

import at.itkolleg.studentenverwaltung.domain.Student;
import at.itkolleg.studentenverwaltung.exceptions.StudentNichtGefundenException;
import at.itkolleg.studentenverwaltung.exceptions.StudentValidierungFehlgeschlagenException;
import at.itkolleg.studentenverwaltung.services.StudentenService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * Alle Methoden, die nun definiert werden, haben einen ResponseBody.
 * Alles wird in JSON umgewandelt.
 */

@RestController
@RequestMapping("/api/v1/studenten")
public class StudentRestController {

    private StudentenService studentenService;

    public StudentRestController(StudentenService studentenService) {
        this.studentenService = studentenService;
    }

    /*
     * Auch ein Wrapper, der z.B. den HTTP-Body sowie den HTTP-Header kapselt.
     */
    @GetMapping
    public ResponseEntity<List<Student>> gibAlleStudenten() {
        //.ok ist HTTP-Status 200
        return ResponseEntity.ok(this.studentenService.gibAlleStudenten());
    }

    /*
     * @Valid - so wird sozusagen die Validierungsfunktion angeschmissen
     * BindingResult - wenn die Validierung beim Erstellen eines Studenten ein Problem hat, dann werden diese
     * Probleme im BindingResult gespeichert und dem User mitgegeben.
     */
    @PostMapping
    public ResponseEntity<Student> studentEinfuegen(@Valid @RequestBody Student student, BindingResult bindingResult)
            throws StudentValidierungFehlgeschlagenException {
        String errors = "";
        if(bindingResult.hasErrors()) {
            for(ObjectError error : bindingResult.getAllErrors()) {
                errors += "Validierungsfehler für Objekt " + error.getObjectName() +
                        " im Feld " + ((FieldError)error).getField() + " mit folgendem Problem: " +
                        error.getDefaultMessage();
            }
            throw new StudentValidierungFehlgeschlagenException(errors);
        } else {
            return ResponseEntity.ok(this.studentenService.studentEinfuegen(student));
        }
    }

    @DeleteMapping("/{id}")
    public String studentLoeschen(@PathVariable Long id) {
        this.studentenService.studentenLoeschenMitId(id);
        return "Studenten gelöscht!";
    }

    @GetMapping("/mitplz/{plz}")
    public ResponseEntity<List<Student>> alleStudentenMitPlz(@PathVariable String plz) {
        return ResponseEntity.ok(this.studentenService.alleStudentenMitPlz(plz));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> studentMitId(@PathVariable Long id) throws StudentNichtGefundenException {
        return ResponseEntity.ok(this.studentenService.studentMitId(id));
    }
}
