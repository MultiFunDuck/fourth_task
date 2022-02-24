package messaging


import org.springframework.jms.annotation.JmsListener
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Component
import javax.jms.Message
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import db.Person
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jms.config.DefaultJmsListenerContainerFactory
import javax.annotation.PostConstruct


@Component
class Listener {
    @Autowired
    lateinit var factory: DefaultJmsListenerContainerFactory

    @JmsListener(containerFactory = "jmsListenerContainerFactory", destination = "income.queue")
    @SendTo("outcome.queue")
    fun receiveMessage(xmlMessage: Message){

        val xmlMapper = XmlMapper()
        val personList: Array<Person> = xmlMessage.getBody(Array<Person>::class.java)
        println("Received message $xmlMessage")
        println(personList.toString())

    }

    @PostConstruct
    fun itIsCreated(){
        println("Listener is created")
    }
}