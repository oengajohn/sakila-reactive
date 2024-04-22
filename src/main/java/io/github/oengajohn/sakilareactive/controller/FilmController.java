package io.github.oengajohn.sakilareactive.controller;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import io.github.oengajohn.sakilareactive.entity.Film;
import io.github.oengajohn.sakilareactive.model.FilmDto;
import io.github.oengajohn.sakilareactive.service.FilmService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



@RestController
@RequestMapping("/api/v1/films")
public class FilmController {
    private final FilmService filmService;

    public FilmController(FilmService filmService){
        this.filmService=filmService;
    }


    @GetMapping
    Flux<Film> list(){
        return filmService.listAll();
    }
    
    @GetMapping("/all")
    Mono<Page<Film>> getFilms(@RequestParam(value = "pageNumber",defaultValue="0") Integer pageNumber,@RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize ){
        return filmService.getFilms(PageRequest.of(pageNumber,pageSize));
    }
    @GetMapping("/all/minified")
    Mono<Page<FilmDto>> getFilmsDtos(@RequestParam(value = "pageNumber",defaultValue="0") Integer pageNumber,@RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize ){
        return filmService.getFilmsDtos(PageRequest.of(pageNumber,pageSize));
    }
  
}
