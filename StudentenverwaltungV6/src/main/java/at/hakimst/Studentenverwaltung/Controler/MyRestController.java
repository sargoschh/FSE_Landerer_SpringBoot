package at.hakimst.Studentenverwaltung.Controler;

import at.hakimst.Studentenverwaltung.Domain.Buchung;
import at.hakimst.Studentenverwaltung.Domain.Kurs;
import at.hakimst.Studentenverwaltung.Domain.Student;
import at.hakimst.Studentenverwaltung.Exceptions.KursNotFoundException;
import at.hakimst.Studentenverwaltung.Exceptions.StudentNotFoundException;
import at.hakimst.Studentenverwaltung.Exceptions.StudentenvalidierungException;
import at.hakimst.Studentenverwaltung.Service.BuchungenService;
import at.hakimst.Studentenverwaltung.Service.KursService;
import at.hakimst.Studentenverwaltung.Service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class MyRestController {

    StudentService studentService;
    BuchungenService buchungenService;
    KursService kursService;

    public MyRestController(StudentService studentService, BuchungenService buchungenService, KursService kursService) {
        this.studentService = studentService;
        this.buchungenService = buchungenService;
        this.kursService = kursService;
    }

    @GetMapping("api/v1/")
    public ResponseEntity halloWelt() {
        return ResponseEntity.ok("Hallo Welt");
    }


    @PostMapping("api/v1/studenten/")
    public ResponseEntity<Student> studentHinzufuegen(@Valid @RequestBody Student student, BindingResult bindingResult) throws StudentenvalidierungException {
        String errors = "";
        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                errors += "\nValidierungsfehler fuer Objekt " + error.getObjectName() + " im Feld: " + ((FieldError) error).getField() + " mit folgendem Problem: " + error.getDefaultMessage();
            }
            throw new StudentenvalidierungException(errors);
        } else {
            Student eingefuegt = this.studentService.studentEinfuegen(student);
            return ResponseEntity.ok(student);
        }
    }

    @GetMapping("api/v1/kurse/")
    public ResponseEntity<List<Kurs>> alleKurse() {
        return ResponseEntity.ok(this.kursService.gibAlleKurse());
    }


    @PostMapping("api/v1/kurse/")
    public ResponseEntity<Kurs> studentHinzufuegen(@RequestBody Kurs kurs) {
        Kurs eingefuegt = this.kursService.kursEinfuegen(kurs);
        return ResponseEntity.ok(eingefuegt);
    }

    @GetMapping("api/v1/buchungen/")
    public ResponseEntity<List<Buchung>> alleBuchungen() {
        return ResponseEntity.ok(this.buchungenService.gibAlleBuchungen());
    }

    @GetMapping("api/v1/buchungen/student/{studentId}")
    public ResponseEntity<List<Buchung>> alleBuchungenVonStudent(@PathVariable Long studentId) throws StudentNotFoundException {
        Student s = this.studentService.gibStudentenMitId(studentId);
        return ResponseEntity.ok(this.buchungenService.gibAlleBuchungenVonStudent(s));
    }

    @GetMapping("api/v1/buchungen/kurs/{courseId}")
    public ResponseEntity<List<Buchung>> alleBuchungenFuerKurs(@PathVariable Long courseId) throws KursNotFoundException {
        Kurs k = this.kursService.gibKursMitId(courseId);
        return ResponseEntity.ok(this.buchungenService.gibAlleBuchungenFuerKurs(k));
    }

    @PostMapping("api/v1/buchungen/{studentId}/{courseId}")
    public ResponseEntity<Buchung> studentHinzufuegen(@PathVariable Long studentId, @PathVariable Long courseId) throws StudentNotFoundException, KursNotFoundException {
        return ResponseEntity.ok(this.buchungenService.buchungErstellen(studentId, courseId));
    }

    @GetMapping("api/v1/studenten/{id}")
    public ResponseEntity<Student> gibStudent(@PathVariable Long id) throws StudentNotFoundException {
        return ResponseEntity.ok(this.studentService.gibStudentenMitId(id));
    }

    @GetMapping("api/v1/studenten/")
    public ResponseEntity<List<Student>> gibAlleStudenten() {
        return ResponseEntity.ok(this.studentService.gibAlleStudenten());
    }

}
