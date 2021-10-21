package de.gtopcu.seminar.configuration;

import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class WebConfiguration {
    @Bean
    @Scope("singleton")
    public ServletRegistrationBean<WebServlet> h2ServletRegistration() {
        return new ServletRegistrationBean<>(new WebServlet(), "/console/*");
    }
}
