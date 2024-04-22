package io.github.oengajohn.sakilareactive.service.impl;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import io.github.oengajohn.sakilareactive.entity.Film;
import io.github.oengajohn.sakilareactive.entity.Language;
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
        .zipWith(languageRepository.findAll().collectList())
        .flatMap(t -> {
            List<Film> filmList = t.getT1().getT1();
            long totalCount = t.getT1().getT2();
            List<Language> languages = t.getT2();
            for (Film film  : filmList) {
                for (Language language : languages) {
                    if(film.getLanguageId().equals(language.getLanguageId())){
                        film.setLanguageName(language.getName());
                        break;
                    }
                }
            }
            Page<Film> page = new PageImpl<>(filmList,pageRequest,totalCount);
            return Mono.just(page);
        });
    }

    
}
