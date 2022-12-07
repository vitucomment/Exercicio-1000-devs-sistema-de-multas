package br.com.mildevs.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Multa {

	@Id
	@Column(name = "cod_multa")
	private String codigoMulta;
	
	@Column(nullable = false)
	private Double valor;
	
	@Column(nullable = false)
	private int pontuacao;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "placa_fk", referencedColumnName = "placa")
	private Veiculo veiculo;
	
	@Override
	public String toString() {
		return "[ COD_MULTA: " + getCodigoMulta()
				+ "\nVALOR: " + getValor()
				+ "\nPONTOS: " + getPontuacao()
				+ "\nVEICULO: " + getVeiculo() + " ]\n"; 
	}
}
