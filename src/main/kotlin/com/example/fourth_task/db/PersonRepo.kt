package com.example.fourth_task.db

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository("PersonRepo")
interface PersonRepo : CrudRepository<Person, Int>{
    fun findAllByNameAndLastname(name: String, lastname: String): List<Person>
}