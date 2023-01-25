package at.itkollegimst.studentenverwaltung.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.sql.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Kurs {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Size(min = 2, max = 255, message = "Die Kursbeschreibung '$...' ist ungültig. Die Kursbeschreibung muss zwischen {min} und {max} Zeichen lang sein.")
    private String beschreibung;
    @Min(value = 1, message = "Die Kursdauer muss mindestens {value} h betragen.")
    @Max(value = 250, message = "Die Kursdauer darf nicht länger als {value} sein!")
    private int hours;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date beginDate;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date endDate;

    public Kurs(String beschreibung, int hours, Date beginDate, Date endDate) {
        this.beschreibung = beschreibung;
        this.hours = hours;
        this.beginDate = beginDate;
        this.endDate = endDate;
    }
}
