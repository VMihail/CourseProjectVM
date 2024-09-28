package com.example.courseprojectvm.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
