package com.example.courseprojectvm.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "cat_citizens")
public class CatCitizen {
    /**
     * Уникальный идентификатор гражданина.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Имя гражданина.
     */
    private String name;

    /**
     * Фотография гражданина.
     */
    private String imageUrl;
}
