package br.com.project.model.classes;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.envers.Audited;
//import org.primefaces.json.JSONObject;

import br.com.project.annotation.IdentificaCampoPesquisa;

@Audited
@Entity
@Table(name = "aluno")
@SequenceGenerator(name = "aluno_seq", sequenceName = "aluno_seq", initialValue = 1, allocationSize = 1)
public class Aluno implements Serializable {

	private static final long serialVersionUID = 1L;

	@IdentificaCampoPesquisa(descricaoCampo = "Código", campoConsulta = "alu_codigo")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "aluno_seq")
	private Long alu_codigo;

	@IdentificaCampoPesquisa(descricaoCampo = "Descrição", campoConsulta = "alu_descricao", principal = 1)
	@Column(length = 100, nullable = false)
	private String alu_nome;

	@Version
	@Column(name = "versionNum")
	private int versionNum;
	
	protected int getVersionNum() { 
		return versionNum;
	}

	public void setVersionNum(int versionNum) {
		this.versionNum = versionNum;
	}

	public Long getAlu_codigo() {
		return alu_codigo;
	}

	public void setAlu_codigo(Long alu_codigo) {
		this.alu_codigo = alu_codigo;
	}

	public String getAlu_nome() {
		return alu_nome;
	}

	public void setAlu_nome(String alu_nome) {
		this.alu_nome = alu_nome;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alu_codigo == null) ? 0 : alu_codigo.hashCode());
		result = prime * result + ((alu_nome == null) ? 0 : alu_nome.hashCode());
		result = prime * result + versionNum;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (alu_codigo == null) {
			if (other.alu_codigo != null)
				return false;
		} else if (!alu_codigo.equals(other.alu_codigo))
			return false;
		if (alu_nome == null) {
			if (other.alu_nome != null)
				return false;
		} else if (!alu_nome.equals(other.alu_nome))
			return false;
		if (versionNum != other.versionNum)
			return false;
		return true;
	}

	




	

}
