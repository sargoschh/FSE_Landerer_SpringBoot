package at.hakimst.Studentenverwaltung.Repos;

import at.hakimst.Studentenverwaltung.Domain.Buchung;
import at.hakimst.Studentenverwaltung.Domain.Kurs;
import at.hakimst.Studentenverwaltung.Domain.Student;
import at.hakimst.Studentenverwaltung.Exceptions.BuchungNotFoundException;
import at.hakimst.Studentenverwaltung.Service.DbZugriffBuchungen;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBZugriffBuchungenJPAH2 implements DbZugriffBuchungen {

    private BuchungenJPARepo buchungenJPARepo;

    public DBZugriffBuchungenJPAH2(BuchungenJPARepo buchungenJPARepo) {
        this.buchungenJPARepo = buchungenJPARepo;
    }


    @Override
    public Buchung buchungSpeichern(Buchung buchung) {

        return this.buchungenJPARepo.save(buchung);
    }

    @Override
    public List<Buchung> gibMirAlleBuchungen() {

        List<Buchung> buchungen = this.buchungenJPARepo.findAll();
        for(Buchung buchung : buchungen)
        {
            System.out.println(buchung);
        }

        return this.buchungenJPARepo.findAll();
    }

    @Override
    public Buchung gibBuchungMitId(Long id) throws BuchungNotFoundException {
        return this.buchungenJPARepo.findById(id).orElseThrow(BuchungNotFoundException::new);
    }

    @Override
    public List<Buchung> alleBuchungenVonStudent(Student student) {
        return this.buchungenJPARepo.getAllByStudent(student);
    }

    @Override
    public List<Buchung> alleBuchungenVonKurs(Kurs kurs) {
        return this.buchungenJPARepo.getAllByKurs(kurs);
    }
}
