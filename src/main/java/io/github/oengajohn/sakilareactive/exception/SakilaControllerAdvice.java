package io.github.oengajohn.sakilareactive.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import reactor.core.publisher.Mono;

@RestControllerAdvice
public class SakilaControllerAdvice {

    @ExceptionHandler(ActorNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Mono<Map<String, Object>> handleActorNotFoundException(ActorNotFoundException ex) {
        Map<String, Object> map = new HashMap<>();
        map.put("success", false);
        map.put("msg", ex.getLocalizedMessage());
        return Mono.just(map);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Mono<Map<String, Object>> handleException(Exception ex) {
        Map<String, Object> map = new HashMap<>();
        map.put("success", false);
        map.put("msg", ex.getLocalizedMessage());
        return Mono.just(map);
    }

}
