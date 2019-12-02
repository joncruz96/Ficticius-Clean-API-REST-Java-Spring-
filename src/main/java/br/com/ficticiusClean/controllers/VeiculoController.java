package br.com.ficticiusClean.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.ficticiusClean.models.Veiculo;
import br.com.ficticiusClean.services.VeiculoService;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {
/* Classe de Controller para disponibilizar a API REST da classe Veiculo */
	
	@Autowired
	public VeiculoService veiculoService;
	
	@GetMapping
	public List<Veiculo> findAll(){
		return veiculoService.findAll();
	}
	
	@GetMapping
	public ResponseEntity<Veiculo> findById(String id){
		return veiculoService.findById(id)
					.map(record -> ResponseEntity.ok().body(record))
					.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Veiculo> create(@Valid @RequestBody Veiculo veiculo) {
		Veiculo obj = veiculoService.save(veiculo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	
	public ResponseEntity update(@PathVariable("id") String id, @RequestBody Veiculo veiculo) {
		return veiculoService.findById(id)
				.map(record -> {
				record = new Veiculo(id, veiculo.getNome(), veiculo.getMarca(),
						veiculo.getModelo(), veiculo.getDtFabricacao(), veiculo.getConsumoCidade() , veiculo.getConsumoRodovia());
				Veiculo updated = veiculoService.save(record);
				return ResponseEntity.accepted().body(updated);
				}).orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping(path ={"/{id}"})
	public ResponseEntity<?> delete(@PathVariable String id) {
	   return veiculoService.findById(id)
	           .map(record -> {
	               veiculoService.deleteById(id);
	               return ResponseEntity.ok().build();
	           }).orElse(ResponseEntity.notFound().build());
	}
	
}
