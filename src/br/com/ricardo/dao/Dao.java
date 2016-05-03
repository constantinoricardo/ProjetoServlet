package br.com.ricardo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.ricardo.model.Clientes;

public class Dao {
	
	EntityManager em;
	
	public Dao() {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
		this.em = emf.createEntityManager();
	}
	
	public void inserir(Clientes cliente) {		
		
		this.em.getTransaction().begin();
		this.em.persist(cliente);
		this.em.getTransaction().commit();
		
	}
	
	public void alterar(Clientes cliente) {
		
		this.em.getTransaction().begin();
		this.em.merge(cliente);
		this.em.getTransaction().commit();
		
	}
	
	public void deletar(Clientes cliente) {
		Clientes client = this.em.find(Clientes.class, cliente.getId());
		
		this.em.getTransaction().begin();		
		this.em.remove(client);
		this.em.getTransaction().commit();
	}
	
	public List<Clientes> selecionarTodos() {
		
		List<Clientes> clientes = this.em.createQuery("from Clientes", Clientes.class).getResultList();				
		return clientes;
		
	}
	
	public Clientes selecionarCliente(Clientes clientes) {
		
		int id = clientes.getId();		
		Clientes cliente = this.em.find(Clientes.class, id);
		return cliente;
		
	}

}
