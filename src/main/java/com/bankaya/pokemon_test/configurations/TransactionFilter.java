package com.bankaya.pokemon_test.configurations;


import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.xml.bind.DatatypeConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class TransactionFilter implements Filter {

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain
    ) throws ServletException, IOException {

        ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper((HttpServletResponse) response);
        ContentCachingRequestWrapper req = new ContentCachingRequestWrapper((HttpServletRequest) request);

        //HttpServletRequest req = (HttpServletRequest) request;

        long start = System.nanoTime();

        //responseWrapper.copyBodyToResponse();
        chain.doFilter(req, responseWrapper);
        //responseWrapper.copyBodyToResponse();

        byte[] responseBody = responseWrapper.getContentAsByteArray();
        String res = new String(responseBody, StandardCharsets.UTF_8);

        long end = System.nanoTime();

        long diff = end - start;
        double seconds = (double) diff / 1_000_000_000.0;
        System.out.printf(
                "source IP: %s, Instant: %s, method: %s, Req: %s, Res: %s, executionTime: %s s\n",
                req.getRemoteAddr(), new Date(), req.getMethod(), req.getRequestURI(), res, seconds);
    }

}
