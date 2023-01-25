package at.itkollegimst.studentenverwaltung.repositories;

import at.itkollegimst.studentenverwaltung.domain.Kurs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface KursJPARepo extends JpaRepository<Kurs, Long> {

    List<Kurs> findAllByHours(int hours);
    List<Kurs> findAllByBeginDate(Date beginDate);
    List<Kurs> findAllByEndDate(Date endDate);
}
