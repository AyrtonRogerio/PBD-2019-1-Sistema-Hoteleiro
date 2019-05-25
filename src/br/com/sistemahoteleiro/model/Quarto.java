/**
 * 
 */
package br.com.sistemahoteleiro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author ayrtons
 *
 */
@Entity
@Table(name = "quarto")
@SequenceGenerator(name = Entidade.SEQUENCE_ENTIDADE, sequenceName = Quarto.SEQUENCE_ENTIDADE, initialValue = 1, allocationSize = 1)
public class Quarto extends Entidade {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static final String SEQUENCE_ENTIDADE = "quarto_sequence";

	@Column(name = "qtd_camas")
	private int qtdCamas;
	
	@Column(name = "num_quarto")
	private int numQuarto;
	
	@Column(name = "tipo_quarto")
	private String tipoQuarto;
	
	@Column(name = "tv_a_cabo")
	private boolean tvACabo;
	
	@Column
	private boolean cofre;
	
	@Column(name = "tv_led")
	private boolean tvLed;
	
	@Column
	private boolean telefone;
	
	@Column(name = "ar_condicionado")
	private boolean arCondicionado;
	
	@Column
	private boolean wifi;
	
	@Column(name = "mini_bar")
	private boolean miniBar;
	
	@Column
	private boolean disponivel;
	
	
	/**
	 * @return the qtdCamas
	 */
	public int getQtdCamas() {
		return qtdCamas;
	}
	/**
	 * @param qtdCamas the qtdCamas to set
	 */
	public void setQtdCamas(int qtdCamas) {
		this.qtdCamas = qtdCamas;
	}
	/**
	 * @return the numQuarto
	 */
	public int getNumQuarto() {
		return numQuarto;
	}
	/**
	 * @param numQuarto the numQuarto to set
	 */
	public void setNumQuarto(int numQuarto) {
		this.numQuarto = numQuarto;
	}
	/**
	 * @return the tipoQuarto
	 */
	public String getTipoQuarto() {
		return tipoQuarto;
	}
	/**
	 * @param tipoQuarto the tipoQuarto to set
	 */
	public void setTipoQuarto(String tipoQuarto) {
		this.tipoQuarto = tipoQuarto;
	}
	/**
	 * @return the tvACabo
	 */
	public boolean isTvACabo() {
		return tvACabo;
	}
	/**
	 * @param tvACabo the tvACabo to set
	 */
	public void setTvACabo(boolean tvACabo) {
		this.tvACabo = tvACabo;
	}
	/**
	 * @return the cofre
	 */
	public boolean isCofre() {
		return cofre;
	}
	/**
	 * @param cofre the cofre to set
	 */
	public void setCofre(boolean cofre) {
		this.cofre = cofre;
	}
	/**
	 * @return the tvLed
	 */
	public boolean isTvLed() {
		return tvLed;
	}
	/**
	 * @param tvLed the tvLed to set
	 */
	public void setTvLed(boolean tvLed) {
		this.tvLed = tvLed;
	}
	/**
	 * @return the telefone
	 */
	public boolean isTelefone() {
		return telefone;
	}
	/**
	 * @param telefone the telefone to set
	 */
	public void setTelefone(boolean telefone) {
		this.telefone = telefone;
	}
	/**
	 * @return the arCondicionado
	 */
	public boolean isArCondicionado() {
		return arCondicionado;
	}
	/**
	 * @param arCondicionado the arCondicionado to set
	 */
	public void setArCondicionado(boolean arCondicionado) {
		this.arCondicionado = arCondicionado;
	}
	/**
	 * @return the wifi
	 */
	public boolean isWifi() {
		return wifi;
	}
	/**
	 * @param wifi the wifi to set
	 */
	public void setWifi(boolean wifi) {
		this.wifi = wifi;
	}
	/**
	 * @return the miniBar
	 */
	public boolean isMiniBar() {
		return miniBar;
	}
	/**
	 * @param miniBar the miniBar to set
	 */
	public void setMiniBar(boolean miniBar) {
		this.miniBar = miniBar;
	}
	/**
	 * @return the disponivel
	 */
	public boolean isDisponivel() {
		return disponivel;
	}
	/**
	 * @param disponivel the disponivel to set
	 */
	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}
	
	
}
