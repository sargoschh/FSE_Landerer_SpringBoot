package at.hakimst.Studentenverwaltung.Service;

import at.hakimst.Studentenverwaltung.Domain.Buchung;
import at.hakimst.Studentenverwaltung.Domain.Kurs;
import at.hakimst.Studentenverwaltung.Domain.Student;
import at.hakimst.Studentenverwaltung.Exceptions.KursNotFoundException;
import at.hakimst.Studentenverwaltung.Exceptions.StudentNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuchungenServiceImpl implements BuchungenService {

    DbZugriffBuchungen dbZugriffBuchungen;
    DbZugriffKurse dbZugriffKurse;
    DbZugriffStudenten dbZugriffStudenten;

    public BuchungenServiceImpl(DbZugriffBuchungen dbZugriffBuchungen, DbZugriffKurse dbZugriffKurse, DbZugriffStudenten dbZugriffStudenten) {
        this.dbZugriffBuchungen = dbZugriffBuchungen;
        this.dbZugriffKurse = dbZugriffKurse;
        this.dbZugriffStudenten = dbZugriffStudenten;
    }

    @Override
    public Buchung buchungErstellen(Student student, Kurs kurs) {
        Buchung buchung = new Buchung();
        buchung.setKurs(kurs);
        buchung.setStudent(student);
        return dbZugriffBuchungen.buchungSpeichern(buchung);
    }

    @Override
    public Buchung buchungErstellen(Long studentId, Long kursId) throws StudentNotFoundException, KursNotFoundException {
        Student student = dbZugriffStudenten.gibStudentenMitId(studentId);
        Kurs kurs = dbZugriffKurse.gibKurseMitId(kursId);
        Buchung buchung = new Buchung();
        buchung.setKurs(kurs);
        buchung.setStudent(student);
        return dbZugriffBuchungen.buchungSpeichern(buchung);
    }

    @Override
    public List<Buchung> gibAlleBuchungen() {
        return this.dbZugriffBuchungen.gibMirAlleBuchungen();
    }

    @Override
    public List<Buchung> gibAlleBuchungenVonStudent(Student student) {
        return this.dbZugriffBuchungen.alleBuchungenVonStudent(student);
    }

    @Override
    public List<Buchung> gibAlleBuchungenFuerKurs(Kurs kurs) {
        return this.dbZugriffBuchungen.alleBuchungenVonKurs(kurs);
    }
}
