package by.compit.websockets.repository;

import by.compit.websockets.Users;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UsersServiceImpl implements UsersService{

    UsersRepository usersRepository;


    @Override
    public List<Users> getAll() {
        return usersRepository.findAll();
    }

    @Override
    public Users getByLogin(String login) {
        return usersRepository.getUsersByLogin(login);
    }
}
