package br.com.ada.model;

public class Orcamento {
    private Double max;
    private Double min;

    public Orcamento(Double max, Double min) {
        this.max = max;
        this.min = min;
    }

    public Double getMax() {
        return max;
    }

    public void setMax(Double max) {
        this.max = max;
    }

    public Double getMin() {
        return min;
    }

    public void setMin(Double min) {
        this.min = min;
    }
}
