package at.itkolleg.studentenverwaltung.services;

import at.itkolleg.studentenverwaltung.domain.Student;
import at.itkolleg.studentenverwaltung.exceptions.StudentNichtGefundenException;

import java.util.List;

public interface StudentenService {

    List<Student> gibAlleStudenten();
    Student studentEinfuegen(Student student);
    Student studentMitId(Long id) throws StudentNichtGefundenException;
    List<Student> alleStudentenMitPlz(String plz);
    void studentenLoeschenMitId(Long id);
}
