package org.example.customjavareactapp.service;

import lombok.RequiredArgsConstructor;
import org.example.customjavareactapp.modal.Data;
import org.example.customjavareactapp.modal.DataDto;
import org.example.customjavareactapp.repository.DataRepo;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.Duration;


@Service
@RequiredArgsConstructor
public class CustomService {

    private final DataRepo dataRepo;

    public Mono<Data> getData() {
        return dataRepo.findFirstByOrderByRequestCameTimeAsc()/*.delayElement(Duration.ofMillis(2000))*/;
    }

    public Mono<Data> postData(DataDto dataDto) {
        var data = Data.builder()
                .data(dataDto.data())
                .requestCameTime(System.currentTimeMillis())
                .build();
        return dataRepo.save(data).delayElement(Duration.ofSeconds(5));
    }

}
