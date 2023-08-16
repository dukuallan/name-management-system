package org.pahappa.systems.namemis.models.animal;

import org.sers.webutils.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "animals")
public class Animal extends BaseEntity {
    private String animalName;
    private String animalAge;
    @Column(name = "animal_name")
    public String getAnimalName() {
        return animalName;
    }
    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    @Column(name = "animal_age")
    public String getAnimalAge() {
        return animalAge;
    }

    public void setAnimalAge(String animalAge) {
        this.animalAge = animalAge;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "animalName='" + animalName + '\'' +
                ", animalAge='" + animalAge + '\'' +
                '}';
    }
}
