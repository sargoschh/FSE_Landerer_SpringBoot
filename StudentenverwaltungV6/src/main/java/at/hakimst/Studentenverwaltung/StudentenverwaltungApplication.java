package at.hakimst.Studentenverwaltung;

import at.hakimst.Studentenverwaltung.Domain.Buchung;
import at.hakimst.Studentenverwaltung.Domain.Kurs;
import at.hakimst.Studentenverwaltung.Domain.Student;
import at.hakimst.Studentenverwaltung.Repos.KursJPARepo;
import at.hakimst.Studentenverwaltung.Repos.StudentJPARepo;
import at.hakimst.Studentenverwaltung.Service.DbZugriffBuchungen;
import at.hakimst.Studentenverwaltung.Service.DbZugriffKurse;
import at.hakimst.Studentenverwaltung.Service.DbZugriffStudenten;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentenverwaltungApplication implements ApplicationRunner {

	@Autowired
	DbZugriffStudenten dbZugriffStudenten;
	@Autowired
	DbZugriffKurse dbZugriffKurse;
	@Autowired
	DbZugriffBuchungen dbZugriffBuchungen;

	public static void main(String[] args) {
		SpringApplication.run(StudentenverwaltungApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Student s1 = new Student("Claudio Landerer", "6060");
		Student s2 = new Student("Harald Klotz", "2323");
		Student s3 = new Student("Maria Kera", "5789");
		dbZugriffStudenten.studentSpeichern(s1);
		dbZugriffStudenten.studentSpeichern(s2);
		dbZugriffStudenten.studentSpeichern(s3);

		Kurs k1 = new Kurs("POS1",2);
		Kurs k2 = new Kurs("DBI",1);
		Kurs k3 = new Kurs("SYP",4);

		dbZugriffKurse.kursSpeichern(k1);
		dbZugriffKurse.kursSpeichern(k2);
		dbZugriffKurse.kursSpeichern(k3);

		dbZugriffBuchungen.buchungSpeichern(new Buchung(k1,s1));
		dbZugriffBuchungen.buchungSpeichern(new Buchung(k1,s2));
		dbZugriffBuchungen.buchungSpeichern(new Buchung(k1,s3));
		dbZugriffBuchungen.buchungSpeichern(new Buchung(k2,s3));
		dbZugriffBuchungen.buchungSpeichern(new Buchung(k2,s1));
		dbZugriffBuchungen.buchungSpeichern(new Buchung(k3,s3));
	}
}
