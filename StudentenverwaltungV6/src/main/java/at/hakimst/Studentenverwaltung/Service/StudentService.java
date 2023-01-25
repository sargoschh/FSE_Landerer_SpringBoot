package at.hakimst.Studentenverwaltung.Service;

import at.hakimst.Studentenverwaltung.Domain.Student;
import at.hakimst.Studentenverwaltung.Exceptions.StudentNotFoundException;

import java.util.List;

public interface StudentService {
    public List<Student> gibAlleStudenten();

    public Student studentEinfuegen(Student student);

    public Student gibStudentenMitId(Long id) throws StudentNotFoundException;

    public void studentLoeschen(Long id);
}
