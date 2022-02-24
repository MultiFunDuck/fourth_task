package db

import org.springframework.data.repository.CrudRepository

interface PersonRepo : CrudRepository<Person, Int>{
    fun findAllByNameAndLastname(name: String, lastname: String): List<Person>
}