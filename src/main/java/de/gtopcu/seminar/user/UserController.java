package de.gtopcu.seminar.user;

import de.gtopcu.seminar.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor(onConstructor__ = @Autowired)
public class UserController {
    private final UserService userService;

    @GetMapping(path = "/create-data")
    public Mono<Void> createData() {
        return Mono.empty();
    }

    @PostMapping(path = "/postcodes", consumes = "text/csv")
    public Mono<Void> updatePostcodes(@RequestBody String postCodes) {
        return Mono.empty();
    }
}
