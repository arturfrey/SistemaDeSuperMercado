import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Estoque estoque = new Estoque();

        Produto banana = new Produto(1,"Banana",1.00,5000);
        Produto uva = new Produto(2,"Uva",1.00,5000);

        estoque.cadastrarProduto(banana);
        estoque.cadastrarProduto(uva);

        Pedido pedido = new Pedido();

        pedido.adicionaItem(estoque, 1, 5);
        pedido.adicionaItem(estoque, 2, 5);

        pedido.imprimePedido();
        pedido.imprimeValorTotal();

        System.out.println("O troco é: " + pedido.calculaTroco(16));



        System.out.println("ESTOQUE:");
        System.out.println("Uva: " + uva.getQuantidadeEmEstoque() + " unidades");
        System.out.println("Banana: " + banana.getQuantidadeEmEstoque() + " unidades");

        pedido.calcularTrocoMoedas(18.75);
    }}
