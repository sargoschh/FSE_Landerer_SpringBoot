package at.itkollegimst.studentenverwaltung;

import at.itkollegimst.studentenverwaltung.domain.Student;
import at.itkollegimst.studentenverwaltung.repositories.DbZugriffStudenten;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentenverwaltungApplication implements ApplicationRunner {

	@Autowired
	DbZugriffStudenten dbZugriffStudenten;

	public static void main(String[] args) {
		SpringApplication.run(StudentenverwaltungApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		this.dbZugriffStudenten.studentSpeichern(new Student("Sarah Gosch","6493"));
		this.dbZugriffStudenten.studentSpeichern(new Student("Marcel Schranz","6471"));
		this.dbZugriffStudenten.studentSpeichern(new Student("Romana Gosch","6491"));
		this.dbZugriffStudenten.studentSpeichern(new Student("Jutta Hammerle","6492"));
	}
}
