package cat.itacademy.barcelonactiva.basilicata.paolo.s04.t02.n01.model.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Fruita")
public class Fruita {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	@Column(name = "nom")
	private String nom;
	
	@Column
	private int quantitatQuilos;
	
	public Fruita() {
		
	}

	public Fruita(Long id, String nom, int quantitatQuilos) {
		super();
		this.id = id;
		this.nom = nom;
		this.quantitatQuilos = quantitatQuilos;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getQuantitatQuilos() {
		return quantitatQuilos;
	}

	public void setQuantitatQuilos(int quantitatQuilos) {
		this.quantitatQuilos = quantitatQuilos;
	}

	public Long getId() {
		return id;
	}

	
	
}
