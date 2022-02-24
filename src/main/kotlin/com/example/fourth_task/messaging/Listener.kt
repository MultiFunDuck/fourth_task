package com.example.fourth_task.messaging


import com.fasterxml.jackson.dataformat.xml.XmlMapper
import org.springframework.jms.annotation.JmsListener
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Component
import com.example.fourth_task.db.Person
import com.example.fourth_task.db.PersonService
import org.springframework.beans.factory.annotation.Autowired


@Component
class Listener {

    @Autowired
    lateinit var personService: PersonService

    @JmsListener(destination = "income.queue")
    @SendTo("outcome.queue")
    fun receiveMessage(xmlRequest: String){

        val xmlMapper =  XmlMapper()

        println("message is received")
        println(xmlRequest)
        val personList = xmlMapper.readValue(xmlRequest,Array<Person>::class.java)

        for(person in personList){
            if(!personService.isThereTheSame(person)){
                personService.create(person);
            }
            else{
                println("Ignoring Person{${person.lastname},${person.name}}")
            }
        }

    }

}