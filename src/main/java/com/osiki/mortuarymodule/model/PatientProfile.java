package com.osiki.mortuarymodule.model;

import com.osiki.mortuarymodule.enums.Gender;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "patient_profile")
public class PatientProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String firstname;
    private String lastname;
    private int age;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String causeOfDeath;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;

    public PatientProfile() {

    }

    public PatientProfile(Long id, String firstname, String lastname, int age, Gender gender, String causeOfDeath, LocalDate dateOfBirth, LocalDate dateOfDeath) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.gender = gender;
        this.causeOfDeath = causeOfDeath;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
    }


    public String getFirstname() {
        return firstname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getCauseOfDeath() {
        return causeOfDeath;
    }

    public void setCauseOfDeath(String causeOfDeath) {
        this.causeOfDeath = causeOfDeath;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(LocalDate dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }
}
