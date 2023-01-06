package at.itkolleg.studentenverwaltung.repositories;


import at.itkolleg.studentenverwaltung.domain.Student;
import at.itkolleg.studentenverwaltung.exceptions.StudentNichtGefundenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/*
 * Data-Layer.
 * Über diesen greifen die anderen Layer später auf die DB zu
 * - diese wissen also nichts von der Technologie der Verbindung.
 */

/*
 * Dadurch kann SpringBoot, wenn später an anderer Stelle "DbZugriffStudenten dbZugriffStudenten"
 * mit Autowired annotiert wird, auf die ausimplementierungen zugreifen.
 * Injizierbare Komponente
 */
@Component
public class DbZugriffStudentenJPA implements DbZugriffStudenten {

    private StudentJPARepo studentJPARepo;

    /*
     * Dies wäre ein anderer Weg, um Autowired zu verwenden.
     * Dieser Weg ist vor allem zur Automatisierten Testung angenehmer, weil man sich als Parameter bestimmte
     * Mocks injizieren lassen kann.
     */
    public DbZugriffStudentenJPA(StudentJPARepo studentJPARepo) {
        this.studentJPARepo = studentJPARepo;
    }

    @Override
    public Student studentSpeichern(Student student) {
        return studentJPARepo.save(student);
    }

    @Override
    public List<Student> alleStudenten() {
        return this.studentJPARepo.findAll();
    }

    @Override
    public Student studentMitId(Long id) throws StudentNichtGefundenException {
        Optional<Student> optStudent = this.studentJPARepo.findById(id);
        if(optStudent.isPresent()) {
            return optStudent.get();
        } else {
            throw new StudentNichtGefundenException("Student mit der ID " + id + " nicht gefunden!");
        }
    }

    @Override
    public List<Student> alleStudentenAusDemOrt(String plz) {
        return this.studentJPARepo.findAllByPlz(plz);
    }

    @Override
    public void studentLoeschenMitId(Long id) {
        this.studentJPARepo.deleteById(id);
    }
}
