package at.hakimst.Studentenverwaltung.Repos;

import at.hakimst.Studentenverwaltung.Domain.Buchung;
import at.hakimst.Studentenverwaltung.Domain.Kurs;
import at.hakimst.Studentenverwaltung.Domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuchungenJPARepo extends JpaRepository<Buchung, Long> {
    List<Buchung> getAllByKurs(Kurs kurs);

    List<Buchung> getAllByStudent(Student student);
}
