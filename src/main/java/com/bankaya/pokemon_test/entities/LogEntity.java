package com.bankaya.pokemon_test.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "logs")
public class LogEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date", nullable = false)
    private Timestamp date;

    @Column(name = "source_ip", length = 100, nullable = false)
    private String sourceIP;

    @Column(name = "method", length = 10, nullable = false)
    private String method;

    @Column(name = "url_request", length = 150, nullable = false)
    private String urlRequest;

    @Column(name = "status_code", nullable = false)
    private Integer statusCode;

    @Column(name = "execution_time", length = 20, nullable = false)
    private String executionTime;

    @Column(name = "response", columnDefinition = "text")
    private String response;

}
