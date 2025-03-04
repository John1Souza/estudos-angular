package app.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int anoPublicacao;

    @ManyToOne(cascade = CascadeType.ALL)
    private Editora editora;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "livro_proprietario")
    private List<ProprietarioLivro> proprietarioList;
}
