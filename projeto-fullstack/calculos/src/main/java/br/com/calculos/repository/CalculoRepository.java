package br.com.calculos.repository;

import br.com.calculos.entity.Resultado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalculoRepository extends JpaRepository<Resultado, Long> {
}
