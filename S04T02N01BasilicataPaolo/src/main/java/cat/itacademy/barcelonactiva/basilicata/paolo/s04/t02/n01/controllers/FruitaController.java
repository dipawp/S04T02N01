package cat.itacademy.barcelonactiva.basilicata.paolo.s04.t02.n01.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cat.itacademy.barcelonactiva.basilicata.paolo.s04.t02.n01.model.domain.Fruita;
import cat.itacademy.barcelonactiva.basilicata.paolo.s04.t02.n01.model.services.FruitaService;


@RestController
@RequestMapping("/fruita")
public class FruitaController {
	
	
	
	@Autowired
	private FruitaService fruitaService;
	
	
	@PostMapping("/add")
	public ResponseEntity<Fruita> addFruita(@RequestBody Fruita fruita){
		try {
			
			fruitaService.addFruita(fruita);
			return new ResponseEntity<>(fruita, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<Fruita> updateFruita(@RequestBody Fruita fruita){
		Optional<Fruita> fruitaData = fruitaService.getFruitaById(fruita.getId());
		if(fruitaData.isPresent()) {
			Fruita _fruita = fruitaData.get();
			_fruita.setNom(fruita.getNom());
			_fruita.setQuantitatQuilos(fruita.getQuantitatQuilos());
			fruitaService.addFruita(_fruita);
			return new ResponseEntity<>(_fruita,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> deleteFruita(@PathVariable("id") long id){
		try {
			fruitaService.deleteFruita(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/getOne/{id}")
	public ResponseEntity<Fruita> getFruitaById(@PathVariable("id") long id){
		Optional<Fruita> fruitaData = fruitaService.getFruitaById(id);
		if(fruitaData.isPresent()) {
			return new ResponseEntity<>(fruitaData.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Fruita>> getAllFruites(){
		List<Fruita> fruites = fruitaService.getFruitaList();
		return new ResponseEntity<>(fruites, HttpStatus.OK);
		
	}
	

}
