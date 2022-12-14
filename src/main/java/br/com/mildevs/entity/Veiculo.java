package br.com.mildevs.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Veiculo {

	@Id
	@Column(name = "placa")
	private String placa;
	
	@Column(nullable = false)
	private int ano;
	
	@Column(nullable = false)
	private String modelo;

	@Column(nullable = false)
	private String marca;

	@OneToOne(optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "nro_cnh_fk", referencedColumnName = "nro_cnh")
	private Condutor condutor;

	@OneToMany(mappedBy = "veiculo")
	private List<Multa> multas;

	@Override
	public String toString() {
		return "[ PLACA: " + getPlaca()
				+ " ANO: " + getAno()
				+ " MODELO: " + getModelo()
				+ " MARCA: " + getMarca() 
				+ " CONDUTOR: " + this.condutor.getNroCnh() + " ]\n";
		
	}
	
}
