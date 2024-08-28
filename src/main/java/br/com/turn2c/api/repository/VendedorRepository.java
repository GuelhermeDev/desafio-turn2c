package br.com.turn2c.api.repository;


import br.com.turn2c.api.entity.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VendedorRepository extends JpaRepository<Vendedor, Long> {

}
