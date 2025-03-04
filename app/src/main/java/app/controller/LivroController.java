package app.controller;

import app.model.entity.Livro;
import app.model.service.LivroService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livro")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping("/findAll")
    public ResponseEntity<List<Livro>> findAll(){
        try {
            List<Livro> livroEncontrado = this.livroService.findAll();
            return new ResponseEntity<>(livroEncontrado, HttpStatus.OK);
        } catch (Exception e){
            //TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Livro livro){
        try {
            String livroSalvo = this.livroService.save(livro);
            return new ResponseEntity<>(livroSalvo, HttpStatus.OK);
        } catch (Exception e){
            //TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable long id, @RequestBody Livro livro){
        try {
            String livroAtualizado = this.livroService.update(id, livro);
            return new ResponseEntity<>(livroAtualizado, HttpStatus.OK);
        } catch (Exception e){
            //TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable long id){
        try {
            String livroExcluido = this.livroService.delete(id);
            return new ResponseEntity<>(livroExcluido, HttpStatus.OK);
        } catch (Exception e){
            //TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }


}
