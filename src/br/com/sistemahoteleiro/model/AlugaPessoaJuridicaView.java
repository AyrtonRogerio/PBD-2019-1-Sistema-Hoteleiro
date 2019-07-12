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
@Subselect("SELECT * FROM aluga")
public class AlugaPessoaJuridicaView {

	@Id
	private Integer id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pessoa_juridica")
	private PessoaJuridica pessoaJuridica;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "quarto_id")	
	private QuartoView quarto;
	
	
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
	public QuartoView getQuarto() {
		return quarto;
	}

	/**
	 * @param quarto the quarto to set
	 */
	public void setQuarto(QuartoView quarto) {
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

	
}
