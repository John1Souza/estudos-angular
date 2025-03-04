package app.controller;

import app.model.entity.Carro;
import app.model.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carro")
public class CarroController {

    @Autowired
    private CarroService carroService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Carro carro) {
        try {
            String message = this.carroService.save(carro);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch (Exception e){
            //TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable long id,@RequestBody Carro carro) {
        try {
            String message = this.carroService.update(id, carro);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch (Exception e){
            //TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable long id){
        try {
            String message = this.carroService.delete(id);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch (Exception e){
            //TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Carro>> findAll(){
        try {
            List<Carro> listaCarros = this.carroService.findAll();
            return new ResponseEntity<>(listaCarros, HttpStatus.OK);
        } catch (Exception e){
            //TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Carro> findById(@PathVariable long id){
        try {
            Carro carro = this.carroService.findById(id);
            return new ResponseEntity<>(carro, HttpStatus.OK);
        } catch (Exception e){
            //TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findByName")
    public ResponseEntity<List<Carro>> findByName(@RequestParam String name){
        try {
            List<Carro> listaCarros = this.carroService.findByName(name);
            return new ResponseEntity<>(listaCarros, HttpStatus.OK);
        } catch (Exception e){
            //TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findByMarca")
    public ResponseEntity<List<Carro>> findByMarca(@RequestParam long idMarca){
        try {
            List<Carro> listaCarros = this.carroService.findByMarca(idMarca);
            return new ResponseEntity<>(listaCarros, HttpStatus.OK);
        } catch (Exception e){
            //TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findAcimaAno")
    public ResponseEntity<List<Carro>> findAcimaAno(@RequestParam int year){
        try {
            List<Carro> listaCarros = this.carroService.findAcimaAno(year);
            return new ResponseEntity<>(listaCarros, HttpStatus.OK);
        } catch (Exception e){
            //TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
