package calculoTest.controller;

import calculoTest.entity.Entrada;
import calculoTest.entity.Saida;
import calculoTest.service.CalculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/api/calculo")
public class CalculoController {

    @Autowired
    private CalculoService calculoService;

    // Entrada Endpoints
    @PostMapping("/entrada")
    public ResponseEntity<Entrada> createEntrada(@RequestBody Entrada entrada) {
        return ResponseEntity.ok(calculoService.createEntrada(entrada));
    }

    @GetMapping("/entradas")
    public ResponseEntity<List<Entrada>> getAllEntradas() {
        return ResponseEntity.ok(calculoService.getAllEntradas());
    }

    @GetMapping("/entrada/{id}")
    public ResponseEntity<Entrada> getEntradaById(@PathVariable Long id) {
        return ResponseEntity.ok(calculoService.getEntradaById(id));
    }

    @PutMapping("/entrada/{id}")
    public ResponseEntity<Entrada> updateEntrada(@PathVariable Long id, @RequestBody Entrada entrada) {
        return ResponseEntity.ok(calculoService.updateEntrada(id, entrada));
    }

    @DeleteMapping("/entrada/{id}")
    public ResponseEntity<Void> deleteEntrada(@PathVariable Long id) {
        calculoService.deleteEntrada(id);
        return ResponseEntity.ok().build();
    }

    // Saida Endpoints
    @PostMapping("/saida")
    public ResponseEntity<Saida> createSaida(@RequestBody Saida saida) {
        return ResponseEntity.ok(calculoService.createSaida(saida));
    }

    @GetMapping("/saidas")
    public ResponseEntity<List<Saida>> getAllSaidas() {
        return ResponseEntity.ok(calculoService.getAllSaidas());
    }

    // Calculo Endpoint
    @GetMapping("/calcular")
    public ResponseEntity<Saida> calcular() {
        Saida resultado = calculoService.calcular();
        if (resultado == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(resultado);
    }
}

