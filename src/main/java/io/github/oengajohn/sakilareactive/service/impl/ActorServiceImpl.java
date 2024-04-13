package io.github.oengajohn.sakilareactive.service.impl;

import org.springframework.stereotype.Service;

import io.github.oengajohn.sakilareactive.entity.Actor;
import io.github.oengajohn.sakilareactive.repository.ActorRepository;
import io.github.oengajohn.sakilareactive.service.ActorService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ActorServiceImpl implements ActorService {

    private final ActorRepository actorRepository;

    public ActorServiceImpl(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public Flux<Actor> listAll() {

        return actorRepository.findAll();
    }

    @Override
    public Mono<Actor> findActorById(Integer actorId) {
        return  actorRepository.findById(actorId);
    }

}
