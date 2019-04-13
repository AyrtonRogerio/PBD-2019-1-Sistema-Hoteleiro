/**
 * 
 */
package br.com.sistemahoteleiro.model;

/**
 * @author ayrtons
 *
 */
public class Quarto extends Entidade {

	private int qtdCamas;
	private int numQuarto;
	private String tipoQuarto;
	private boolean tvACabo;
	private boolean cofre;
	private boolean tvLed;
	private boolean telefone;
	private boolean arCondicionado;
	private boolean wifi;
	private boolean miniBar;
	private boolean situacao;
	
	
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
