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

    /**
     * Analisa se cada produto da lista cabe individualmente no orçamento e retorna uma lista com os produtos
     * que cabem no orçamento.
     * @param produtos Lista de produtos.
     * @param orcamento Orçamento.
     * @return A lista de produtos que cabem no orçamento.
     */
    public List<Produto> analisar(List<Produto> produtos, Orcamento orcamento) {
        Collections.sort(produtos);
        final List<Produto> produtosCabemOrcamento = new ArrayList<>();
        for (Produto produto : produtos) {
            if (this.cabeNoOrcamento(produto, orcamento)) {
                produtosCabemOrcamento.add(produto);
            }
        }
        return produtosCabemOrcamento;
    }

    /**
     * Analisa se cada produto da lista cabe no orçamento atualizando uma cópia do orçamento a cada
     * produto adicionado e retorna uma lista com os produtos que cabem no orçamento.
     * @param produtos Lista de produtos.
     * @param orcamento Orçamento.
     * @return A lista de produtos que cabem no orçamento.
     */
    public List<Produto> analisarEmConjunto(List<Produto> produtos, Orcamento orcamento) {
        Collections.sort(produtos);
        final List<Produto> produtosCabemOrcamento = new ArrayList<>();
        final Orcamento novoOrcamento = new Orcamento(orcamento.getMax(), orcamento.getMin());
        for (Produto produto : produtos) {
            if (this.cabeNoOrcamento(produto, novoOrcamento)) {
                produtosCabemOrcamento.add(produto);
                novoOrcamento.setMax(novoOrcamento.getMax() - produto.getPreco());
            }
        }
        return produtosCabemOrcamento;
    }

}
