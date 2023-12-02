package by.compit.websockets;

import by.compit.websockets.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class WSController {

    @Autowired
    private WSService service;

    @Autowired
    private UsersRepository usersRepository;

    @PostMapping("/send-message")
    public void sendMessage(@RequestBody final Message message) {
        service.notifyFrontend(message.getMessageContent());
    }

    @PostMapping("/send-private-message/{id}")
    public void sendPrivateMessage(@PathVariable final String id,
                                   @RequestBody final Message message) {
            service.notifyUser(id, message.getMessageContent());
    }

    @Scheduled(fixedDelay = 10000)
    public void sendPrivateMessage() {
        List<Users> list = this.usersRepository.findAll();
        for (Users users: list){
            service.notifyUser(users.getId().toString(), "testString");
        }
    }
}
