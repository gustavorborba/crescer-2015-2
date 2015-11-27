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
@Table(name = "Material")
@SequenceGenerator(name = Material.SEQUENCE_NAME, sequenceName = Material.SEQUENCE_NAME)
public class Material {
	public static final String SEQUENCE_NAME = "SEQ_Material";
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
	@Column(name = "IDMaterial")
	private long idMaterial;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "Descricao", length = 30)
	@Basic(optional = false)
	private MaterialDescricao descricao;

	public static enum MaterialDescricao{
		Delicado,Normal,Pesado
	}
	
	public long getIdMaterial() {
		return idMaterial;
	}

	public void setIdMaterial(long idMaterial) {
		this.idMaterial = idMaterial;
	}

	public MaterialDescricao getDescricao() {
		return descricao;
	}

	public void setDescricao(MaterialDescricao descricao) {
		this.descricao = descricao;
	}
	
	
}
