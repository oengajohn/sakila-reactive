package io.github.oengajohn.sakilareactive.service.impl;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import io.github.oengajohn.sakilareactive.entity.Film;
import io.github.oengajohn.sakilareactive.repository.FilmRepository;
import io.github.oengajohn.sakilareactive.repository.LanguageRepository;
import io.github.oengajohn.sakilareactive.service.FilmService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class FilmServiceImpl implements FilmService{
    private final FilmRepository filmRepository;
    private final LanguageRepository languageRepository;

    public FilmServiceImpl(FilmRepository filmRepository,LanguageRepository languageRepository){
        this.filmRepository=filmRepository;
        this.languageRepository=languageRepository;
    }

    @Override
    public Flux<Film> listAll() {
        
        return filmRepository.findAll();
    }

    @Override
    public Mono<Page<Film>> getFilms(PageRequest pageRequest) {
      return  filmRepository.findAllBy(pageRequest.withSort(Sort.by("filmId").ascending()))
        .collectList()
        .zipWith(filmRepository.count())
        .map(t -> new PageImpl<>(t.getT1(),pageRequest,t.getT2()));
    }
    
    
}
