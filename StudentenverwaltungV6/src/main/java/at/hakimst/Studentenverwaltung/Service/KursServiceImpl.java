package at.hakimst.Studentenverwaltung.Service;

import at.hakimst.Studentenverwaltung.Domain.Kurs;
import at.hakimst.Studentenverwaltung.Exceptions.KursNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KursServiceImpl implements KursService {

    private DbZugriffKurse dbZugriffKurse;

    public KursServiceImpl(DbZugriffKurse dbZugriffKurse) {
        this.dbZugriffKurse = dbZugriffKurse;
    }
    
    @Override
    public List<Kurs> gibAlleKurse() {
        return this.dbZugriffKurse.gibMirAlleKurse();
    }

    @Override
    public Kurs kursEinfuegen(Kurs kurs) {
        return this.dbZugriffKurse.kursSpeichern(kurs);
    }

    @Override
    public Kurs gibKursMitId(Long id) throws KursNotFoundException {
        return this.dbZugriffKurse.gibKurseMitId(id);
    }
}
