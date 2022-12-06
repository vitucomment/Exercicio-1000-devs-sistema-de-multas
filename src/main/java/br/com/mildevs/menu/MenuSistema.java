package br.com.mildevs.menu;

public class MenuSistema {

	public void menuGeral() {
		System.out.println("=========================-MENU DO SISTEMA-=========================");
		System.out.println("Gerenciar Condutores \t [1]");
		System.out.println("Gerenciar Veiculos \t [1]");
		System.out.println("Gerenciar Multas \t [1]");
		System.out.println("-------------------------------------------------------------------");
	}
	
	public void menuCondutor() {
		System.out.println("=========================-MENU DO CONDUTOR-=========================");
		System.out.println("Consultar por CNH \t [1]");
		System.out.println("Consultar todos \t [2]");
		System.out.println("Cadastrar condutor \t [3]");
		System.out.println("Cadastrar veiculo \t [4]");
		System.out.println("Transferir viculo \t [5]");
		System.out.println("Remover condutor \t [6]");
		System.out.println("-------------------------------------------------------------------");
	}
	
	public void menuVeiculo() {
		System.out.println("=========================-MENU DO VEICULO-=========================");
		System.out.println("Consultar por placa \t [1]");
		System.out.println("Consultar todos \t [2]");
		System.out.println("Consultar multas \t [3]");
		System.out.println("Cadastrar veiculo \t [4]");
		System.out.println("Remover veiculo \t [5]");
		System.out.println("-------------------------------------------------------------------");
	}
	
	public void menuMulta() {
		System.out.println("=========================-MENU DE MULTAS-=========================");
		System.out.println("Consultar por código \t [1]");
		System.out.println("Consultar todos \t [2]");
		System.out.println("Cadastrar multa \t [4]");
		System.out.println("Remover multa \t\t [5]");
		System.out.println("-------------------------------------------------------------------");
	}
}
