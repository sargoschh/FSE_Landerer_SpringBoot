package at.itkolleg.studentenverwaltung.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * Lombok Annotationen
 * Entity - zeigt SpringBoot, dass es sich um eine Entity der DB handelt
 * AllArgsConstructor - erstellt einen Konstruktor mit allen Argumenten
 * NoArgsConstructor - erstellt einen Konstruktor mit keinen Argumenten
 * Erstellt alle Getter und Setter
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {

    /*
     * Geben an, dass es sich dabei um den Primärschlüssel handelt und dass dieser aufsteigend gebildet wird.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Size(min=2)
    private String name;

    @Size(min=4,max=6)
    private String plz;

    public Student(String name, String plz) {
        this.name = name;
        this.plz = plz;
    }
}
