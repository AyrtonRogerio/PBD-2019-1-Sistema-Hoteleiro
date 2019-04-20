/**
 * 
 */
package br.com.sistemahoteleiro.model;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author ayrtons
 *
 */
@Entity
@Table(name = "funcionario")
@SequenceGenerator(name = Entidade.SEQUENCE_ENTIDADE, sequenceName = Funcionario.SEQUENCE_ENTIDADE, initialValue = 1, allocationSize = 1)
public class Funcionario extends Usuario {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static final String SEQUENCE_ENTIDADE = "sequence_funcionario";
	
}
