package by.compit.websockets.repository;

import by.compit.websockets.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
    Users getUsersByLogin(String login);
    Optional<Users> findByLogin(String login);

}
