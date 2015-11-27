package br.com.cwi.crescer.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Servico")
@SequenceGenerator(name = Servico.SEQUENCE_NAME, sequenceName = Servico.SEQUENCE_NAME)
public class Servico {
	public static final String SEQUENCE_NAME = "SEQ_Servico";
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
	@Column(name = "IDServico")
	private long idServico;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "Descricao", length = 30)
	@Basic(optional = false)
	private ServicoDescricao descricao;

    public static enum ServicoDescricao {
        Lavar, Secar
    }
	
	public long getIdServico() {
		return idServico;
	}

	public void setIdServico(long idServico) {
		this.idServico = idServico;
	}

	public ServicoDescricao getDescricao() {
		return descricao;
	}

	public void setDescricao(ServicoDescricao descricao) {
		this.descricao = descricao;
	}
	
}
