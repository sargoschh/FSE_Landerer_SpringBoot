package at.itkollegimst.studentenverwaltung.repositories;

import at.itkollegimst.studentenverwaltung.domain.Kurs;
import at.itkollegimst.studentenverwaltung.exceptions.KursNichtGefunden;

import java.util.List;

public interface DbZugriffKurs {

    Kurs kursSpeichern(Kurs kurs);
    List<Kurs> alleKurse();
    List<Kurs> alleKurseMitDauer(int dauer);
    Kurs kursMitId(Long id) throws KursNichtGefunden;
    Kurs kursLoeschenMitId(Long id) throws KursNichtGefunden;
}
