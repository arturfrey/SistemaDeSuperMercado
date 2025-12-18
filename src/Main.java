import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Estoque estoque = new Estoque();

        Produto banana = new Produto(1,"Banana",1.00,5000);
        Produto uva = new Produto(2,"Uva",0.50,5000);
        Produto feijao = new Produto(3,"Feijão",10.00,1000);

        estoque.cadastrarProduto(feijao);
        estoque.cadastrarProduto(banana);
        estoque.cadastrarProduto(uva);

        Pedido pedido = new Pedido();

        pedido.adicionaItem(estoque, banana, 5);
        pedido.adicionaItem(estoque, uva, 5);

        pedido.imprimePedido();
        pedido.imprimeValorTotal();

        System.out.println("O troco é: " + pedido.calculaTroco(16));

        pedido.calculaNotasTroco(90);
        pedido.calcularTrocoMoedas(18.75);

        System.out.println("ESTOQUE:");
        System.out.println("Uva: " + uva.getQuantidadeEmEstoque() + " unidades");
        System.out.println("Banana: " + banana.getQuantidadeEmEstoque() + " unidades");

        pedido = new Pedido();
        pedido.adicionaItem(estoque, banana, 5);
        pedido.adicionaItem(estoque, uva, 5);
        pedido.adicionaItem(estoque, feijao, 5);

        pedido.imprimePedido();
        pedido.imprimeValorTotal();

        System.out.println("O troco é: " + pedido.calculaTroco(100));

        pedido.calculaNotasTroco(42.5);
        pedido.calcularTrocoMoedas(42.5);

        System.out.println(estoque.getPosicaoDaLista(banana));
    }}
