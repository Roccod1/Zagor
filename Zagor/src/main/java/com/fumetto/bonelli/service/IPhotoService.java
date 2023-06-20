package com.fumetto.bonelli.service;

import java.util.Optional;

import com.fumetto.bonelli.model.Photo;

public interface IPhotoService {
	
	Iterable<Photo> getAll();
	public Optional<Photo> getById(int id);
	public Photo create(Photo photo);
	public Optional<Photo> update(int id,  Photo foto);
	public Boolean delete(int id);
}
