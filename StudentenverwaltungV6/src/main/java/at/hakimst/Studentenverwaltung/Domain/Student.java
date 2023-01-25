package at.hakimst.Studentenverwaltung.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Size(min = 2)
    private String name;

    @Size(min = 4)
    private String plz;

    public Student(String name, String plz) {
        this.name = name;
        this.plz = plz;
    }

    public Student(Long id, String name, String plz) {
        this.id = id;
        this.name = name;
        this.plz = plz;
    }

    public Student() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }
}
