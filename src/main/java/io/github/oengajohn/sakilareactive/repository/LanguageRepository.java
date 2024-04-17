package io.github.oengajohn.sakilareactive.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import io.github.oengajohn.sakilareactive.entity.Language;

public interface LanguageRepository extends ReactiveCrudRepository<Language,Integer> {
    
}
