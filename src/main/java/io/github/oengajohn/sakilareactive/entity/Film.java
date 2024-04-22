package io.github.oengajohn.sakilareactive.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(value = "film")
public class Film {
    @Id
    @Column(value = "film_id")
    private Integer filmId;

    @Column(value = "title")
    private String title;

    @Column(value = "description")
    private String description;

    @Column(value = "release_year")
    private Integer releaseYear;

    @Column(value = "language_id")
    private Integer languageId;

    @Column(value = "original_language_id")
    private Integer originalLanguageId;

    @Column(value = "rental_duration")
    private Double rentalDuration;

    @Column(value = "rental_rate")
    private Double rentalRate;
    
    @Column(value = "replacement_cost")
    private Double replacementCost;

    @Column(value = "rating")
    private String rating;

    @Column(value = "special_features")
    private String specialFeatures;

    @Column(value = "last_update")
    private LocalDateTime lastUpdate;

    @Transient
    private String  languageName;



}
