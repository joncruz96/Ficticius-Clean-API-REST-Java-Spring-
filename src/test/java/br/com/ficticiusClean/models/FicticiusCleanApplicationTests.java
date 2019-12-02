package br.com.ficticiusClean.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import br.com.ficticiusClean.repositories.VeiculoRepository;

@SpringBootTest
class FicticiusCleanApplicationTests {
	/* Métodos de testes criados na codificação utilizando TDD e para realizar a cobertura 
	 * de código do módulo br.com.ficticiusClean.models */
	
	private final String idEmpresa1      = "4325";
	private final String nome1           = "Cruze";
	private final String marca1          = "Chevrolet";
	private final String modelo1         = "Esportivo";
	private final Date   dtFabricacao1   = new Date(2018, 04, 27);
	private final Double consumoCidade1  = 10.0;
	private final Double consumoRodovia1 = 9.5;
	
	private final String idEmpresa2      = "1234";
	private final String nome2           = "Golf";
	private final String marca2          = "Volkswagen";
	private final String modelo2         = "Gti";
	private final Date 	 dtFabricacao2   = new Date(2019, 01, 05);
	private final Double consumoCidade2  = 5.3;
	private final Double consumoRodovia2 = 7.9;
	
	private final String idEmpresa3      = "3567";
	private final String nome3           = "Gol";
	private final String marca3          = "Volkswagen";
	private final String modelo3         = "Clássico";
	private final Date 	 dtFabricacao3   = new Date(2010, 11, 25);
	private final Double consumoCidade3  = 12.1;
	private final Double consumoRodovia3 = 9.7;
	
	@Test
	void testNovoVeiculo() {
		
		/*GIVEN*/
		Veiculo veiculo = new Veiculo(idEmpresa1, nome1, marca1, modelo1, dtFabricacao1, consumoCidade1, consumoRodovia1);
		
		VeiculoRepository repository = new VeiculoRepositoryMock();
		
		/*WHEN*/
		String veiculoId = idEmpresa1;
		repository.save(veiculo);
		Veiculo veiculoSaved = repository.getOne(veiculoId);
		
		/*THEN*/
		assertNotNull(veiculoId);
		assertNotNull(veiculoSaved);
		
		assertEquals(veiculoId, veiculoSaved.getId());
		assertNotEquals(0, veiculoSaved.getConsumoCidade());
		assertNotEquals(0, veiculoSaved.getConsumoRodovia());
		
	}
	
	@Test
	void testRetornoListaRanqueada() {
		
		/*GIVEN*/
		double precoGasolina = 4.6;
		double distanciaCidade = 40.5;
		double distanciaRodovia = 122.3;
		
		Veiculo veiculo1 = new Veiculo(idEmpresa1, nome1, marca1, modelo1, dtFabricacao1, consumoCidade1, consumoRodovia1);
		Veiculo veiculo2 = new Veiculo(idEmpresa2, nome2, marca2, modelo2, dtFabricacao2, consumoCidade2, consumoRodovia2);
		Veiculo veiculo3 = new Veiculo(idEmpresa3, nome3, marca3, modelo3, dtFabricacao3, consumoCidade3, consumoRodovia3);
		
		ArrayList<Veiculo> listVeiculos = new ArrayList<>();
		listVeiculos.add(veiculo1);
		listVeiculos.add(veiculo2);
		listVeiculos.add(veiculo3);
		
		/*WHEN*/
		ControleVeiculos controleVeiculos = new ControleVeiculos();
		
		ArrayList<VeiculoEmpresa> listVeiculosEmpresa = controleVeiculos.CalculoPrevisaoDeGastos(listVeiculos, precoGasolina, distanciaCidade, distanciaRodovia);
		
		/*THEN*/
		assertNotNull(listVeiculosEmpresa);
		assertEquals(listVeiculosEmpresa.size(), 3);		
	}
	
	static class VeiculoRepositoryMock implements VeiculoRepository {

        private final Map<String, Veiculo> veiculos = new LinkedHashMap<>();

        @Override
        public Veiculo save(Veiculo veiculo) {
        	return veiculos.put(veiculo.getId(), veiculo);
        }

        @Override
        public Veiculo getOne(String id) {
            return veiculos.get(id);
        }
        
		@Override
		public Optional<Veiculo> findById(String id) {
			return null;
		}

		@Override
		public List<Veiculo> findAll() {
			return null;
		}

		@Override
		public void deleteById(String id) {
		}

		@Override
		public void deleteAll() {
		}

		@Override
		public List<Veiculo> findAll(Sort sort) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Veiculo> findAllById(Iterable<String> ids) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <S extends Veiculo> List<S> saveAll(Iterable<S> entities) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void flush() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public <S extends Veiculo> S saveAndFlush(S entity) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void deleteInBatch(Iterable<Veiculo> entities) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deleteAllInBatch() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public <S extends Veiculo> List<S> findAll(Example<S> example) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <S extends Veiculo> List<S> findAll(Example<S> example, Sort sort) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Page<Veiculo> findAll(Pageable pageable) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean existsById(String id) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public long count() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void delete(Veiculo entity) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deleteAll(Iterable<? extends Veiculo> entities) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public <S extends Veiculo> Optional<S> findOne(Example<S> example) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <S extends Veiculo> Page<S> findAll(Example<S> example, Pageable pageable) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <S extends Veiculo> long count(Example<S> example) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public <S extends Veiculo> boolean exists(Example<S> example) {
			// TODO Auto-generated method stub
			return false;
		}

    }

}
