package io.github.oengajohn.sakilareactive.service;



import io.github.oengajohn.sakilareactive.entity.Film;
import reactor.core.publisher.Flux;


public interface FilmService {

    Flux<Film> listAll();


}
