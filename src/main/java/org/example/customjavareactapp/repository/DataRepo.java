package org.example.customjavareactapp.repository;

import org.example.customjavareactapp.modal.Data;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface DataRepo extends ReactiveCrudRepository<Data, UUID> {

    Mono<Data> findFirstByOrderByRequestCameTimeAsc();
}
