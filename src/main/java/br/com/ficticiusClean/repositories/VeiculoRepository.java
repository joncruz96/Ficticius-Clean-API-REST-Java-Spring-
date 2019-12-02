package br.com.ficticiusClean.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ficticiusClean.models.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, String> {

}
