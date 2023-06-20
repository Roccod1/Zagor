package com.fumetto.bonelli.controller.api;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fumetto.bonelli.model.Photo;
import com.fumetto.bonelli.service.IPhotoService;

@RestController
@Qualifier("mainService")
public class PhotoController {
	
	@Autowired
	private IPhotoService photoService;
	
	public PhotoController() {
		//photoService = new PhotoService();
	}

	@GetMapping("/api/fumetti")
	public Iterable<Photo> getAll(){
		return photoService.getAll();
	}
	
	@GetMapping("/api/fumetti/{id}")
	public Photo getById(@PathVariable int id) {
		
		Optional<Photo> fumetto=photoService.getById(id);
		
		if(fumetto.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND , "Fumetto non trovato");
		}
		return fumetto.get();
	}
}
