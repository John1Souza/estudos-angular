package br.com.calculos.controller;

import br.com.calculos.entity.Livro;
import br.com.calculos.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping("/cadastrar")
    public ResponseEntity<String> cadastrar(@RequestBody Livro livro) {
        try {
            String livro1 = this.livroService.cadastrarLivro(livro);
            return new ResponseEntity<String>(livro1, HttpStatus.OK);
        } catch (Exception e){
            //TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Livro> editar(@PathVariable int id, Livro livro) {
        try {
            Livro livro1 = this.livroService.editarLivro(id, livro);
            return new ResponseEntity<Livro>(livro1, HttpStatus.OK);
        } catch (Exception e){
            //TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
