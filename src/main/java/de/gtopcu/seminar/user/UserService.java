package de.gtopcu.seminar.user;

import de.gtopcu.seminar.user.User;
import reactor.core.publisher.Mono;

public interface UserService {
    Mono<User> findUserById(long id);
    Mono<User> findAllUserByFirstName(String firstName);
    Mono<Void> createData();
}
