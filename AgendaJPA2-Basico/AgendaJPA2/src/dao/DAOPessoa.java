/**IFPB - Curso SI - Disciplina de PERSISTENCIA DE OBJETOS
 * @author Prof Fausto Ayres
 */

package dao;

import java.util.List;

import javax.persistence.Query;

import model.Aluno;
import model.Pessoa;
import model.Professor;

public class DAOPessoa extends DAO<Pessoa>{
	public DAOPessoa(){
		super();
	}
	
	public Pessoa findByNome (String n){
		Query q = getManager().createQuery("select p from Pessoa p where p.nome= '" + n +"'");
		return (Pessoa) q.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	public List<Aluno> localizarAluno() {
		
		Query query = getManager().createQuery("Select a from Aluno a");
		return  query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Professor> localizarProfessor() {
		Query query = getManager().createQuery("Select p from Professor p");
		return query.getResultList();
	}

	public List<Pessoa> localizarPessoas() {
		Query query = getManager().createQuery("Select p from Pessoa p");
		return query.getResultList();
	}
}

