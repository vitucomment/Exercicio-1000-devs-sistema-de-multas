package br.com.mildevs.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.mildevs.entity.Condutor;
import br.com.mildevs.entity.Veiculo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class CondutorDao {

	private EntityManager manager;

	public CondutorDao() {
		this.manager = Persistence.createEntityManagerFactory("sistema").createEntityManager();
	}

	//CRIAR
	public boolean create(Condutor condutor) {
		manager.getTransaction().begin();
		manager.persist(condutor);
		manager.getTransaction().commit();
		return true;
	}
	
	public boolean adicionaVeiculo(Veiculo veiculo, String nroCnh) {
		Condutor condutor = this.manager.find(Condutor.class, nroCnh);
		if(condutor == null) return false;
		if(veiculo.getCondutor() != null) return false;
		
		List<Veiculo> veiculos = new ArrayList();
		veiculos.add(veiculo);
		condutor.setVeiculo(veiculos);
		
		this.manager.getTransaction().begin();
		this.manager.merge(condutor);
		this.manager.getTransaction().commit();
		return true;
	}
	
	
	//CONSULTA UNICA
	public Condutor read(String nroCnh) {
		return manager.find(Condutor.class, nroCnh);
	}

	//CONSULTA GERAL
	public List<Condutor> readAll() {
		Query query = manager.createQuery("select c from Condutor as c");
		return query.getResultList();
	}

	//REMOÇÃO
	public boolean delete(String nroCnh) {
		Condutor condutorASerRemovido = manager.find(Condutor.class, nroCnh);

		if (condutorASerRemovido == null)
			return false;

		manager.getTransaction().begin();
		manager.remove(condutorASerRemovido);
		manager.getTransaction().commit();
		return true;
	}
}
