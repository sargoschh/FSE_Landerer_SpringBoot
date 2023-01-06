package at.itkolleg.studentenverwaltung;

import at.itkolleg.studentenverwaltung.domain.Student;
import at.itkolleg.studentenverwaltung.repositories.StudentJPARepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentenverwaltungApplication implements ApplicationRunner {

	/*
	 * DependencieInjection von Spring Boot
	 * Injiziert uns in die erstellte Variable ein Objekt von dem entsprechenden Typen
	 * SpringBoot prüft dann im gesamten Klassenpfad, an welchen Stellen ein passendes Bean existiert.
	 * Da es sich bei StudentJPARepo um ein Interface handelt, muss dann SpringBoot weiter nach einer
	 * Ausimplemeniterung suchen. Dabei werden alle Klassen, die das JpaRepository "eingebaut" haben, durchsucht.
	 * In diesem Fall wird wahrscheinlich das SimpleJpaRepository verwendet.
	 * Es kann nun also ganz einfach auf die Datenbank zugegriffen werden, ohne selbst die DB-Verbindung
	 * erstellen zu müssen - new StudentJPARepo ist nicht mehr notwendig.
	 */
	@Autowired
	StudentJPARepo studentJPARepo;

	public static void main(String[] args) {
		SpringApplication.run(StudentenverwaltungApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		this.studentJPARepo.save(new Student("Sarah Gosch", "6493"));
		this.studentJPARepo.save(new Student("Romana Gosch", "6491"));
		this.studentJPARepo.save(new Student("Marcel Schranz", "6471"));
	}
}
