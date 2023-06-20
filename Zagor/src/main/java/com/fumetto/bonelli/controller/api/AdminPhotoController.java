package com.fumetto.bonelli.controller.api;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.fumetto.bonelli.model.Photo;
import com.fumetto.bonelli.service.IPhotoService;


@RestController
@Qualifier("mainService")
public class AdminPhotoController {
	
	@Autowired
	private IPhotoService photoService;
	
	public AdminPhotoController() {
		//photoService = new PhotoService();
	}
	
	@GetMapping("/admin/api/fumetti")
	public Iterable<Photo> getAll(){
		return photoService.getAll();
	}
	
	@GetMapping("/admin/api/fumetti/{id}")
	public Photo getById(@PathVariable int id) {
		
		Optional<Photo> fumetto=photoService.getById(id);
		
		if(fumetto.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND , "Fumetto non trovato");
		}
		return fumetto.get();
	}
	
	@PostMapping(value="/admin/api/fumetti")
	public Photo create(@RequestBody Photo photo) {
		
		return photoService.create(photo);
		
	}
	@PutMapping(value="/admin/api/fumetti/{id}")
	public Photo update(@PathVariable int id, @RequestBody Photo foto) {
		
		Optional<Photo> foundFumetto= photoService.update(id, foto);
		if(foundFumetto.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND , "Fumetto da modificare non trovato");
		}
		return foundFumetto.get();
	}
	@DeleteMapping(value="/admin/api/fumetti/{id}")
	public void delete(@PathVariable int id) {
		
		boolean foundFumetto= photoService.delete(id);
		if(foundFumetto==false) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND , "Fumetto da cancellare non trovato");
		}
		
	}
}
