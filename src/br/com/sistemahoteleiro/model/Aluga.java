/**
 * 
 */
package br.com.sistemahoteleiro.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author ayrtons
 *
 */
public class Aluga extends Entidade {

	private LocalDate dataEntrada;
	private LocalTime horaEntrada;
	private LocalDate dataSaida;
	private LocalTime horaSaida;
	private int diaria;
	private BigDecimal valorDiaria;
	private BigDecimal valorAdicional;
	
	
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
	public BigDecimal getValorDiaria() {
		return valorDiaria;
	}
	/**
	 * @param valorDiaria the valorDiaria to set
	 */
	public void setValorDiaria(BigDecimal valorDiaria) {
		this.valorDiaria = valorDiaria;
	}
	/**
	 * @return the valorAdicional
	 */
	public BigDecimal getValorAdicional() {
		return valorAdicional;
	}
	/**
	 * @param valorAdicional the valorAdicional to set
	 */
	public void setValorAdicional(BigDecimal valorAdicional) {
		this.valorAdicional = valorAdicional;
	}
	
	
}
