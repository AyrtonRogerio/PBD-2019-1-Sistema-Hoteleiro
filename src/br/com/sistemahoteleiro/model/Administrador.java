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
@Table(name = "administrador")
@SequenceGenerator(name = Entidade.SEQUENCE_ENTIDADE, sequenceName = Administrador.SEQUENCE_ENTIDADE, initialValue = 1, allocationSize = 1)
public class Administrador extends Usuario {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static final String SEQUENCE_ENTIDADE = "administrador_sequence";
	
}
