package br.com.mildevs;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.mildevs.dao.CondutorDao;
import br.com.mildevs.dao.MultasDao;
import br.com.mildevs.dao.VeiculoDao;
import br.com.mildevs.entity.Condutor;
import br.com.mildevs.entity.Multa;
import br.com.mildevs.entity.Veiculo;
import br.com.mildevs.menu.MenuDeCadastro;
import br.com.mildevs.menu.MenuSistema;

public class Sistema {
	static MenuSistema menu = new MenuSistema();
	static MenuDeCadastro cadastro = new MenuDeCadastro();
	static CondutorDao condutorDao = new CondutorDao();
	static VeiculoDao veiculoDao = new VeiculoDao();
	static MultasDao multasDao = new MultasDao();

	public static void main(String[] args) {
		Logger.getLogger("org.hibernate").setLevel(Level.OFF);
		Scanner input = new Scanner(System.in);
		
		boolean flag = true;
		while (flag) {
			limpaConsole();
			menu.menuGeral();
			int op = input.nextInt();
			switch (op) {
			case 1:
				limpaConsole();
				menuCondutor();
				break;
			case 2:
				limpaConsole();
				menuVeiculo();
				break;
			case 3:
				limpaConsole();
				menuMultas();
				break;
			default:
				System.out.println("PROGRAMA FINALIZADO");
				flag = false;
				break;
			}
		}
		input.close();
	}

	public static void menuCondutor() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		boolean flag = true;
		while (flag) {
			condutorDao = new CondutorDao();
			menu.menuCondutor();
			int op = input.nextInt();
			input = new Scanner(System.in);
			switch (op) {
			case 1:
				menu.consultarCnh();
				String codCnh = input.nextLine();
				Condutor condutorConsulta = condutorDao.read(codCnh);
				if (condutorConsulta != null) {
					System.out.println(condutorConsulta);
				} else {
					System.out.println("Condutor não encontrado.");
				}
				
				break;
			case 2:
				menu.consultarTodosCondutores();
				condutorDao.readAll().forEach(System.out::println);
				break;
			case 3:
				Condutor condutor = cadastro.cadastrarCondutor();
				condutorDao.create(condutor);
				break;
			case 4:
				menu.transferenciaPlaca();
				String placa = input.nextLine();
				menu.transferenciaDestino();
				String cnhDestino = input.nextLine();
				condutorDao.transferirVeiculo(placa, cnhDestino);
				break;
			case 5:
				menu.removerCnh();
				String cnh = input.nextLine();
				condutorDao.delete(cnh);
				break;
			default:
				flag = false;
				break;
			}
		}
	}

	public static void menuVeiculo() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		boolean flag = true;
		while (flag) {
			veiculoDao = new VeiculoDao();
			menu.menuVeiculo();
			int op = input.nextInt();
			input = new Scanner(System.in);
			switch (op) {
			case 1:
				menu.consultarPlaca();
				String placa = input.nextLine();
				Veiculo veiculoConsulta = veiculoDao.read(placa);
				if(veiculoConsulta != null) {
					System.out.println(veiculoConsulta);
				} else {
					System.out.println("Veiculo não encontrado.");
				}
				break;
			case 2:
				menu.consultarTodosVeiculos();
				veiculoDao.readAll().forEach(System.out::println);
				break;
			case 3:
				menu.consultarMultasDeVeiculo();
				veiculoDao.readMultas(input.nextLine()).forEach(System.out::println);
				;
				break;
			case 4:
				menu.cnhParaCadastroDeVeiculo();
				Condutor condutor = condutorDao.read(input.nextLine());
				if (condutor != null) {
					Veiculo veiculo = cadastro.cadastrarVeiculo(condutor);
					veiculoDao.create(veiculo);
				} else {
					System.out.println("Condutor não encontrado. Cadastro cancelado!");
				}

				break;
			case 5:
				menu.removerVeiculo();
				String placaRemocao = input.nextLine();
				Veiculo veiculoRemocao = veiculoDao.read(placaRemocao);
				if(veiculoRemocao != null) {
					veiculoDao.delete(placaRemocao);
				} else {
					System.out.println("Veiculo não encontrado.");
				}
				
				break;
			default:
				flag = false;
				break;
			}
		}
	}

	public static void menuMultas() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		boolean flag = true;
		while (flag) {
			multasDao = new MultasDao();
			menu.menuMulta();
			int op = input.nextInt();
			input = new Scanner(System.in);
			switch (op) {
			case 1:
				menu.consultarCodigo();
				String codigo = input.nextLine();
				System.out.println(multasDao.read(codigo));
				break;
			case 2:
				menu.consultarTodasMultas();
				multasDao.readAll().forEach(System.out::println);
				break;
			case 3:
				menu.placaParaCadastroDeMulta();
				String placaMulta = input.nextLine();
				Veiculo veiculo = veiculoDao.read(placaMulta);
				if (veiculo != null) {
					Multa multa = cadastro.cadastrarMulta(veiculo);
					multasDao.create(multa);
					condutorDao.computarMulta(multa, placaMulta);
				} else {
					System.out.println("Veiculo inexistente. Cadastro cancelado!");
				}

				break;
			case 4:
				menu.removerMulta();
				String codigoRemocao = input.nextLine();
				Multa multaRemocao = multasDao.read(codigoRemocao);
				if(multaRemocao != null) {
					multasDao.delete(codigoRemocao);
				} else {
					System.out.println("A multa não existe. Operação cancelada!");
				}
				break;
			default:
				flag = false;
				break;
			}
		}
	}

	public static void limpaConsole() {
		try {
			if (System.getProperty("os.name").contains("Windows"))
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			else
				Runtime.getRuntime().exec("clear");
		} catch (IOException | InterruptedException ex) {
		}
	}
}
