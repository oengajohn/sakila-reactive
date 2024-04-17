package io.github.oengajohn.sakilareactive.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import io.github.oengajohn.sakilareactive.entity.Film;
import reactor.core.publisher.Flux;

public interface FilmRepository extends ReactiveCrudRepository<Film, Integer> {

    Flux<Film> findAllBy();

  

}
