package by.compit.websockets.repository;

import by.compit.websockets.Users;

import java.util.List;

public interface UsersService {
    List<Users> getAll();
    Users getByLogin(String login);
}
