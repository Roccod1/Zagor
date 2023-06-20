package com.fumetto.bonelli.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fumetto.bonelli.model.Photo;

public interface IFumettiRepository extends JpaRepository<Photo, Integer>{

}
