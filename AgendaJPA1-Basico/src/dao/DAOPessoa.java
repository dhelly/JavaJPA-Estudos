/**IFPB - Curso SI - Disciplina de PERSISTENCIA DE OBJETOS
 * @author Prof Fausto Ayres
 */

package dao;

import javax.persistence.Query;

import model.Pessoa;

public class DAOPessoa extends DAO<Pessoa>{
	public DAOPessoa(){
		super();
	}
	
	public Pessoa findByNome (String n){
		Query q = getManager().createQuery("select p from Pessoa p where p.nome= '" + n +"'");
		return (Pessoa) q.getSingleResult();
	}
}

