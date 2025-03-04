package app.model.service;

import app.model.entity.Livro;
import app.model.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {
    @Autowired
    private LivroRepository livroRepository;

    public List<Livro> findAll() {
        return this.livroRepository.findAll();
    };

    public String save(Livro livro){
        this.livroRepository.save(livro);
        return "Livro salvo com sucesso!";
    }

    public String update(long id, Livro livro){
        livro.setId(id);
        this.livroRepository.save(livro);
        return "Livro atualizado com sucesso!";
    }
    public String delete(long id){
        Livro livro = new Livro();
        livro.setId(id);
        this.livroRepository.delete(livro);
        return "Livro excluido com sucesso!";
    }

}
