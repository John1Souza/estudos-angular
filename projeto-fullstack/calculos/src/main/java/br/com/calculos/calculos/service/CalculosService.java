package service;

import entity.Entrada;
import entity.Resultado;
import org.springframework.stereotype.Service;

@Service
public class CalculosService {

    public Resultado somar(Entrada entrada) {
        Resultado resultado = new Resultado();
        Integer soma = 0;
        if(entrada.getLista() != null){
            for(int i=0; i < entrada.getLista().size(); i++){
                soma += entrada.getLista().get(i);
            }
        }
        resultado.setSoma(soma);
        return resultado;
    }
}
