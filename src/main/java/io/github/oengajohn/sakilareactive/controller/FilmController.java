package io.github.oengajohn.sakilareactive.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import io.github.oengajohn.sakilareactive.entity.Film;
import io.github.oengajohn.sakilareactive.service.FilmService;
import reactor.core.publisher.Flux;



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
    
  
}
