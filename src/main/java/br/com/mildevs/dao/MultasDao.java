package br.com.mildevs.dao;

import java.util.List;

import br.com.mildevs.entity.Multa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class MultasDao {

	private EntityManager manager;

	public MultasDao() {
		this.manager = Persistence.createEntityManagerFactory("sistema").createEntityManager();
	}
	
	//CRIAR
	public boolean create(Multa multa) {
		manager.getTransaction().begin();
		manager.persist(multa);
		manager.getTransaction().commit();
		return true;
	}
	
	//CONSULTA UNICA
	public Multa read(String codigoMulta) {
		return manager.find(Multa.class, codigoMulta);
	}
	
	//CONSULTA GERAL
	public List<Multa> readAll(){
		Query query = manager.createQuery( "select m from Multa as m");
		return query.getResultList();
	}
	
	//REMOVER
	public boolean delete(String codigoMulta) {
		Multa MultaASerRemovida = manager.find(Multa.class, codigoMulta);
		
		if(MultaASerRemovida == null)
			return false;
		
		this.manager.getTransaction().begin();
		this.manager.remove(MultaASerRemovida);
		this.manager.getTransaction().commit();
		return true;
	}
	
	
}
