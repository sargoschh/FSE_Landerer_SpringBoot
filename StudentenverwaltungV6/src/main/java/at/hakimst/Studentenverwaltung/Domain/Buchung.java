package at.hakimst.Studentenverwaltung.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class Buchung {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Kurs kurs;
    @ManyToOne(fetch = FetchType.EAGER)
    private Student student;

    private Note note;

    public Buchung(Kurs kurs, Student student)
    {
        this.id = null;
        this.note = null;
        this.kurs = kurs;
        this.student = student;
    }
}
