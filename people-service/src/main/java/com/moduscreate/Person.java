package com.moduscreate;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.GenericGenerator;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@SocialSecurity
public class Person extends PanacheEntityBase {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    public String id;

    @Email
    @NotBlank
    @Column
    public String email;

    @NotBlank
    @Column(name = "first_name")
    public String firstName;

    @Column(name = "middle_name")
    public String middleName;

    @NotBlank
    @Column(name = "last_name")
    public String lastName;

    @Past
    @NotNull
    @Column(name = "birth_date")
    public LocalDate birthDate;

    @FutureOrPresent
    @NotNull
    @Column(name = "register_date")
    public LocalDate registerDate;
    
    @Pattern(regexp = "^(?!000|666)[0-8][0-9]{2}-(?!00)[0-9]{2}-(?!0000)[0-9]{4}$")
    @NotBlank
    @Column(name = "social_security")
    public String socialSecurity;

    @NotNull
    @Column(name = "issued_state")
    public SocialSecurityIssuedState issuedState;

    @NotNull
    @Column
    @Enumerated(EnumType.STRING)
    public Status status = Status.ACTIVE;

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", registerDate=" + registerDate +
                ", socialSecurity='" + socialSecurity + '\'' +
                ", issuedState=" + issuedState +
                ", status=" + status +
                '}';
    }
}

enum Status {
    ACTIVE, INACTIVE, BLOCKED
}
