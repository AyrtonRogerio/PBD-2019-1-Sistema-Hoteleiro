/**
 * 
 */
package br.com.sistemahoteleiro.model;


import java.time.LocalDate;
import java.time.LocalTime;

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
@Subselect("SELECT DISTINCT a.*, f.cpf, f.nome FROM aluga a, pessoa_fisica f WHERE a.cliente_id = f.id")
public class AlugaPessoaFisicaView {
	
	
	@Id
	private Integer id;
	
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
	
	@Column(name = "data_entrada")
	private LocalDate dataEntrada;
	
	
	@Column(name = "hora_entrada")
	private LocalTime horaEntrada;
	
	
	@Column(name = "data_saida")
	private LocalDate dataSaida;
	
	
	@Column(name = "hora_saida")
	private LocalTime horaSaida;
	
	@Column
	private int diaria;
	
	@Column(name = "valor_diaria")
	private double valorDiaria;
	
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
	 * @return the dataEntrada
	 */
	public LocalDate getDataEntrada() {
		return dataEntrada;
	}

	/**
	 * @param dataEntrada the dataEntrada to set
	 */
	public void setDataEntrada(LocalDate dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	/**
	 * @return the horaEntrada
	 */
	public LocalTime getHoraEntrada() {
		return horaEntrada;
	}

	/**
	 * @param horaEntrada the horaEntrada to set
	 */
	public void setHoraEntrada(LocalTime horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	/**
	 * @return the dataSaida
	 */
	public LocalDate getDataSaida() {
		return dataSaida;
	}

	/**
	 * @param dataSaida the dataSaida to set
	 */
	public void setDataSaida(LocalDate dataSaida) {
		this.dataSaida = dataSaida;
	}

	/**
	 * @return the horaSaida
	 */
	public LocalTime getHoraSaida() {
		return horaSaida;
	}

	/**
	 * @param horaSaida the horaSaida to set
	 */
	public void setHoraSaida(LocalTime horaSaida) {
		this.horaSaida = horaSaida;
	}

	/**
	 * @return the diaria
	 */
	public int getDiaria() {
		return diaria;
	}

	/**
	 * @param diaria the diaria to set
	 */
	public void setDiaria(int diaria) {
		this.diaria = diaria;
	}

	/**
	 * @return the valorDiaria
	 */
	public double getValorDiaria() {
		return valorDiaria;
	}

	/**
	 * @param valorDiaria the valorDiaria to set
	 */
	public void setValorDiaria(double valorDiaria) {
		this.valorDiaria = valorDiaria;
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

//	/**
//	 * @return the pessoaFisica
//	 */
//	public PessoaFisica getPessoaFisica() {
//		return pessoaFisica;
//	}
//
//	/**
//	 * @param pessoaFisica the pessoaFisica to set
//	 */
//	public void setPessoaFisica(PessoaFisica pessoaFisica) {
//		this.pessoaFisica = pessoaFisica;
//	}
	
	
	
}
