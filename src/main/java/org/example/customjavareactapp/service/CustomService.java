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
        return dataRepo.findAll().elementAt(0).delayElement(Duration.ofSeconds(1));
    }

    public Mono<Data> postData(DataDto dataDto) {
        var data = Data.builder()
                .data(dataDto.data())
                .requestCameTime(System.currentTimeMillis())
                .build();
        return dataRepo.save(data).delayElement(Duration.ofMillis(100));
    }

//    @PostConstruct
//    void saveFirstData(){
//        var data = Data.builder()
//                .id(UUID.fromString("cd01675c-77da-4cfd-af32-36dbb7873782"))
//                .data("data")
//                .requestCameTime(System.currentTimeMillis())
//                .build();
//        dataRepo.save(data);
//    }
}
