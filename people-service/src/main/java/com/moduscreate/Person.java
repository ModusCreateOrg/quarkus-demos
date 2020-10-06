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

import org.hibernate.annotations.GenericGenerator;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
public class Person extends PanacheEntityBase {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    public String id;

    @Email
    @NotNull
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
    @Column(name = "birth_date")
    public LocalDate birthDate;

    @FutureOrPresent
    @Column(name = "register_date")
    public LocalDate registerDate;

    @SocialSecurity
    @NotBlank
    @Column(name = "social_security")
    public String socialSecurity;

    @NotNull
    @Column
    @Enumerated(EnumType.STRING)
    public Status status = Status.ACTIVE;

}

enum Status {
    ACTIVE, INACTIVE, BLOCKED
}
