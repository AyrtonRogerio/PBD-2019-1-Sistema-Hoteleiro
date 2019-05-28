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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * @author ayrtons
 *
 */
@Entity
@Table(name = "aluga")
@SequenceGenerator(name = Entidade.SEQUENCE_ENTIDADE, sequenceName = Aluga.SEQUENCE_ENTIDADE, initialValue = 1, allocationSize = 1)
public class Aluga extends Entidade {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static final String SEQUENCE_ENTIDADE = "aluga_sequence";
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "quarto_id")	
	private Quarto quarto;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "caixa_id")
	private Caixa caixa;
	
	
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
	 * @return the funcionario
	 */
	public Usuario getFuncionario() {
		return usuario;
	}

	/**
	 * @param funcionario the funcionario to set
	 */
	public void setFuncionario(Usuario usuario) {
		this.usuario = usuario;
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
	
	
}
