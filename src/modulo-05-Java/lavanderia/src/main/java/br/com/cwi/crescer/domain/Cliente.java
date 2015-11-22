package br.com.cwi.crescer.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Cliente")
@SequenceGenerator(name = Cliente.SEQUENCE_NAME, sequenceName = Cliente.SEQUENCE_NAME)
public class Cliente {
	public static final String SEQUENCE_NAME = "SEQ_Cliente";
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
	@Column(name = "IDCliente")
	private long idCliente;
	
	@Column(name = "Nome", length = 70)
	@Basic(optional = false)
	private String nome;
	
	@Column(name = "CPF")
	@Basic(optional = false)
	private String cpf;
	
	@Column(name = "Email", length = 100)
	private String email;
	
	@Column(name = "Endereco", length = 50)
	private String endereco;
	
	@Column(name = "Bairro",length = 50)
	private String bairro;
	
	@Column(name = "IDCidade")
	private long idCidade;
	
	@Column(name = "CEP", length = 8)
	private long cep;
	
	@Column(name = "Situacao", length = 1)
	private char situacao;
}
