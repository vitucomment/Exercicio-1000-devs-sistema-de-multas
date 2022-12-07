package br.com.mildevs.entity;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Condutor {

	
	@Id
	@Column(name = "nro_cnh")
	private String nroCnh;
	
	@Column(nullable = false, name = "data_emissao")
	private LocalDate dataEmissao;
	
	@Column(nullable = false, name = "orgao_emissor")
	private String orgaoEmissor;
	
	@Column(nullable = false)
	private Integer pontuação = 20;
	
	@OneToOne(mappedBy = "condutor", cascade = CascadeType.ALL)
	private Veiculo veiculo;
	
	@Override
	public String toString() {
		return "[ CNH: " + getNroCnh()
				+ "\nData de emissao: " + getDataEmissao()
				+ "\nOrgao emissor: " + getOrgaoEmissor()
				+ "\nPontuação atual: " + getPontuação() + " ]\n"; 
		
	}
	
}
