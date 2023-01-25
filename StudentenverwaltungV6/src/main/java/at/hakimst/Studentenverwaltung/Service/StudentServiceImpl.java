package at.hakimst.Studentenverwaltung.Service;

import at.hakimst.Studentenverwaltung.Domain.Student;
import at.hakimst.Studentenverwaltung.Exceptions.StudentNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private DbZugriffStudenten dbZugriffStudenten;

    public StudentServiceImpl(DbZugriffStudenten dbZugriffStudenten) {
        this.dbZugriffStudenten = dbZugriffStudenten;
    }


    public List<Student> gibAlleStudenten() {
        return this.dbZugriffStudenten.gibMirAlleStudenten();
    }

    public Student studentEinfuegen(Student student) {
        return this.dbZugriffStudenten.studentSpeichern(student);
    }

    @Override
    public Student gibStudentenMitId(Long id) throws StudentNotFoundException {
        return this.dbZugriffStudenten.gibStudentenMitId(id);
    }

    @Override
    public void studentLoeschen(Long id) {
        this.dbZugriffStudenten.studentLoeschenMitId(id);
    }
}
