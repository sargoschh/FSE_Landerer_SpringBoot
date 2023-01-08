package at.itkolleg.studentenverwaltung.controller;

import at.itkolleg.studentenverwaltung.domain.Student;
import at.itkolleg.studentenverwaltung.exceptions.StudentNichtGefundenException;
import at.itkolleg.studentenverwaltung.services.StudentenService;
import org.springframework.http.ResponseEntity;
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

    @PostMapping
    public ResponseEntity<Student> studentEinfuegen(@RequestBody Student student) {
        return ResponseEntity.ok(this.studentenService.studentEinfuegen(student));
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
