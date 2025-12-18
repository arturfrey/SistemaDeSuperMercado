import java.util.Scanner;

public class Menu {

    private Estoque estoque;
    private Pedido pedido;
    private Scanner sc;

    public Menu() {
        estoque = new Estoque();
        pedido = new Pedido();
        sc = new Scanner(System.in);
    }

    public void controlaMenu() {
        int opcao;
        do {System.out.println("Digite um número:\n1-Imprime catálogo do estoque\n2-Cria um pedido\n3-Sair");

            opcao = sc.nextInt();

            switch (opcao) {
                case 1 -> estoque.imprimeCatalogoDoEstoque();
                case 2 -> fazerPedido();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida");
            }

        } while (opcao != 0);
    }

    private void fazerPedido() {
        char continuar;

        do {estoque.imprimeCatalogoDoEstoque();

            System.out.print("Digite o ID do produto: ");
            int id = sc.nextInt();

            Produto produto = estoque.encontraProduto(id);

            System.out.print("Quantidade: ");
            int quantidade = sc.nextInt();

            boolean sucesso = pedido.adicionaItem(estoque, produto, quantidade);

            if (sucesso) {
                System.out.println("Item adicionado ao pedido.");
            }

            System.out.print("Deseja adicionar outro produto? (s/n): ");
            continuar = sc.next().toLowerCase().charAt(0);

        } while (continuar == 's');

        pedido.imprimePedido();
    }

}
