package br.com.mildevs.dao;

import java.util.List;

import br.com.mildevs.entity.Multa;
import br.com.mildevs.entity.Veiculo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class VeiculoDao {

	private EntityManager manager;

	public VeiculoDao() {
		this.manager = Persistence.createEntityManagerFactory("sistema").createEntityManager();
	}

	// CRIAR
	public boolean create(Veiculo veiculo) {
		manager.getTransaction().begin();
		manager.persist(veiculo);
		manager.getTransaction().commit();
		return true;
	}

	public boolean adicionaMulta(String placa, Multa multa) {
		Veiculo veiculo = this.manager.find(Veiculo.class, placa);
		if (veiculo == null)
			return false;

		List<Multa> multas = veiculo.getMultas();
		multas.add(multa);
		veiculo.setMultas(multas);

		manager.getTransaction().begin();
		manager.persist(veiculo);
		manager.getTransaction().commit();
		return true;

	}

	// CONSULTA UNICA
	public Veiculo read(String placa) {
		return manager.find(Veiculo.class, placa);
	}

	// CONSULTA GERAL
	public List<Veiculo> readAll() {
		Query query = manager.createQuery("select v from Veiculo as v");
		return query.getResultList();
	}

	// REMOVER
	public boolean delete(String placa) {
		Veiculo veiculoASerRemovido = manager.find(Veiculo.class, placa);

		if (veiculoASerRemovido == null)
			return false;

		this.manager.getTransaction().begin();
		this.manager.remove(veiculoASerRemovido);
		this.manager.getTransaction().commit();
		return true;
	}

}
