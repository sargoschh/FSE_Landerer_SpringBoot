package at.hakimst.Studentenverwaltung.Service;

import at.hakimst.Studentenverwaltung.Domain.Student;
import at.hakimst.Studentenverwaltung.Exceptions.StudentNotFoundException;

import java.util.List;

public interface DbZugriffStudenten {
    public Student studentSpeichern(Student student);

    public List<Student> gibMirAlleStudenten();

    public Student gibStudentenMitId(Long id) throws StudentNotFoundException;

    public void studentLoeschenMitId(Long id);
}
