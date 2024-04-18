package io.github.oengajohn.sakilareactive.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.oengajohn.sakilareactive.entity.Actor;
import io.github.oengajohn.sakilareactive.service.ActorService;
import jakarta.validation.Valid;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/actors")
public class ActorController {

    private final ActorService actorService;

    public ActorController(ActorService actorService){
        this.actorService=actorService;
    }


    @GetMapping
    Flux<Actor> list(){
        return actorService.listAll();
    }
    

    @GetMapping("{actorId}")
    Mono<Actor> findActorById(@PathVariable(value = "actorId") Integer actorId){
        return actorService.findActorById(actorId);
    }

    @PostMapping
    public Mono<Actor> createActor(@RequestBody @Valid Actor actor) {
       
        
        return actorService.save(actor);
    }
    
}
