package br.com.calculos.calculos.service;

import br.com.calculos.calculos.entity.Carro;
import org.springframework.stereotype.Service;

@Service
public class CarroService {
    public String save(Carro carro) {
        return "Carro salvo com sucesso";
    }

    public Carro findById(int id) {
        if (id == 1) {
            Carro carro = new Carro();
            carro.setMarca("Peugeot");
            carro.setAnoFabricacao(1990);
            carro.setNome("206");
            carro.setModelo("Hatch");
            return carro;
        } else {
            return null;
        }
    }
}
