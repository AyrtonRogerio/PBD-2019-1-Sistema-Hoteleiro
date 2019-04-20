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
@Table(name = "super_usuario")
@SequenceGenerator(name = Entidade.SEQUENCE_ENTIDADE, sequenceName = SuperUsuario.SEQUENCE_ENTIDADE, initialValue =  1, allocationSize = 1)
public class SuperUsuario extends Usuario {

	private static final long serialVersionUID = 1L;
	
	protected static final String SEQUENCE_ENTIDADE = "super_usuario_sequence";

	
}
