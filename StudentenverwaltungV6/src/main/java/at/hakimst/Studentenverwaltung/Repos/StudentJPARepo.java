package at.hakimst.Studentenverwaltung.Repos;

import at.hakimst.Studentenverwaltung.Domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentJPARepo extends JpaRepository<Student, Long> {
    public Student findAllByName(String name);

    public Student findFirstByPlzContains(String partOfPLZ);
}
