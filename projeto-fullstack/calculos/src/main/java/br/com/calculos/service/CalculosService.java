package br.com.calculos.service;

import br.com.calculos.entity.Entrada;
import br.com.calculos.entity.Resultado;
import br.com.calculos.repository.CalculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculosService {
    @Autowired
    private CalculoRepository calculoRepository;

    public List<Resultado> findAll(){
        return this.calculoRepository.findAll();
    }

    public Resultado calcular(Entrada entrada) {
        Resultado resultado = new Resultado();
        Integer soma = 0;
        Integer maior = 0;
        Integer menor = 0;
        Integer totalLista = 0;

        if(entrada.getLista() != null) {
            for (int i = 0; i < entrada.getLista().size(); i++) {
                soma += entrada.getLista().get(i);
                if (i == 0) {
                    maior = entrada.getLista().get(i);
                    menor = entrada.getLista().get(i);
                } else {
                    if (entrada.getLista().get(i) > maior) {
                        maior = entrada.getLista().get(i);
                    }

                    if (entrada.getLista().get(i) < menor) {
                        menor = entrada.getLista().get(i);
                    }
                }
            }
        }

//        maior = entrada.getLista().stream().max(Integer::compareTo).orElseThrow(() -> new RuntimeException("Lista vazia"));
//        menor = entrada.getLista().stream().min(Integer::compareTo).orElseThrow(() -> new RuntimeException("Lista vazia"));
        totalLista = entrada.getLista().size();
        Double media = (double)(soma / entrada.getLista().size());
        resultado.setMedia(media);
        resultado.setSoma(soma);
        resultado.setTotal(totalLista);
        resultado.setMaior(maior);
        resultado.setMenor(menor);
        return resultado;
    }
}
