package controller;

import java.util.List;

import model.Aluno;
import model.Pessoa;
import model.Professor;
import dao.DAO;
import dao.DAOPessoa;

public class Consulta {

	public static void listaAluno() {
		
		DAOPessoa daoPessoa = new DAOPessoa();
		DAO.open();
		
		List<Aluno> alunos = daoPessoa.localizarAluno();
		System.out.println("----------- Relação de alunos ----------\n");
		for (Aluno aluno : alunos) {
			System.out.println(aluno.getNome()+"\n");
		}
		
		DAO.close();
		
	}

	public static void listaProfessor() {
		DAOPessoa daoPessoa = new DAOPessoa();
		DAO.open();
		
		List<Professor> professores = daoPessoa.localizarProfessor();
		System.out.println("----------- Relação de professor ----------\n");
		for (Professor professor : professores) {
			System.out.println(professor.getNome()+"\n");
		}
		
		DAO.close();
	}

	public static void listaPessoas() {
		DAOPessoa daoPessoa = new DAOPessoa();
		DAO.open();
		
		List<Pessoa> pessoas = daoPessoa.localizarPessoas();
		System.out.println("----------- Relação de pessoas ----------\n");
		for (Pessoa pessoa : pessoas) {
			System.out.println(pessoa.getNome()+"\n");
		}
		
		DAO.close();		
	}

}
