package model;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class ProdutoPerecivel extends Produto {

	@Temporal(TemporalType.DATE)
	private Date dtvalidade = new GregorianCalendar(2014, 11, 30).getTime();

	
	public ProdutoPerecivel(){}
	
	public ProdutoPerecivel(String nome, double preco, int estoque, Date dtcadastro, Date dtvalidade) {
		super(nome, preco, estoque, dtcadastro);
		this.dtvalidade = dtvalidade;
	}

	public Date getDtvalidade() {
		return dtvalidade;
	}

	public void setDtvalidade(Date dtvalidade) {
		this.dtvalidade = dtvalidade;
	}
	
	
}
