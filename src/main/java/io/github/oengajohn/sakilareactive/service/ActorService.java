package io.github.oengajohn.sakilareactive.service;

import io.github.oengajohn.sakilareactive.entity.Actor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ActorService {

    Flux<Actor> listAll();

    Mono<Actor> findActorById(Integer actorId);
    
}
