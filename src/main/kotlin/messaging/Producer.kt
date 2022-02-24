package messaging

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jms.core.JmsTemplate
import org.springframework.stereotype.Component


@Component
class Producer {
    @Autowired
    var jmsTemplate: JmsTemplate? = null

    fun sendMessage(queueName: String, message: String?) {

        println("Sending message " + message + "to queue - " + queueName)
        jmsTemplate!!.send(
            queueName
        ) { session -> session.createTextMessage() }
    }
}
