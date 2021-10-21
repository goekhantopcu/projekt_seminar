package de.gtopcu.seminar.configuration;

import io.r2dbc.spi.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.r2dbc.ConnectionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.r2dbc.core.DatabaseClient;

@Configuration
public class DatabaseConfiguration {
    @Value("${spring.r2dbc.url}")
    private String url;

    @Bean
    @Scope("singleton")
    public DatabaseClient createClient() {
        final ConnectionFactory connectionFactory = ConnectionFactoryBuilder.withUrl(this.url).build();
        return DatabaseClient.builder().connectionFactory(connectionFactory).build();
    }
}
