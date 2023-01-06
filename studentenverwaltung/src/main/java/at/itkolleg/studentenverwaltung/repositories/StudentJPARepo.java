package at.itkolleg.studentenverwaltung.repositories;

import at.itkolleg.studentenverwaltung.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * Als Bean annotiert.
 * Gibt an, dass es sich um eine Klasse handelt, von der SpringBoot eine Instanz bilden kann -
 * und zwar überall dort, wo @Autowired über eine neue Instanz geschrieben wird.
 */
@Repository
public interface StudentJPARepo extends JpaRepository<Student, Long> {

    /*
     * Hält man eine bestimmte Syntax ein (findAllBy...), kann SpringBoot dies automatisch verarbeiten.
     * Möchte man ganz sichergehen, dass der richtige SQL-Befehl verwendet wird, kann man
     * dies mit der Annotation @Query("SQL-Befehl") steuern
     */
    List<Student> findAllByPlz(String plz);
}
