package br.com.ficticiusClean.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

/* Classe para os veiculos da empresa Ficticius Clean */
@Entity
public class Veiculo {
	
	@Id
	@JsonIgnore
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	
	private String nome;
	private String marca;
	private String modelo;
	private Date   dtFabricacao;
	private Double consumoCidade;
	private Double consumoRodovia;
	
	public Veiculo() {
		
	}
	
	public Veiculo(String idEmpresa, String nome, String marca, String modelo, Date dtFabricacao, Double consumoCidade, Double consumoRodovia) {
		this.id = idEmpresa;
		this.nome = nome;
		this.marca = marca;
		this.modelo = modelo;
		this.dtFabricacao = dtFabricacao;
		this.consumoCidade = consumoCidade;
		this.consumoRodovia = consumoRodovia;
	}	
	
	public String getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public Date getDtFabricacao() {
		return dtFabricacao;
	}

	public Double getConsumoCidade() {
		return consumoCidade;
	}

	public Double getConsumoRodovia() {
		return consumoRodovia;
	}
	
}
