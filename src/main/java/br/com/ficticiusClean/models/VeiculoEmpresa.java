package br.com.ficticiusClean.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

/* Classe de auxiliar de Veiculo contendo as informacoes adicionais para retorno na api de CalculoPrevisaoDeGastos:
 * Ano, qtdCombustivelGasto, valorTotalCombustivel  */
public class VeiculoEmpresa implements Comparable<VeiculoEmpresa> {
	
	private String id;
	private String nome;
	private String marca;
	private String modelo;
	private int ano;
	private Double qtdCombustivelGasto;
	private Double valorTotalCombustivel;

	public VeiculoEmpresa(Veiculo veiculo, int ano, Double qtdCombustivelGasto, Double valorTotalCombustivel) {
		this.id = veiculo.getId();
		this.nome = veiculo.getNome();
		this.marca = veiculo.getMarca();
		this.modelo = veiculo.getModelo();
		this.ano = ano;
		this.qtdCombustivelGasto = qtdCombustivelGasto;
		this.valorTotalCombustivel = valorTotalCombustivel;
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

	public int getAno() {
		return ano;
	}

	public Double getQtdCombustivelGasto() {
		return qtdCombustivelGasto;
	}

	public Double getValorTotalCombustivel() {
		return valorTotalCombustivel;
	}

	/* Método para comparar o valor Total de cada veiculo */
	public int compareTo(VeiculoEmpresa veiculoEmpresa) {
		if ( this.valorTotalCombustivel < veiculoEmpresa.valorTotalCombustivel ) {
            return -1;
        }
        if ( this.valorTotalCombustivel > veiculoEmpresa.valorTotalCombustivel ) {
            return 1;
        }
        return 0;
	}
}
