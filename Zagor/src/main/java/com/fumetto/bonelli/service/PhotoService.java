package com.fumetto.bonelli.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.fumetto.bonelli.model.Photo;

@Service("mainService")
public class PhotoService implements IPhotoService{
	
	private List<Photo> list;
	private static int lastId;
	
	public PhotoService() {
		list=new ArrayList<>();
		list.add(new Photo(1, "./img/1.jpg", "Zagor"));
		list.add(new Photo(2, "./img/2.jpg", "Terrore"));
		list.add(new Photo(3, "./img/3.jpg", "L'oro del fiume"));
		
		lastId=3;
	}
	
	@Override
	public Iterable<Photo> getAll(){
		return list;
	}

	@Override
	public Optional<Photo> getById(int id) {
		
		Optional<Photo> fumetto= list.stream()
				.filter(item->item.getId()==id)
				.findFirst();
		
		return fumetto;
	}
	
	@Override
	public Photo create(Photo photo) {
		lastId++;
		photo.setId(lastId);
		list.add(photo);
		return photo;
		
	}
	
	@Override
	public Optional<Photo> update(int id,  Photo foto) {
		
		Optional<Photo> foundFumetto= list.stream()
				.filter(item->item.getId()==id)
				.findFirst();
		if(foundFumetto.isEmpty())
			return Optional.empty();
		
		foundFumetto.get().setTitolo(foto.getTitolo());
		foundFumetto.get().setUrl(foto.getUrl());
		return foundFumetto;
	}
	
	@Override
	public Boolean delete(int id) {
		
		Optional<Photo> foundFumetto= list.stream()
				.filter(item->item.getId()==id)
				.findFirst();
		if(foundFumetto.isEmpty())
			return false;
		list.remove(foundFumetto.get());
		return true;
	}
}
