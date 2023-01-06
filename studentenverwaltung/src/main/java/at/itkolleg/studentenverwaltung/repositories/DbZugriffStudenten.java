package at.itkolleg.studentenverwaltung.repositories;

import at.itkolleg.studentenverwaltung.domain.Student;
import at.itkolleg.studentenverwaltung.exceptions.StudentNichtGefundenException;

import java.util.List;

/*
 * Data-Layer.
 * Über diesen greifen die anderen Layer später auf die DB zu
 * - diese wissen also nichts von der Technologie der Verbindung.
 */

public interface DbZugriffStudenten {

    Student studentSpeichern(Student student);
    List<Student> alleStudenten();
    Student studentMitId(Long id) throws StudentNichtGefundenException;
    List<Student> alleStudentenAusDemOrt(String plz);
    void studentLoeschenMitId(Long id);
}
