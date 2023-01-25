package at.hakimst.Studentenverwaltung.Service;

import at.hakimst.Studentenverwaltung.Domain.Kurs;
import at.hakimst.Studentenverwaltung.Exceptions.KursNotFoundException;

import java.util.List;

public interface KursService {

    public List<Kurs> gibAlleKurse();

    public Kurs kursEinfuegen(Kurs kurs);

    public Kurs gibKursMitId(Long id) throws KursNotFoundException;
}
