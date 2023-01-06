package at.itkolleg.studentenverwaltung.services;

import at.itkolleg.studentenverwaltung.domain.Student;
import at.itkolleg.studentenverwaltung.exceptions.StudentNichtGefundenException;
import at.itkolleg.studentenverwaltung.repositories.DbZugriffStudenten;

import java.util.List;

/*
 * Normalerweise würde man an dieser Stelle auch Geschäftslogik verbaut -
 * da wir aber nur mit CRUD-Methoden arbeiten, fällt dies weg.
 */

public class StudentenServiceImpl implements StudentenService {

    private DbZugriffStudenten dbZugriffStudenten;

    public StudentenServiceImpl(DbZugriffStudenten dbZugriffStudenten) {
        this.dbZugriffStudenten = dbZugriffStudenten;
    }

    @Override
    public List<Student> gibAlleStudenten() {
        return this.dbZugriffStudenten.alleStudenten();
    }

    @Override
    public Student studentEinfuegen(Student student) {
        return this.dbZugriffStudenten.studentSpeichern(student);
    }

    @Override
    public Student studentMitId(Long id) throws StudentNichtGefundenException {
        return this.studentMitId(id);
    }

    @Override
    public List<Student> alleStudentenMitPlz(String plz) {
        return this.dbZugriffStudenten.alleStudentenAusDemOrt(plz);
    }

    @Override
    public void studentenLoeschenMitId(Long id) {
        this.dbZugriffStudenten.studentLoeschenMitId(id);
    }
}
