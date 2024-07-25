package com.bankaya.pokemon_test.configurations;


import com.bankaya.pokemon_test.models.LogAdapter;
import com.bankaya.pokemon_test.services.ILogService;
import com.bankaya.pokemon_test.services.LogServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Instant;

@Component
public class TransactionFilter implements Filter {

    private final ILogService logService;

    @Autowired
    public TransactionFilter(final LogServiceImpl logService) {
        this.logService = logService;
    }

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain
    ) throws ServletException, IOException {

        ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper((HttpServletResponse) response);
        ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper((HttpServletRequest) request);

        long start = System.nanoTime();

        chain.doFilter(requestWrapper, responseWrapper);

        long end = System.nanoTime();

        LogAdapter log = this.getLogAdapter(responseWrapper, requestWrapper, end, start);

        new Thread(() -> {
            this.logService.saveLog(log);
        }).start();

        responseWrapper.copyBodyToResponse();
    }

    private LogAdapter getLogAdapter(ContentCachingResponseWrapper responseWrapper, ContentCachingRequestWrapper requestWrapper, long end, long start) {
        byte[] responseByte = responseWrapper.getContentAsByteArray();

        String responseBody = new String(responseByte, StandardCharsets.UTF_8);

        long diff = end - start;
        double seconds = ((double) diff / 1_000_000_000.0);

        return LogAdapter.builder()
                .sourceIP(requestWrapper.getRemoteAddr())
                .date(Instant.now())
                .method(requestWrapper.getMethod())
                .urlRequest(requestWrapper.getServletPath())
                .response(responseBody)
                .executionTime(String.format("%s s", Math.round((seconds * 100) / 100)))
                .statusCode(responseWrapper.getStatus())
                .build();
    }

}
