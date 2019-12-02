package br.com.ficticiusClean.models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;

public class ControleVeiculos {
	
	private ArrayList<VeiculoEmpresa> listVeiculosEmpresa;
	
	/* API do calculo da previsao de gastos de cada veiculo cadastrado pela empresa */	
	public ArrayList<VeiculoEmpresa> CalculoPrevisaoDeGastos(
			ArrayList<Veiculo> listVeiculos, double precoGasolina, double distanciaCidade, double distanciaRodovia) {
		
		Double qtdCombustivelTotal;
		Double valorTotalCombustivel;
		int ano;
		
		listVeiculosEmpresa = new ArrayList<>();
		
		/* Inserir valor nos atributo dos veículos e adicionar cada veiculo na lista */
		for(int i = 0; i < listVeiculos.size(); i++) {
			ano = listVeiculos.get(i).getDtFabricacao().getYear();
			qtdCombustivelTotal = calculoQtdCombustivel(distanciaCidade, listVeiculos.get(i).getConsumoCidade())
								  + calculoQtdCombustivel(distanciaCidade, listVeiculos.get(i).getConsumoCidade());
			valorTotalCombustivel = precoGasolina * qtdCombustivelTotal;
			VeiculoEmpresa veiculoEmpresa = new VeiculoEmpresa(listVeiculos.get(i), ano, qtdCombustivelTotal, valorTotalCombustivel);
			
			listVeiculosEmpresa.add(veiculoEmpresa);
		}
		
		/* Ordena a lista de veiculos de acordo com o valor total de combustivel gasto */
		Collections.sort(listVeiculosEmpresa);
		
		return listVeiculosEmpresa;
	}
	
	/* Realiza o calculo da quantidade de combustivel gasto */
	public Double calculoQtdCombustivel(double distancia, double consumo) {
		return distancia/consumo;
	}
	
}
