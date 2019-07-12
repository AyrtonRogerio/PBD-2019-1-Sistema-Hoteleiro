/**
 * 
 */
package br.com.sistemahoteleiro.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

/**
 * @author ayrton
 *
 */
@Immutable
@Entity
@Subselect("SELECT * FROM reserva")
public class ReservaViewFisica {

	@Id 
	private Integer id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "caixa_id")
	private Caixa caixa;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pessoa_fisica")
	private PessoaFisica pessoaFisica;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "quarto_id")
	private Quarto quarto;
	
	
	@Column(name = "data_reserva")
	private LocalDate dataReserva;
	
	
	@Column(name = "hora_reserva")
	private LocalTime horaReserva;
	
	@Column
	private double valor;
	
	@Column
	private boolean situacao;
	
	@Column
	private boolean status;
	
	
}
