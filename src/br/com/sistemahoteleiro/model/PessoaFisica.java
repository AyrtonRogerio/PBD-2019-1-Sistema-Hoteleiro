/**
 * 
 */
package br.com.sistemahoteleiro.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.sistemahoteleiro.enuns.TipoEstadoCivil;
import br.com.sistemahoteleiro.enuns.TipoOcupacao;
import br.com.sistemahoteleiro.enuns.TipoSexo;

/**
 * @author ayrtons
 *
 */
@Entity
@Table(name = "pessoa_fisica")
@SequenceGenerator(name =  Entidade.SEQUENCE_ENTIDADE, sequenceName = PessoaFisica.SEQUENCE_ENTIDADE, initialValue = 1, allocationSize = 1)
public class PessoaFisica extends Cliente {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static final String SEQUENCE_ENTIDADE = "pessoa_fisica_sequence";

	@Column(nullable = false, unique = true)
	private String rg;
	
	@Column(nullable = false, unique = true)
	private String cpf;
	
	@Enumerated(EnumType.STRING)
	private TipoSexo sexo;
	
	@Enumerated(EnumType.STRING)
	private TipoEstadoCivil estado_civil;
	
	@Enumerated(EnumType.STRING)
	private TipoOcupacao ocupacao;
	
	@Column
	private LocalDate data_nascimento;
	
	/**
	 * @return the rg
	 */
	public String getRg() {
		return rg;
	}
	/**
	 * @param rg the rg to set
	 */
	public void setRg(String rg) {
		this.rg = rg;
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
	 * @return the sexo
	 */
	public TipoSexo getSexo() {
		return sexo;
	}
	/**
	 * @param sexo the sexo to set
	 */
	public void setSexo(TipoSexo sexo) {
		this.sexo = sexo;
	}
	/**
	 * @return the estado_civil
	 */
	public TipoEstadoCivil getEstado_civil() {
		return estado_civil;
	}
	/**
	 * @param estado_civil the estado_civil to set
	 */
	public void setEstado_civil(TipoEstadoCivil estado_civil) {
		this.estado_civil = estado_civil;
	}
	/**
	 * @return the ocupacao
	 */
	public TipoOcupacao getOcupacao() {
		return ocupacao;
	}
	/**
	 * @param ocupacao the ocupacao to set
	 */
	public void setOcupacao(TipoOcupacao ocupacao) {
		this.ocupacao = ocupacao;
	}
	/**
	 * @return the data_nascimento
	 */
	public LocalDate getData_nascimento() {
		return data_nascimento;
	}
	/**
	 * @param data_nascimento the data_nascimento to set
	 */
	public void setData_nascimento(LocalDate data_nascimento) {
		this.data_nascimento = data_nascimento;
	}
	
	
}
