package at.hakimst.Studentenverwaltung.Service;

import at.hakimst.Studentenverwaltung.Domain.Buchung;
import at.hakimst.Studentenverwaltung.Domain.Kurs;
import at.hakimst.Studentenverwaltung.Domain.Student;
import at.hakimst.Studentenverwaltung.Exceptions.BuchungNotFoundException;

import java.util.List;

public interface DbZugriffBuchungen {

    public Buchung buchungSpeichern(Buchung buchung);

    public List<Buchung> gibMirAlleBuchungen();

    public Buchung gibBuchungMitId(Long id) throws BuchungNotFoundException;

    public List<Buchung> alleBuchungenVonStudent(Student student);

    public List<Buchung> alleBuchungenVonKurs(Kurs kurs);
}
