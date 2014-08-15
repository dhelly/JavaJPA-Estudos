package application;

import controller.Consulta;


/**
 * @author Jaqueline
 *
 */
public class Aplicacao4 {
	public Aplicacao4(){
		   			
		Consulta.listaAluno();
		Consulta.listaProfessor();
		Consulta.listaPessoas();
	}
	
	
	//=================================================
	public static void main(String[] args) {
		new Aplicacao4();
	}
	//=================================================

}
