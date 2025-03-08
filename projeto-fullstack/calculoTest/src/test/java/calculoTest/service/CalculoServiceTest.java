package calculoTest.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class CalculoServiceTest {
    @Autowired
    CalculoService calculoService;

    @Test
    void cenario01(){
        List<Double> lista = new ArrayList<>();
        lista.add(1.0);
        lista.add(4.0);
        lista.add(5.0);
        String resultado = this.calculoService.somar(lista);
        String resultadoEsperado = "Soma: " + 10.0 + " ,Media: " + 3.3333333333333335 +" ,Maior: " + 5.0 + " ,Menor: " + 1.0;
        assertEquals(resultadoEsperado, resultado);
    }
}
