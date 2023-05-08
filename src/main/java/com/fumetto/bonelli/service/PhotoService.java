package com.fumetto.bonelli.service;


import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.fumetto.bonelli.model.Photo;
import com.fumetto.bonelli.repository.IFumettiRepository;

@Service("mainService")
public class PhotoService implements IPhotoService{
	
	@Autowired
	private IFumettiRepository fumettoRepository;
	
	
	public PhotoService() {
	}
	
	@Override
	public Page<Photo> getAll(int page){
		Pageable pageable = PageRequest.of(page, 10);
		return fumettoRepository.findAll(pageable);
	}
	
	@Override
	public Iterable<Photo> getAll(){
		return fumettoRepository.findAll();
	}

	@Override
	public Optional<Photo> getByNumero(int numero) {
		
		/*Optional<Photo> fumetto= list.stream()
				.filter(item->item.getNumero()==numero)
				.findFirst();
		*/
		return fumettoRepository.getByNumero(numero);
	}
	
	@Override
	public Photo create(Photo photo) {
		
		return fumettoRepository.save(photo);
		
	}
	
	@Override
	public Optional<Photo> update(int numero,  Photo foto) {
		
		/* Optional<Photo> foundFumetto= list.stream()
				.filter(item->item.getNumero()==numero)
				.findFirst();
		*/
		Optional<Photo> foundFumetto=fumettoRepository.getByNumero(numero);
		if(foundFumetto.isEmpty())
			return Optional.empty();
		
		foundFumetto.get().setTitolo(foto.getTitolo());
		foundFumetto.get().setUrl(foto.getUrl());
		foundFumetto.get().setNumero(numero);
		fumettoRepository.save(foundFumetto.get());
		return foundFumetto;
	}
	
	@Override
	public Boolean delete(int numero) {
		
		Optional<Photo> foundFumetto=fumettoRepository.getByNumero(numero);
		if(foundFumetto.isEmpty())
			return false;
		fumettoRepository.delete(foundFumetto.get());
		return true;
	}

}
