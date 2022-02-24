package com.example.fourth_task.db

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


interface PersonService{
    fun create(person: Person)
    fun isThereTheSame(person: Person): Boolean
}

@Service
class PersonServiceImp: PersonService {

    @Autowired
    lateinit var personRepo: PersonRepo

    override fun create(person: Person) {
        personRepo.save(person)
    }

    override fun isThereTheSame(person: Person): Boolean {
        return personRepo.findAllByNameAndLastname(
            person.name,
            person.lastname
        ).isNotEmpty()
    }

}