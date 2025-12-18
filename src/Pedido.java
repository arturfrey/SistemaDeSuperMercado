import java.util.ArrayList;

public class Pedido {

    private ArrayList<Item> listaDeItens = new ArrayList<>();
    private double valorTotalDoPedido = 0;


    public boolean adicionaItemNaLista(Produto produto, int quantidade) {

        if (produto == null || quantidade <= 0) {
            return false;
        }

        Item item = new Item(produto, quantidade);
        item.defineValorTotal();


        listaDeItens.add(item);

        calculaValorTotal();

        return true;
    }


    public void calculaValorTotal() {
        valorTotalDoPedido = 0;

        for (Item item : listaDeItens) {
            valorTotalDoPedido += item.getValorDoItem();
        }
    }

    public void imprimePedido() {
        System.out.println("\n=== ITENS DO PEDIDO ===");
        for (Item item : listaDeItens) {
            System.out.println("Produto: " + item.getProduto().getNome() +
                    " | Quantidade: " + item.getQuantidade() +
                    " | Total item: R$ " + item.getValorDoItem());
        }
    }

    public void imprimeValorTotal() {
        System.out.println("Valor total do pedido: R$ " + valorTotalDoPedido);
    }


    public boolean adicionaItem(Estoque estoque, Produto produto, int quantidade) {

        Produto p = estoque.encontraProduto(produto.getId());

        if (p == null) {
            System.out.println("Produto não encontrado.");
            return false;
        }

        if (!estoque.temEstoqueOuNao(produto, quantidade)) {
            System.out.println("Estoque insuficiente.");
            return false;
        }

        adicionaItemNaLista(p, quantidade);

        estoque.darBaixaEmEstoque(p.getNome(), quantidade);

        return true;
    }

    public void limparCarrinho() {
        listaDeItens.clear();
        valorTotalDoPedido = 0;
    }

    public ArrayList<Item> getListaDeItens() {
        return listaDeItens;
    }

    public void setListaDeItens(ArrayList<Item> listaDeItens) {
        this.listaDeItens = listaDeItens;
    }

    public double getValorTotalDoPedido() {
        return valorTotalDoPedido;
    }

    public void setValorTotalDoPedido(double valorTotalDoPedido) {
        this.valorTotalDoPedido = valorTotalDoPedido;
    }


    //Questão b) e c):
    public double calculaTroco(double valorPago) {
        if (valorPago < valorTotalDoPedido) {
            System.out.println("Valor insuficiente.");
            return -1;
        }

        return valorPago - valorTotalDoPedido;
    }

    public void calculaNotasTroco(double troco) {

        int[] notas = {100, 50, 20, 10, 5, 2};

        int valor = (int) troco;

        System.out.println("Menor quantidade de notas para o troco:");

        for (int nota : notas) {
            int qtd = valor / nota;
            if (qtd > 0) {
                System.out.println("Nota de R$" + nota + ": " + qtd);
                valor %= nota;
            }
        }
    }

    public void calcularTrocoMoedas(double troco){

    int[] notas = {100, 50, 20, 10, 5, 2};

    int valor = (int) troco;

        System.out.println("Menor quantidade de notas/moedas para o troco:");

        for (int nota : notas) {
        int qtd = valor / nota;
        if (qtd > 0) {
            System.out.println("Nota de R$" + nota + ": " + qtd);
            valor %= nota;
        }}
    double[] moedas = {1.0, 0.50, 0.25, 0.10, 0.05};

        double centavos = (double) troco - (int) troco;

    if (valor == 1){centavos += 1.0;}

    for (double moeda : moedas) {
        double quantidade = centavos / moeda;
        int qtdd = (int) quantidade;
        if (qtdd > 0) {
            centavos %= moeda;
        }
        if (centavos >= 1.0) {
            System.out.println("Moeda de R$" + moeda + ": " + qtdd);
        }
        else{System.out.printf("Moeda de R$%.2f: %d\n", moeda, qtdd);}
    }


}
}

