/**
 * 
 */
package br.com.sistemahoteleiro.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * @author ayrtons
 *
 */
@Entity
@Table(name = "reserva")
@SequenceGenerator(name = Entidade.SEQUENCE_ENTIDADE, sequenceName = Reserva.SEQUENCE_ENTIDADE, initialValue = 1, allocationSize = 1)
public class Reserva extends Entidade {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static final String SEQUENCE_ENTIDADE = "reserva_sequence";

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "caixa_id")
	private Caixa caixa;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "funcionario_id")
	private Funcionario funcionario;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
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
	public double getValor() {
		return valor;
	}
	/**
	 * @param valor the valor to set
	 */
	public void setValor(double valor) {
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
	/**
	 * @return the caixa
	 */
	public Caixa getCaixa() {
		return caixa;
	}
	/**
	 * @param caixa the caixa to set
	 */
	public void setCaixa(Caixa caixa) {
		this.caixa = caixa;
	}
	/**
	 * @return the funcionario
	 */
	public Funcionario getFuncionario() {
		return funcionario;
	}
	/**
	 * @param funcionario the funcionario to set
	 */
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
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
	 * @return the sequenceEntidade
	 */
	public static String getSequenceEntidade() {
		return SEQUENCE_ENTIDADE;
	}
	
	
}
