package br.com.calculos.service;

import br.com.calculos.entity.Livro;
import org.springframework.stereotype.Service;

@Service
public class LivroService {

    public String cadastrarLivro(Livro livro) {
        return "livro cadastrado com sucesso";
    }

    public Livro editarLivro(int id, Livro livro) {
        if (id == 1) {
            livro.setAutor("Tolkien");
            livro.setEditora("Abril");
            livro.setAnoPublicacao(2000);
            livro.setTitulo("M.P.");
            return livro;
        } else {
            return null;
        }
    }
}
