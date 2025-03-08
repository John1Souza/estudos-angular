package calculoTest.repository;

import calculoTest.entity.Entrada;
import calculoTest.entity.Saida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaidaRepository extends JpaRepository<Saida, Long> {
}
