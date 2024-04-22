package io.github.oengajohn.sakilareactive.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import io.github.oengajohn.sakilareactive.entity.Film;
import io.github.oengajohn.sakilareactive.model.FilmDto;
import reactor.core.publisher.Flux;

public interface FilmRepository extends ReactiveCrudRepository<Film, Integer> {

   Flux<Film> findAllBy(Pageable pageable);

   @Query("SELECT f.*, l.name  FROM film f join language l ON f.language_id=l.language_id ORDER BY f.film_id LIMIT :limit OFFSET :offSet")
   Flux<FilmDto> findAllBy(Integer limit, Long offSet);

}
