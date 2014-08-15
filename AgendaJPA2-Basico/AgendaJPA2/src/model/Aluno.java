package model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@DiscriminatorValue("alu")
public class Aluno extends Pessoa {
	private double nota;

	public Aluno() {}
	public Aluno(String nome, double nota) {
		super(nome);
		this.nota = nota;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	@Override
	public String toString() {
		return super.toString() + "    "+ nota;
	}

	

	

	
}
