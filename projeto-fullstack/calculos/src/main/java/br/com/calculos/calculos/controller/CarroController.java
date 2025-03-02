package br.com.calculos.calculos.controller;

import br.com.calculos.calculos.entity.Carro;
import br.com.calculos.calculos.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carro")
public class CarroController {
    @Autowired
    private CarroService carroService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Carro carro){
        try {
            String message = this.carroService.save(carro);
            return new ResponseEntity<String>(message, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("Algo deu errado ao salvar!", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Carro> findById(@PathVariable int id) {
        try {
            Carro carro = this.carroService.findById(id);
            return new ResponseEntity<Carro>(carro, HttpStatus.OK);
        } catch (Exception e){
            //TODO: handle exception
            return new ResponseEntity<Carro>((Carro) null, HttpStatus.BAD_REQUEST);
        }
    }
}
