/**
 * 
 */
package br.com.sistemahoteleiro.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import br.com.sistemahoteleiro.enuns.TipoEstadoCivil;
import br.com.sistemahoteleiro.enuns.TipoOcupacao;
import br.com.sistemahoteleiro.enuns.TipoSexo;

/**
 * @author ayrton
 *
 */
@Immutable
@Entity
@Subselect("SELECT * FROM pessoa_fisica")
public class PessoaFisicaView {

	@Id
	private Integer id;
	
	@Column
	private boolean status = true;
	
	@Column(length = 50, nullable = false, unique = true)
	private String nome;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "contato_id")
	private Contato contato;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;
	
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
	 * @return the contato
	 */
	public Contato getContato() {
		return contato;
	}
	
	/**
	 * @param contato the contato to set
	 */
	public void setContato(Contato contato) {
		this.contato = contato;
	}
	
	/**
	 * @return the endereco
	 */
	public Endereco getEndereco() {
		return endereco;
	}
	
	/**
	 * @param endereco the endereco to set
	 */
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

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
