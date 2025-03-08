package calculoTest.service;

import calculoTest.entity.Entrada;
import calculoTest.entity.Saida;
import calculoTest.repository.EntradaRepository;
import calculoTest.repository.SaidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculoService {

    @Autowired
    private EntradaRepository entradaRepository;

    @Autowired
    private SaidaRepository saidaRepository;

    // CRUD Entrada
    public Entrada createEntrada(Entrada entrada) {
        return this.entradaRepository.save(entrada);
    }

    public List<Entrada> getAllEntradas() {
        return this.entradaRepository.findAll();
    }

    public Entrada getEntradaById(Long id) {
        return this.entradaRepository.findById(id).orElse(null);
    }

    public Entrada updateEntrada(Long id, Entrada entrada) {
        Entrada existing = getEntradaById(id);
        if (existing != null) {
            existing.setValor(entrada.getValor());
            return this.entradaRepository.save(existing);
        }
        return null;
    }

    public void deleteEntrada(Long id) {
        entradaRepository.deleteById(id);
    }

    // CRUD Saida
    public Saida createSaida(Saida saida) {
        return this.saidaRepository.save(saida);
    }

    public List<Saida> getAllSaidas() {
        return this.saidaRepository.findAll();
    }

    // Métodos de Cálculo
    public Saida calcular() {
        List<Entrada> entradas = getAllEntradas();
        if (entradas.isEmpty()) return null;

        Saida saida = new Saida();
        double soma = 0;
        double maior = entradas.get(0).getValor();
        double menor = entradas.get(0).getValor();

        for (Entrada entrada : entradas) {
            double valor = entrada.getValor();
            soma += valor;
            if (valor > maior) maior = valor;
            if (valor < menor) menor = valor;
        }

        double media = soma / entradas.size();

        saida.setSoma(soma);
        saida.setMedia(media);
        saida.setMaior(maior);
        saida.setMenor(menor);

        return saidaRepository.save(saida);
    }
    public String somar(List<Double> entradas) {
        if (entradas.isEmpty()) return null;

//        Saida saida = new Saida();
        double soma = 0;
        double maior = entradas.get(0);
        double menor = entradas.get(0);

        for (Double entrada: entradas) {
            double valor = entrada;
            soma += valor;
            if (valor > maior) maior = valor;
            if (valor < menor) menor = valor;
        }

        double media = soma / entradas.size();

//        saida.setSoma(soma);
//        saida.setMedia(media);
//        saida.setMaior(maior);
//        saida.setMenor(menor);

        return "Soma: " + soma + " ,Media: " + media +" ,Maior: " + maior + " ,Menor: " + menor;
    }
}
