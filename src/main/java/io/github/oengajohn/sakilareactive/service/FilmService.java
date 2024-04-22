package io.github.oengajohn.sakilareactive.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import io.github.oengajohn.sakilareactive.entity.Film;
import io.github.oengajohn.sakilareactive.model.FilmDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FilmService {

    Flux<Film> listAll();

    Mono<Page<Film>> getFilms(PageRequest pageRequest);

    Mono<Page<FilmDto>> getFilmsDtos(PageRequest pageRequest);


}
