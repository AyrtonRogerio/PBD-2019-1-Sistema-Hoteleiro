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
@Subselect("SELECT DISTINTIC r.*, f.cpf, f.nome FROM reserva r, pessoa_fisica f WHERE r.cliente_id = f.id")
public class ReservaViewFisica {

	@Id 
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	@OneToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	@Column(length = 50, nullable = false)
	private String nome;
	
	@Column(nullable = false, unique = true)
	private String cpf;
	
	@OneToOne
	@JoinColumn(name = "quarto_id")
	private Quarto quarto;
	
	@Column(name = "data_reserva")
	private LocalDate dataReserva;
	
	@Column(name = "hora_reserva")
	private LocalTime horaReserva;
	
	@Column
	private boolean situacao;
	
	@Column
	private boolean status;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * @return the quarto
	 */
	public Quarto getQuarto() {
		return quarto;
	}

	/**
	 * @param quarto the quarto to set
	 */
	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}

	/**
	 * @return the dataReserva
	 */
	public LocalDate getDataReserva() {
		return dataReserva;
	}

	/**
	 * @param dataReserva the dataReserva to set
	 */
	public void setDataReserva(LocalDate dataReserva) {
		this.dataReserva = dataReserva;
	}

	/**
	 * @return the horaReserva
	 */
	public LocalTime getHoraReserva() {
		return horaReserva;
	}

	/**
	 * @param horaReserva the horaReserva to set
	 */
	public void setHoraReserva(LocalTime horaReserva) {
		this.horaReserva = horaReserva;
	}

	/**
	 * @return the situacao
	 */
	public boolean isSituacao() {
		return situacao;
	}

	/**
	 * @param situacao the situacao to set
	 */
	public void setSituacao(boolean situacao) {
		this.situacao = situacao;
	}

	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}
	
}
