package controller;

import java.util.List;

import model.Aluno;
import model.Pessoa;
import model.Professor;
import dao.DAO;
import dao.DAOPessoa;

public class Sistema {
	/*****************************************************************/
	public static void cadastrarPessoas(){
		DAOPessoa daopessoa= new DAOPessoa();
		DAO.open();
		DAO.begin();	//inicio da transacao
		Pessoa p1,p2,p3;
		p1 = new Pessoa("joao");
		p2 = new Pessoa("maria");
		p3 = new Pessoa("ana");
		Aluno p4;
		Professor p5;
		p4 = new Aluno("paulo", 9.0);
		p5 = new Professor("jose", 2000.0);
		
		daopessoa.persist(p1);  
		DAO.flush();
		daopessoa.persist(p2);
		DAO.flush();
		daopessoa.persist(p3);
		DAO.flush();
		daopessoa.persist(p4);
		DAO.flush();
		daopessoa.persist(p5);
		DAO.commit();	//fim da transacao
		//DAO.rollback();
		
		DAO.close();
	}
	
	public static void alterarPessoa(int id, String novo){
		DAOPessoa daopessoa= new DAOPessoa();
		DAO.open();
		DAO.begin();
		
		Pessoa p = daopessoa.find(id);
		if (p!=null) {
			p.setNome(novo); 			
			p=daopessoa.merge(p);     	//memoria para bd
			//daopessoa.refresh(p);		//bd para memoria
		}
		else
			System.out.println("pesssoa inexistente:" + id);

		DAO.commit();
		//daopessoa.rollback();
		DAO.close();
	}

	public static void excluirPessoa(String n){
		DAOPessoa daopessoa= new DAOPessoa();
		DAO.open();
		DAO.begin();
		
		Pessoa p = daopessoa.findByNome(n);
		if (p!=null) 
			daopessoa.remove(p);
		else
			System.out.println("pesssoa inexistente:" + n);

		DAO.commit();
		DAO.close();
	}

	public static String listarPessoas(){
		DAOPessoa daopessoa= new DAOPessoa();
		DAO.open();
		List<Pessoa> pessoas = daopessoa.findAll();
		String texto="-----------listagem de Pessoas-----------\n";
		for (Pessoa pe : pessoas) {
			texto += pe +"\n";
		}
		DAO.close();
		return texto;

	}
}
