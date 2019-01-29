package br.com.caelum.ingresso.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Sessao {
	@Id
	@GeneratedValue
	private Long id;
	private LocalTime horario;
	
	@ManyToOne
	private Sala sala;
	
	@ManyToOne
	private Filme filme;
	
	private BigDecimal preco;
	
	/**
	 * *	@deprecated hibernate only
	 */
	
	public Sessao() {
	}

	public Sessao(LocalTime horario, Sala sala, Filme filme) {
		this.horario = horario;
		this.sala = sala;
		this.filme = filme;
		this.preco = sala.getPreco().add(filme.getPreco());
	}
	
	

    public BigDecimal getPreco() {
    	if (preco != null) {
    		return preco.setScale(2, RoundingMode.HALF_UP);
    	}
    	return BigDecimal.ZERO;
    	
    }

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public LocalTime getHorarioTermino(){
		return this.horario.plusMinutes(filme.getDuracao().toMinutes());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalTime getHorario() {
		return horario;
	}

	public Sala getSala() {
		return sala;
	}


	public Filme getFilme() {
		return filme;
	}

}
