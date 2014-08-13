package model;

import java.util.List;

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
		daopessoa.persist(p1);  
		DAO.flush();
		daopessoa.persist(p2);
		DAO.flush();
		daopessoa.persist(p3);

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

	public static void listarPessoas(){
		DAOPessoa daopessoa= new DAOPessoa();
		DAO.open();
		System.out.println("-----------listagem de Pessoas-----------");
		List<Pessoa> pessoas = daopessoa.findAll();
		for (Pessoa pe : pessoas) {
			System.out.println(pe.toString());
		}
		DAO.close();

	}
}
