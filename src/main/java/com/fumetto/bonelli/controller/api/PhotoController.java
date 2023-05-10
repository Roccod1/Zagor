package com.fumetto.bonelli.controller.api;


import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.FileSystemResource;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpHeaders;
import com.fumetto.bonelli.model.Photo;
import com.fumetto.bonelli.service.IPhotoService;
import com.fumetto.bonelli.util.PagedResponse;


@RestController
@Qualifier("mainService")
public class PhotoController {
	
	@Autowired
	private IPhotoService photoService;
	
	public PhotoController() {
	}

	
	@GetMapping("/api/fumetti")
	public PagedResponse<Photo> getAll(@RequestParam(value = "page", defaultValue = "0") int page) {
	    Page<Photo> photoPage = photoService.getAll(page);
	    int totalPages = photoPage.getTotalPages();
	    int totalElements = (int) photoPage.getTotalElements();
	    int perPage = photoPage.getSize();

	    PagedResponse<Photo> pagedResponse = new PagedResponse<>(photoPage.getContent(), totalElements, perPage, page, totalPages);
	    return pagedResponse;
	}
	
	@GetMapping("/api/fumetti/{numero}")
	public Photo getById(@PathVariable int numero) {
		
		Optional<Photo> fumetto=photoService.getByNumero(numero);
		
		if(fumetto.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND , "Fumetto non trovato");
		}
		return fumetto.get();
	}
	
	@GetMapping("/api/fumetti/bytitolo/{titolo}")
    public ResponseEntity<List<Photo>> getByTitolo(@PathVariable String titolo) {
        List<Photo> foundPhotos = photoService.getByTitolo(titolo);
        return new ResponseEntity<>(foundPhotos, HttpStatus.OK);
    }
	
	@GetMapping("/api/fumetti/download/{fileName:.+}")
    public ResponseEntity<FileSystemResource> download(@PathVariable String fileName) {
        Path path = Paths.get("c:/bonelliZagor", fileName+".cbr");
        FileSystemResource resource = new FileSystemResource(path);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}
