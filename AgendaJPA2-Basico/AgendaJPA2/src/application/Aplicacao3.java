package application;
/**IFPB - Curso SI - Disciplina de PERSISTENCIA DE OBJETOS
 * @author Prof Fausto Ayres
 */

import controller.Sistema;


public class Aplicacao3 {
	public Aplicacao3(){
		Sistema.excluirProdutoEstoqueZero();   			
		System.out.println(Sistema.listarProdutos());		
	}
	
	
	//=================================================
	public static void main(String[] args) {
		new Aplicacao3();
	}
	//=================================================

}
