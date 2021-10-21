package de.gtopcu.seminar.database;

import de.gtopcu.seminar.user.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@RequiredArgsConstructor(onConstructor__ = @Autowired)
public class DataBaseHelper {
    private final DatabaseClient client;
    private final String[] creates = {User.CREATE_QUERY};

    public Mono<Void> createSchemata() {
        this.client.sql(User.CREATE_QUERY)
                .fetch()
                .rowsUpdated()
                .subscribe(rowsUpdated -> log.debug("{} rows updated", rowsUpdated));
        return Mono.empty();
    }
}
