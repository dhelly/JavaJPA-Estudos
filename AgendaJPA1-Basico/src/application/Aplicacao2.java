package application;
/**IFPB - Curso SI - Disciplina de PERSISTENCIA DE OBJETOS
 * @author Prof Fausto Ayres
 */

import controller.Sistema;

public class Aplicacao2 {
	public Aplicacao2(){
		Sistema.alterarPessoa(1,"joana");   	//alterar joao para joana
		Sistema.listarPessoas();
	}

	//=================================================
	public static void main(String[] args) {
		new Aplicacao2();
	}
	//=================================================

}
