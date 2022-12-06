package br.com.mildevs.menu;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import br.com.mildevs.entity.Condutor;
import br.com.mildevs.entity.Multa;
import br.com.mildevs.entity.Veiculo;

public class MenuDeCadastro {

	public static Scanner input() {
		Scanner input = new Scanner(System.in);
		return input;
	}

	public Condutor cadastrarCondutor() {
		Condutor condutor = new Condutor();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("CADASTRO DE CONDUTOR");

		System.out.print("Numero da CNH: ");
		String nroCnh = input().nextLine();
		condutor.setNroCnh(nroCnh);

		System.out.print("Data de emissão (dd/mm/yyyy): ");
		String dataString = input().nextLine();
		condutor.setDataEmissao(LocalDate.parse(dataString, formatter));

		System.out.print("Orgao emissor: ");
		String orgaoEmissor = input().nextLine();
		condutor.setOrgaoEmissor(orgaoEmissor);

		System.out.print("Pontuação atual: ");
		Integer pontuacao = input().nextInt();
		condutor.setPontuação(pontuacao);

		return condutor;
	}

	public Veiculo cadastrarVeiculo(Condutor condutor) {
		Veiculo veiculo = new Veiculo();
		veiculo.setCondutor(condutor);
		
		System.out.println("CADASTRO DE VEICULO");
		
		System.out.print("Placa do veiculo: ");
		String placa = input().nextLine();
		veiculo.setPlaca(placa);
		
		System.out.print("Ano: ");
		Integer ano = input().nextInt();
		veiculo.setAno(ano);
		
		System.out.print("Modelo: ");
		String modelo = input().nextLine();
		veiculo.setModelo(modelo);
		
		System.out.print("Marca: ");
		String marca = input().nextLine();
		veiculo.setMarca(marca);
		
		return veiculo;
		
	}
	
	public Multa cadastrarMulta(Veiculo veiculo) {
		Multa multa = new Multa();
		multa.setVeiculo(veiculo);
		
		System.out.println("CADASTRO DE MULTA");
		
		System.out.print("Codigo: ");
		String codigo = input().nextLine();
		multa.setCodigoMulta(codigo);
		
		System.out.print("Valor: ");
		Double valor = input().nextDouble();
		multa.setValor(valor);
		
		System.out.print("Pontos: ");
		Integer pontos = input().nextInt();
		multa.setPontuacao(pontos);
		
		return multa;
		
	}
	
}
