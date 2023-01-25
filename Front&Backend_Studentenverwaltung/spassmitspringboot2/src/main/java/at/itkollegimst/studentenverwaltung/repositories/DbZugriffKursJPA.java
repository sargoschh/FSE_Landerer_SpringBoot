package at.itkollegimst.studentenverwaltung.repositories;

import at.itkollegimst.studentenverwaltung.domain.Kurs;
import at.itkollegimst.studentenverwaltung.exceptions.KursNichtGefunden;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DbZugriffKursJPA implements DbZugriffKurs {

    private KursJPARepo kursJPARepo;

    public DbZugriffKursJPA(KursJPARepo kursJPARepo) {
        this.kursJPARepo = kursJPARepo;
    }

    @Override
    public Kurs kursSpeichern(Kurs kurs) {
        return this.kursJPARepo.save(kurs);
    }

    @Override
    public List<Kurs> alleKurse() {
        return this.kursJPARepo.findAll();
    }

    @Override
    public List<Kurs> alleKurseMitDauer(int dauer) {
        return this.kursJPARepo.findAllByHours(dauer);
    }

    @Override
    public Kurs kursMitId(Long id) throws KursNichtGefunden {
        Optional<Kurs> optKurs = this.kursJPARepo.findById(id);
        if(optKurs.isPresent()) {
            return optKurs.get();
        } else {
            throw new KursNichtGefunden("Kurs mit der ID " + id + " nicht gefunden.");
        }
    }

    @Override
    public Kurs kursLoeschenMitId(Long id) throws KursNichtGefunden {
        Kurs kurs = this.kursMitId(id);
        this.kursJPARepo.deleteById(kurs.getId());
        return kurs;
    }
}
