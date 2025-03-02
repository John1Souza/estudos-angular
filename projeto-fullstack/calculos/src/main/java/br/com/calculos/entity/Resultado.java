package br.com.calculos.entity;

public class Resultado {
    private Integer soma;
    private Double media;
    private Integer maior;
    private Integer menor;
    private Integer total;

    public Integer getSoma() {
        return soma;
    }

    public Integer getMaior() {
        return maior;
    }

    public void setMaior(Integer maior) {
        this.maior = maior;
    }

    public Integer getMenor() {
        return menor;
    }

    public void setMenor(Integer menor) {
        this.menor = menor;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public void setSoma (Integer soma) {
        this.soma = soma;
    }

    public Double getMedia() {
        return media;
    }

    public void setMedia(Double media) {
        this.media = media;
    }

    @Override
    public String toString() {
        return "Resultado {" +
                "soma=" + soma +
                ", media=" + media +
                '}';
    }
}
