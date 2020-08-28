package com.moduscreate

import io.quarkus.hibernate.orm.panache.kotlin.PanacheCompanion
import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntityBase
import org.hibernate.annotations.GenericGenerator
import java.time.LocalDate
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "\"User\"")
class User: PanacheEntityBase {

    companion object: PanacheCompanion<User, String> {
        fun findByEmail(email: String) = find("email", email).firstResult()
    }

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    lateinit var id: String

    @Column
    lateinit var email: String

    @Column
    lateinit var password: String

    @Column
    lateinit var name: String

    @Column(name = "birth_date")
    lateinit var birthDate: LocalDate

    @Column
    @Enumerated(EnumType.STRING)
    lateinit var status: Status

}

enum class Status {
    ACTIVE, INACTIVE, BLOCKED
}
