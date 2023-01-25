package at.hakimst.Studentenverwaltung.Repos;

import at.hakimst.Studentenverwaltung.Domain.Kurs;
import at.hakimst.Studentenverwaltung.Exceptions.KursNotFoundException;
import at.hakimst.Studentenverwaltung.Service.DbZugriffKurse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBZugriffKurseJPAH2 implements DbZugriffKurse {

    private KursJPARepo kursJPARepo;


    public DBZugriffKurseJPAH2(KursJPARepo kursJPARepo) {
        this.kursJPARepo = kursJPARepo;
    }

    @Override
    public Kurs kursSpeichern(Kurs kurs) {
        return this.kursJPARepo.save(kurs);
    }

    @Override
    public List<Kurs> gibMirAlleKurse() {
        return this.kursJPARepo.findAll();
    }

    @Override
    public Kurs gibKurseMitId(Long id) throws KursNotFoundException {
        return this.kursJPARepo.findById(id).orElseThrow(KursNotFoundException::new);
    }
}
