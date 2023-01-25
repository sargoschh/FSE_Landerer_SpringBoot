package at.hakimst.Studentenverwaltung.Service;

import at.hakimst.Studentenverwaltung.Domain.Kurs;
import at.hakimst.Studentenverwaltung.Exceptions.KursNotFoundException;

import java.util.List;

public interface DbZugriffKurse {
    public Kurs kursSpeichern(Kurs kurs);

    public List<Kurs> gibMirAlleKurse();

    public Kurs gibKurseMitId(Long id) throws KursNotFoundException;
}
