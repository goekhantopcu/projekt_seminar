package de.gtopcu.seminar.user;

import de.gtopcu.seminar.database.DataBaseHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor(onConstructor__ = @Autowired)
public class UserServiceImpl implements UserService {
    private final DataBaseHelper helper;
    private final UserRepository repository;

    @Override
    public Mono<User> findUserById(long id) {
        return null;
    }

    @Override
    public Mono<User> findAllUserByFirstName(String firstName) {
        return null;
    }

    @Override
    public Mono<Void> createData() {
        return null;
    }
}
