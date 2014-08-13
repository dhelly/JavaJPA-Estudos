package dao;

import javax.persistence.Query;

import model.Tarefa;

public class DAOTarefa extends DAO<Tarefa> {
	public DAOTarefa(){
		super();
	}
	public Tarefa findByNome (String d){
		Query q = getManager().createQuery("select t from Tarefa t where t.descrica= '" + d +"'");
		return (Tarefa) q.getSingleResult();
	}
	

}
