package io.github.oengajohn.sakilareactive.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import io.github.oengajohn.sakilareactive.entity.Actor;

public interface ActorRepository extends ReactiveCrudRepository<Actor,Integer>{
    
}
