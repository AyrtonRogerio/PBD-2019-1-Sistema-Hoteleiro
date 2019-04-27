/**
 * 
 */
package br.com.sistemahoteleiro.dao;

import br.com.sistemahoteleiro.model.Contato;
import br.com.sistemahoteleiro.model.Endereco;
import br.com.sistemahoteleiro.model.PessoaFisica;

/**
 * @author ayrtons
 *
 */
public class DaoPessoaFisica extends DaoGeneric<PessoaFisica> implements IDaoPessoaFisica{

	/**
	 * @param class1
	 */
	public DaoPessoaFisica() {
		super(PessoaFisica.class);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		
		PessoaFisica fisica = new PessoaFisica();
		fisica.setNome("Ayrton");
		fisica.setCpf("111.111.111-11");
		fisica.setRg("12.879.515-3");
		
		Contato contato = new Contato();
		contato.setCelular("(75)99559-9625");
		contato.setEmail("ayrton@gmail.com");
		contato.setTelefone("(75)2706-4362");
		
		Endereco endereco = new Endereco();
		
		endereco.setBairro("Mangabeira");
		endereco.setCep("44056-808");
		endereco.setCidade("Feira de Santana");
		endereco.setLogradouro("Rua José de Araújo Diogo");
		endereco.setNumero("486");
		endereco.setUf("BA");
		
		
		fisica.setContato(contato);
		fisica.setEndereco(endereco);
		
		
		
		
	}
	
}
