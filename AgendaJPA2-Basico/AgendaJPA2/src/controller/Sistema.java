package controller;

import java.util.GregorianCalendar;
import java.util.List;

import jdk.nashorn.internal.runtime.FindProperty;
import model.Aluno;
import model.Pessoa;
import model.Produto;
import model.ProdutoPerecivel;
import model.Professor;
import dao.DAO;
import dao.DAOPessoa;
import dao.DAOProduto;

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

	@SuppressWarnings("static-access")
	public static void cadastraProdutos() {
		DAOProduto daoProduto = new DAOProduto();
		DAO.open();
		DAO.begin();
		
		Produto p1 = new Produto("cd", 100.0, 20,  new GregorianCalendar(2014, 11, 30).getTime() );
		Produto p2 = new Produto("dvd", 10.12, 12,  new GregorianCalendar(2013, 11, 30).getTime() );
		Produto p3 = new Produto("caneta", 50.10, 16,  new GregorianCalendar(2012, 11, 30).getTime() );
		
		ProdutoPerecivel pr1 = new ProdutoPerecivel("feijao", 50.10, 16,  new GregorianCalendar(2012, 11, 30).getTime(), new GregorianCalendar(2016, 01, 01).getTime() );
		ProdutoPerecivel pr2 = new ProdutoPerecivel("bolo", 50.10, 16,  new GregorianCalendar(2006, 3, 20).getTime(), new GregorianCalendar(2020, 12, 31).getTime() );
					
		daoProduto.persist(p1);
		daoProduto.flush();
		daoProduto.persist(p2);
		daoProduto.flush();
		daoProduto.persist(p3);
		daoProduto.flush();
		daoProduto.persist(pr1);
		daoProduto.flush();
		daoProduto.persist(pr2);
				
		DAO.commit();		
		
		DAO.close();
		
	}

	public static String listarProdutos() {
		
		DAOProduto daoProduto = new DAOProduto();
		DAO.open();
		List<Produto> produtos = daoProduto.findAll();
		
		String texto="-----------listagem de Produtos-----------\n";
		for (Produto produto : produtos) {
			texto += "   "+produto.getNome() + "\n";		
		}
		
		DAO.close();
		return texto;
	}

	public static void recuperaTodosProdutos() {
		
		DAOProduto daoProduto = new DAOProduto();
		DAO.open();
		
		List<Produto> produtos = daoProduto.findAll();
		
		for (Produto produto : produtos) {
			System.out.println(produto.getId() +" - " + produto.getNome()+ " - " + produto.getPreco());
		}
		
		DAO.close();
		
		
	}

	public static void alteraPreco10() {
		
		DAOProduto daoProduto = new DAOProduto();
		DAO.open();
		DAO.begin();		
		
		List<Produto> produtos = daoProduto.findAll();
		
		for (Produto produto : produtos) {
			produto.setPreco(produto.getPreco() * 1.1);
			daoProduto.merge(produto);
		}
		
		DAO.commit();
		DAO.close();
		
	}

	public static void excluirProdutoEstoqueZero() {
		DAOProduto daoProduto = new DAOProduto();
		DAO.open();
		DAO.begin();
		
		List<Produto> produtos = daoProduto.findAll();
		
		for (Produto produto : produtos) {
			if (produto.getEstoque() == 0){
				daoProduto.remove(produto);
			}
		}
		DAO.commit();
		DAO.close();
		
	}
}
