/**
 * 
 */
package br.com.sistemahoteleiro.enuns;

/**
 * @author ayrton
 *
 */
public enum TipoCargo {

	ATENDENTE ("Atendente"), AUX_SERV_GERAIS ("Aux. serviço gerais"), 
	CAMAREIRA ("Camareira"), SUPER_USUARIO("Super usuário"), GERENTE("Gerente");
	
	private String descricao;
	
	/**
	 * 
	 */
	private TipoCargo(String descricao) {
	
		this.descricao = descricao;
	}
	
	public String getValor() {
		return this.descricao;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getValor();
	}
	
}
