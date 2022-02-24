package com.example.fourth_task

import com.example.fourth_task.db.Person
import com.example.fourth_task.db.PersonService
import com.example.fourth_task.db.PersonServiceImp
import com.example.fourth_task.messaging.Listener
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.jms.annotation.EnableJms

@SpringBootApplication
@EnableJms
class FourthTaskApplication


fun main(args: Array<String>) {
    runApplication<FourthTaskApplication>(*args)
}
