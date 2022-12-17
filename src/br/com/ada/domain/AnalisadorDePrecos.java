package br.com.ada.domain;

import br.com.ada.model.Orcamento;
import br.com.ada.model.Produto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AnalisadorDePrecos {

    public boolean cabeNoOrcamento(final Produto produto, final Orcamento orcamento) {
        boolean result = false;
        if (produto == null || orcamento == null) {
            System.out.println("Os parâmetros produto e orcamento não podem ser nulos");
            return false;
        }
        final Double preco = produto.getPreco();
        if (preco >= orcamento.getMin() && preco <= orcamento.getMax()) {
            result = true;
        }
        return result;
    }

    public List<Produto> analisar(List<Produto> produtos, Orcamento orcamento) {
        Collections.sort(produtos);
        final List<Produto> produtosCabemOrcamento = new ArrayList<>();
        Orcamento novoOrcamento = new Orcamento(orcamento.getMax(), orcamento.getMin());
        for (Produto produto : produtos) {
            if (this.cabeNoOrcamento(produto, novoOrcamento)) {
                produtosCabemOrcamento.add(produto);
                novoOrcamento.setMax(novoOrcamento.getMax() - produto.getPreco());
            }
        }
        return produtosCabemOrcamento;
    }
}
