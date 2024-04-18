package io.github.oengajohn.sakilareactive.exception;

import java.util.List;
import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;

import reactor.core.publisher.Mono;

@RestControllerAdvice
public class SakilaControllerAdvice {

    @ExceptionHandler(ActorNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Mono<ErrorDetails> handleActorNotFoundException(ActorNotFoundException ex) {
        return Mono.just(
                ErrorDetails.builder()
                        .msg(List.of(ex.getLocalizedMessage()))
                        .code(HttpStatus.NOT_FOUND)
                        .build());
    }

    @ExceptionHandler(WebExchangeBindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Mono<ErrorDetails> handleActorNotFoundException(WebExchangeBindException ex) {
        List<String> msg = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .filter(Objects::nonNull)
                .map(m -> m.getField() + " " + m.getDefaultMessage())
                .toList();
        return Mono.just(
                ErrorDetails.builder()
                        .msg(msg)
                        .code(HttpStatus.BAD_REQUEST)
                        .build());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Mono<ErrorDetails> handleException(Exception ex) {

        return Mono.just(
                ErrorDetails.builder()
                        .msg(List.of(ex.getLocalizedMessage()))
                        .code(HttpStatus.INTERNAL_SERVER_ERROR)
                        .build());
    }

}
