package org.example.customjavareactapp;


import lombok.RequiredArgsConstructor;
import org.example.customjavareactapp.modal.Data;
import org.example.customjavareactapp.repository.DataRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
@RequiredArgsConstructor
public class Application {

    private final DataRepo dataRepo;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @PostConstruct
    void saveOneData() {
        var data = Data.builder()
                .data("some Data")
                .requestCameTime(0L)
                .build();
        dataRepo.save(data).block();
    }
}

