package dao;

import javax.persistence.Query;

import model.Produto;

public class DAOProduto extends DAO<Produto> {
	
	public Produto findByNome(String nome){		
		Query query = getManager().createQuery("Select p from Produto p where p.nome ='"+ nome +"'");			
		return (Produto) query.getResultList();		
	}

}
