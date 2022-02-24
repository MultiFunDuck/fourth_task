package db

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id


@Entity
open class Person(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    open var id: Int,

    open var name: String,

    open var lastname: String


) {
    override fun toString(): String {
        return "Person(id=$id, name='$name', lastname='$lastname')"
    }
}