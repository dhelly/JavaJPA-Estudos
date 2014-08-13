package model;

/**IFPB - Curso SI - Disciplina de PERSISTENCIA DE OBJETOS
 * @author Prof Fausto Ayres
 */


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity 		
public class Pessoa {
	@Id		
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nome;
	@Temporal(TemporalType.DATE)
	private Date dtcadastro = new Date();

	//construtor vazio
	public Pessoa (){}
	
	public Pessoa(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	
	public int getId() {
		return id;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}
	public String toString() {
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		return id + "  " + String.format("%10s", nome) + "  " + 
				f.format(dtcadastro.getTime());
	}
	
}
