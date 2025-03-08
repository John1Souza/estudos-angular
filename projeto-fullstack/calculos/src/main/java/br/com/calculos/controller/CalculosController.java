package br.com.calculos.controller;

import br.com.calculos.entity.Entrada;
import br.com.calculos.entity.Resultado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.calculos.service.CalculosService;

import java.util.List;

@RestController
@RequestMapping("/calculos")
public class CalculosController {

    @Autowired
    private CalculosService calculosService;

    @GetMapping("/findAll")
    public ResponseEntity<List<Resultado>> findAll(@RequestBody Entrada entrada) {
        try {
            List<Resultado> resultado = this.calculosService.findAll(entrada);
            return new ResponseEntity<> (resultado, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
