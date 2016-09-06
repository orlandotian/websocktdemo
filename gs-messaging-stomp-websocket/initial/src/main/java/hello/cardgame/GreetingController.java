package hello.cardgame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {

    private SimpMessagingTemplate template;

    @Autowired
    GreetingController(SimpMessagingTemplate t) {
        template = t;
    }

    @MessageMapping("/hello/{id}")
    @SendTo("/topic/greetings/{id}")
    public Greeting greeting(HelloMessage message, @DestinationVariable("id") Integer id) throws Exception {
        String result = GameManager.checkSpeak(id, message.getName(), message.getContent());
        if(result == null) {
            updateStatus(id);
            return new Greeting(message.getName() + ":" + message.getContent());
        } else {
            updateStatus(id);
            return systemBroadcast(result);
        }
    }

    @MessageMapping("/hello/getcard/{id}")
    @SendTo("/topic/greetings/{id}")
    public Greeting getcard(HelloMessage message, @DestinationVariable("id") Integer id) throws Exception {
        String result = GameManager.getCard(id, message.getName());
        updateStatus(id);
        return systemBroadcast(result);
    }

    public Greeting systemBroadcast(String text) {
        return new Greeting("系统:" + text);
    }

    public void updateStatus(int id) throws Exception {
//        template.setDefaultDestination("/app");
//        template.setUserDestinationPrefix("/user/");
        template.convertAndSend("/topic/status/" + id, GameManager.getStatus(id));
    }
}