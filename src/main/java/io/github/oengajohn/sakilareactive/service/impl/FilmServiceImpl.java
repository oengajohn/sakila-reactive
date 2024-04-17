package io.github.oengajohn.sakilareactive.service.impl;


import org.springframework.stereotype.Service;

import io.github.oengajohn.sakilareactive.entity.Film;
import io.github.oengajohn.sakilareactive.repository.FilmRepository;
import io.github.oengajohn.sakilareactive.repository.LanguageRepository;
import io.github.oengajohn.sakilareactive.service.FilmService;
import reactor.core.publisher.Flux;


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
        
        return filmRepository.findAllBy();
    }
    
    
}
