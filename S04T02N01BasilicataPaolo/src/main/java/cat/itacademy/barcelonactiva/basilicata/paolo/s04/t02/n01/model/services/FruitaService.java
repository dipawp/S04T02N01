package cat.itacademy.barcelonactiva.basilicata.paolo.s04.t02.n01.model.services;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import cat.itacademy.barcelonactiva.basilicata.paolo.s04.t02.n01.model.domain.Fruita;
import cat.itacademy.barcelonactiva.basilicata.paolo.s04.t02.n01.model.repository.FruitaRepository;

@Repository
public class FruitaService {
	
	@Autowired
	FruitaRepository fruitaRepository;
	
	
	public void addFruita(Fruita fruita) {
			if(Objects.nonNull(fruita.getNom()) && !"".equalsIgnoreCase(fruita.getNom())) {
				fruitaRepository.save(fruita);
			}
	}
	
	public void updateFruita(Fruita fruita) {
		fruitaRepository.save(fruita);
	}
	
	public void deleteFruita(long id) {
		fruitaRepository.deleteById(id);
		
	}
	
	
	public List<Fruita> getFruitaList() {
		// TODO Auto-generated method stub
		return (List<Fruita>) fruitaRepository.findAll();
	}
	
	public Optional<Fruita> getFruitaById(long id) {
		Optional<Fruita> fruita = fruitaRepository.findById(id);
		return fruita;
	}
	
	

}
