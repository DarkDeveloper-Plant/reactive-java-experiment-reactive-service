package org.example.customjavareactapp.contoller;

import lombok.RequiredArgsConstructor;
import org.example.customjavareactapp.modal.Data;
import org.example.customjavareactapp.modal.DataDto;
import org.example.customjavareactapp.service.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class GetController {

    private final CustomService customService;

    @GetMapping(value = "/data")
    public Mono<Data> getData(){
        return customService.getData();
    }

    @PostMapping(value = "/data")
    public Mono<Data> postData(@RequestBody DataDto dataDto){
        return customService.postData(dataDto);
    }
}
