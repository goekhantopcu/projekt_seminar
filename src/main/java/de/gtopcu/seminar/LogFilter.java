package de.gtopcu.seminar;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class LogFilter implements Filter {
    private static final AtomicLong REQUEST_COUNT = new AtomicLong();
    private static final Logger LOG = LogManager.getLogger(LogFilter.class);

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain
    ) throws IOException, ServletException {
        final long start = System.currentTimeMillis();
        try {
            chain.doFilter(request, response);
        } finally {
            final HttpServletRequest servletRequest = (HttpServletRequest) request;
            LOG.info(
                    "#{} {} {} {} with {} in {} ms",
                    REQUEST_COUNT.getAndIncrement(),
                    servletRequest.getMethod(),
                    servletRequest.getRequestURI(),
                    servletRequest.getQueryString(),
                    ((HttpServletResponse) response).getStatus(),
                    System.currentTimeMillis() - start);
        }
    }
}
