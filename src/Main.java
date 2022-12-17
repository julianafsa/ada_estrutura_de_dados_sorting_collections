import br.com.ada.domain.AnalisadorDePrecos;
import br.com.ada.model.Orcamento;
import br.com.ada.model.Produto;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<Produto> conjunto = new HashSet<>();
        List<Produto> lista = new ArrayList<>();

        Produto produto1 = new Produto("Produto1", "Produto 1", 20D);
        Produto produto2 = new Produto("Produto2", "Produto 2", 190D);
        Produto produto3 = new Produto("Produto3", "Produto 3", 200D);
        Produto produto4 = new Produto("Produto4", "Produto 4", 7D);
        Produto produto5 = new Produto("Produto5", "Produto 5", 12D);

        conjunto.add(produto1);
        conjunto.add(produto2);
        conjunto.add(produto3);
        conjunto.add(produto4);
        conjunto.add(produto5);

        lista.add(produto1);
        lista.add(produto2);
        lista.add(produto3);
        lista.add(produto4);
        lista.add(produto5);

        //Collections.sort(lista);

        Orcamento orcamento = new Orcamento(200d, 5d);
        AnalisadorDePrecos analisadorDePrecos = new AnalisadorDePrecos();
        List<Produto> produtos = analisadorDePrecos.analisar(lista, orcamento);
        produtos.forEach(System.out::println);
    }

}