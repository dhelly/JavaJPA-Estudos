package controller;

import java.util.Calendar;

import model.Tarefa;
import dao.DAO;
import dao.DAOTarefa;


public class AdicionaTarefa{

public static void cadastrarTarefas(){
	DAOTarefa daoTarefa = new DAOTarefa();
	DAO.open();
	DAO.begin();
	
	Tarefa tarefa = new Tarefa();
	tarefa.setDescricao("Estudar JPA");
	tarefa.setFinalizado(true);
	tarefa.setDataFinalizacao(Calendar.getInstance());
			
	daoTarefa.persist(tarefa); //persiste os dados
	DAO.flush();//
	DAO.commit();
	
	System.out.println("ID da tarefa: " + tarefa.getId());	
}

public static void excluirTarefa() {


	DAOTarefa daoTarefa = new DAOTarefa();
	DAO.open();
	DAO.close();
	int id = 1;
	Tarefa encontrada = daoTarefa.find(id);
	
}
	
}
