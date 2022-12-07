package br.com.mildevs.menu;

public class MenuSistema {

	public void menuGeral() {
		System.out.println("=========================-MENU DO SISTEMA-=========================");
		System.out.println("Gerenciar Condutores \t [1]");
		System.out.println("Gerenciar Veiculos \t [2]");
		System.out.println("Gerenciar Multas \t [3]");
		System.out.println("Sair \t\t\t [4]");
		System.out.println("-------------------------------------------------------------------");
		System.out.print("Operação: ");
	}
	
	public void menuCondutor() {
		System.out.println("=========================-MENU DO CONDUTOR-=========================");
		System.out.println("Consultar por CNH \t [1]");
		System.out.println("Consultar todos \t [2]");
		System.out.println("Cadastrar condutor \t [3]");
		System.out.println("Transferir viculo \t [4]");
		System.out.println("Remover condutor \t [5]");
		System.out.println("-------------------------------------------------------------------");
		System.out.print("Operação: ");
	}
	
	public void consultarCnh() {
		System.out.print("Consultar por CNH: ");
	}
	
	public void removerCnh() {
		System.out.print("Remover condutor [informe a CNH]: ");
	}
	
	public void transferenciaOrigem() {
		System.out.print("CNH do condutor origem: ");
	}
	public void transferenciaDestino() {
		System.out.print("CNH do condutor destino: ");
	}
	public void transferenciaPlaca() {
		System.out.print("Placa do veiculo a ser transferido: ");
	}
	
	public void consultarTodosCondutores() {
		System.out.println("=========================-LISTA DE CONDUTORES-=========================");
	}
	
	public void menuVeiculo() {
		System.out.println("=========================-MENU DO VEICULO-=========================");
		System.out.println("Consultar por placa \t [1]");
		System.out.println("Consultar todos \t [2]");
		System.out.println("Consultar multas \t [3]");
		System.out.println("Cadastrar veiculo \t [4]");
		System.out.println("Remover veiculo \t [5]");
		System.out.println("-------------------------------------------------------------------");
		System.out.print("Operação: ");

	}
	
	public void cnhParaCadastroDeVeiculo() {
		System.out.print("CNH do condutor: ");
	}
	
	public void consultarMultasDeVeiculo() {
		System.out.print("Placa de veiculo para consulta: ");
	}
	
	public void removerVeiculo() {
		System.out.print("Placa do veiculo a ser removido: ");
	}
	
	public void consultarPlaca() {
		System.out.print("Consultar por placa: ");
	}
	
	public void consultarTodosVeiculos() {
		System.out.println("=========================-LISTA DE VEICULOS-=========================");
	}
	
	public void menuMulta() {
		System.out.println("=========================-MENU DE MULTAS-=========================");
		System.out.println("Consultar por código \t [1]");
		System.out.println("Consultar todos \t [2]");
		System.out.println("Cadastrar multa \t [3]");
		System.out.println("Remover multa \t\t [4]");
		System.out.println("-------------------------------------------------------------------");
		System.out.print("Operação: ");

	}
	
	public void consultarCodigo() {
		System.out.print("Consultar por código: ");
	}
	
	public void consultarTodasMultas() {
		System.out.println("=========================-LISTA DE MULTAS-=========================");
	}
	
	public void placaParaCadastroDeMulta() {
		System.out.print("Placa do veiculo: ");
	}
	
	public void removerMulta() {
		System.out.print("Código da multa a ser removida: ");
	}
}
