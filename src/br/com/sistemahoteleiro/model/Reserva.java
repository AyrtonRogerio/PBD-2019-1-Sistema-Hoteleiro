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
public class Reserva extends Entidade {

	private LocalDate dataReserva;
	private LocalTime horaReserva;
	private BigDecimal valor;
	private Quarto quarto;
	private boolean situacao;
	
	
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
	 * @return the valor
	 */
	public BigDecimal getValor() {
		return valor;
	}
	/**
	 * @param valor the valor to set
	 */
	public void setValor(BigDecimal valor) {
		this.valor = valor;
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
	
	
	
}
