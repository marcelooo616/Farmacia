package com.generation.progetoFarmacia.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity

@Table(name = "tb_categoria")

public class Categoria {

	@Id
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank
	private String descricao;
	
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("categoria")
	private List<Produto> produto;
	
	/*@NotBlank
	private String Medicamentos_manipulados;
	@NotBlank
	private String Produtos_de_receituario_medico;
	@NotBlank
	private String Produto_OTC;
	@NotBlank
	private String Medicamento_genericos;
	@NotBlank
	private String Medicamentos_homeopaticos;
	@NotBlank
	private String Produtos_de_higiene_limpeza;*/
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

}
