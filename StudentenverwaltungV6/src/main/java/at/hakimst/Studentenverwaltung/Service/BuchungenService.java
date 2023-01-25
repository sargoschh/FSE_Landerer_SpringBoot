package at.hakimst.Studentenverwaltung.Service;

import at.hakimst.Studentenverwaltung.Domain.Buchung;
import at.hakimst.Studentenverwaltung.Domain.Kurs;
import at.hakimst.Studentenverwaltung.Domain.Student;
import at.hakimst.Studentenverwaltung.Exceptions.KursNotFoundException;
import at.hakimst.Studentenverwaltung.Exceptions.StudentNotFoundException;

import java.util.List;

public interface BuchungenService {
    Buchung buchungErstellen(Student student, Kurs kurs);
    Buchung buchungErstellen(Long studentId, Long kursId) throws StudentNotFoundException, KursNotFoundException;
    List<Buchung> gibAlleBuchungen();
    List<Buchung> gibAlleBuchungenVonStudent(Student student);
    List<Buchung> gibAlleBuchungenFuerKurs(Kurs kurs);
}
