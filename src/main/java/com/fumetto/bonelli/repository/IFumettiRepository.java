package com.fumetto.bonelli.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fumetto.bonelli.model.Photo;

@Repository
public interface IFumettiRepository extends JpaRepository<Photo, Integer>{
	Optional<Photo> getByNumero(Integer numero);

}
