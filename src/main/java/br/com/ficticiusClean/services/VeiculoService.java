package br.com.ficticiusClean.services;

import java.util.List;
import java.util.Optional;

import br.com.ficticiusClean.models.Veiculo;
import br.com.ficticiusClean.repositories.VeiculoRepository;

public class VeiculoService {
	
	private VeiculoRepository veiculoRepository;
	
	public VeiculoService(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }
	
	public Veiculo getOne(String id) {
		return veiculoRepository.getOne(id);
	}
	
	public Optional<Veiculo> findById(String id) {
		return veiculoRepository.findById(id);
	}
	
	public List<Veiculo> findAll(){
		return veiculoRepository.findAll();
	}
	
	public Veiculo save(Veiculo veiculo) {
		return veiculoRepository.save(veiculo);
	}

	public void deleteById(String id) {
		veiculoRepository.deleteById(id);
	}
	
	public void deleteAll() {
		veiculoRepository.deleteAll();
	}
	
}
