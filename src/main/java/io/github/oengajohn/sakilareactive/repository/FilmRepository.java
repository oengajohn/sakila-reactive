package io.github.oengajohn.sakilareactive.repository;

import org.springframework.data.repository.reactive.ReactiveSortingRepository;

import io.github.oengajohn.sakilareactive.entity.Film;
import reactor.core.publisher.Flux;

public interface FilmRepository extends ReactiveSortingRepository<Film, Integer> {

    Flux<Film> findAllBy();

  

}
