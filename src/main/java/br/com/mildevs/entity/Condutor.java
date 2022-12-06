package br.com.mildevs.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
	
	@OneToMany(mappedBy = "condutor", cascade = CascadeType.ALL)
	private List<Veiculo> veiculo;
	
	
}
