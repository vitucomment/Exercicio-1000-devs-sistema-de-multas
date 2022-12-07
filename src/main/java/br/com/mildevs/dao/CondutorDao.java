package br.com.mildevs.dao;

import java.util.List;

import br.com.mildevs.entity.Condutor;
import br.com.mildevs.entity.Multa;
import br.com.mildevs.entity.Veiculo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class CondutorDao {

	private EntityManager manager;

	public CondutorDao() {
		this.manager = Persistence.createEntityManagerFactory("sistema").createEntityManager();
	}

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
		
		condutor.setVeiculo(veiculo);
		
		this.manager.getTransaction().begin();
		this.manager.merge(condutor);
		this.manager.getTransaction().commit();
		return true;
	}
	
	
	public boolean transferirVeiculo(String placa, String cnhDestino) {
		Condutor condutorDestino = this.manager.find(Condutor.class, cnhDestino);
		Veiculo veiculo = this.manager.find(Veiculo.class, placa);
		
		veiculo.setCondutor(condutorDestino);
		
		this.manager.getTransaction().begin();
		this.manager.merge(veiculo);
		this.manager.getTransaction().commit();
		return true;
	}
	
	public boolean computarMulta(Multa multa, String placa) {
		int pontos = multa.getPontuacao();
		Condutor condutor = this.manager.find(Veiculo.class, placa).getCondutor();
		condutor.setPontuação(condutor.getPontuação() - pontos);
		this.manager.getTransaction().begin();
		this.manager.merge(condutor);
		this.manager.getTransaction().commit();
		return true;
	}
	
	public Condutor read(String nroCnh) {
		return manager.find(Condutor.class, nroCnh);
	}

	@SuppressWarnings("unchecked")
	public List<Condutor> readAll() {
		Query query = manager.createQuery("select c from Condutor as c");
		return query.getResultList();
	}

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
