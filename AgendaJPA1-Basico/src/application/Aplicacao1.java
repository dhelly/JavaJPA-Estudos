package application;
/**IFPB - Curso SI - Disciplina de PERSISTENCIA DE OBJETOS
 * @author Prof Fausto Ayres
 */


import controller.Sistema;

public class Aplicacao1 {
	public Aplicacao1(){
		Sistema.cadastrarPessoas();
		System.out.println( Sistema.listarPessoas() );;
	}

	//=================================================
	public static void main(String[] args) {
		new Aplicacao1();
	}
	//=================================================

}
