package com.fumetto.bonelli.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.fumetto.bonelli.model.Photo;

public interface IPhotoService {
	
	Page<Photo> getAll(int page);
	Iterable<Photo> getAll();
	public Optional<Photo> getByNumero(int numero);
	public Photo create(Photo photo);
	public Optional<Photo> update(int numero,  Photo foto);
	public Boolean delete(int numero);
	List<Photo> getByTitolo(String titolo);
}
