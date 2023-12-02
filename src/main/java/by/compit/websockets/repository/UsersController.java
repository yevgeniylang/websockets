package by.compit.websockets.repository;

import by.compit.websockets.Users;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UsersController {

    UsersService usersService;

    @GetMapping("/allUsers")
    public List<Users> getAllUsers(){
        return this.usersService.getAll();
    }
}
