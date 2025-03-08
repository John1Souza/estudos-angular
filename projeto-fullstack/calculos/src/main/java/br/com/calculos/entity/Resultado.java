package br.com.calculos.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Resultado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Integer soma;
    private Double media;
    private Integer maior;
    private Integer menor;
    private Integer total;

    @Override
    public String toString() {
        return "Resultado {" +
                "soma=" + soma +
                ", media=" + media +
                '}';
    }
}
