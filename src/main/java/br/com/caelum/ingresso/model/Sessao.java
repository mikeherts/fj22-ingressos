package br.com.caelum.ingresso.model;

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
	
	/**
	 * *	@deprecated hibernate only
	 */
	
	public Sessao() {
	}

	public Sessao(LocalTime horario, Sala sala, Filme filme) {
		this.horario = horario;
		this.sala = sala;
		this.filme = filme;
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
