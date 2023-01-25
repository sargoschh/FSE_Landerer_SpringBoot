package at.hakimst.Studentenverwaltung.Repos;

import at.hakimst.Studentenverwaltung.Domain.Student;
import at.hakimst.Studentenverwaltung.Exceptions.StudentNotFoundException;
import at.hakimst.Studentenverwaltung.Service.DbZugriffStudenten;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DBZugriffStudentenJPAH2 implements DbZugriffStudenten {

    StudentJPARepo studentRepo;

    public DBZugriffStudentenJPAH2(StudentJPARepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public Student studentSpeichern(Student student) {
        this.studentRepo.save(student);
        return null;
    }

    @Override
    public List<Student> gibMirAlleStudenten() {
        return this.studentRepo.findAll();
    }

    @Override
    public Student gibStudentenMitId(Long id) throws StudentNotFoundException {
        Optional<Student> studentOptional = studentRepo.findById(id);
        if (studentOptional.isPresent()) {
            return studentOptional.get();
        } else {
            throw new StudentNotFoundException();
        }
    }

    @Override
    public void studentLoeschenMitId(Long id) {
        this.studentRepo.deleteById(id);
    }
}
