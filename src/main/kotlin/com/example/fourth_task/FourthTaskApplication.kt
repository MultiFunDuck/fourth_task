package com.example.fourth_task

import org.apache.activemq.ActiveMQConnectionFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jms.annotation.EnableJms
import org.springframework.jms.config.DefaultJmsListenerContainerFactory
import org.springframework.jms.core.JmsTemplate


@SpringBootApplication
@EnableJms
class FourthTaskApplication


fun main(args: Array<String>) {
    runApplication<FourthTaskApplication>(*args)
}
