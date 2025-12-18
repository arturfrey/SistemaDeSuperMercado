import java.util.ArrayList;

public class Estoque {
    private int id = 1;
    private ArrayList<Produto> listaDeProdutos = new ArrayList<>();

    public Estoque() {
    }

    public void inicializarEstoque() {
        listaDeProdutos = new ArrayList<>();
    }

    public Produto encontraProduto(String nome) {
        for (Produto p : listaDeProdutos) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                return p;
            }
        }
        return null;
    }

    public Produto encontraProduto(int id) {
        for (Produto p : listaDeProdutos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public boolean cadastrarProduto(Produto produto) {
        if (produto == null)
            return false;
        if (encontraProduto(produto.getId()) != null)
            return false;
        listaDeProdutos.add(produto);
        return true;
    }

    public void imprimeCatalogoDoEstoque() {
        System.out.println("Catálogo do estoque:");
        for (Produto p : listaDeProdutos) {
            System.out.println(p);
        }
    }

    public boolean darBaixaEmEstoque(String nome, int quantidadeParaDarBaixa) {
        Produto p = encontraProduto(nome);
        if (p == null)
            return false;
        if (p.getQuantidadeEmEstoque() < quantidadeParaDarBaixa)
            return false;

        p.setQuantidadeEmEstoque(p.getQuantidadeEmEstoque() - quantidadeParaDarBaixa);
        return true;
    }

    public boolean darBaixaEmEstoqueNaId(int idProduto, int quantidadeParaDarBaixa) {
        Produto p = encontraProduto(idProduto);
        if (p == null)
            return false;
        if (p.getQuantidadeEmEstoque() < quantidadeParaDarBaixa)
            return false;

        p.setQuantidadeEmEstoque(p.getQuantidadeEmEstoque() - quantidadeParaDarBaixa);
        return true;
    }


    public int getQuantidadeAtualEmEstoque(Produto produto) {
        return produto.getQuantidadeEmEstoque();
    }

    public int getEstoqueDoProdutoNaId(int id) {
        Produto p = encontraProduto(id);
        return (p != null ? p.getQuantidadeEmEstoque() : 0);
    }

    public boolean temEstoqueOuNao(Produto produto, int quantidadeParaDarBaixa) {
        Produto p = encontraProduto(produto.getId());
        if (p == null) return false;

        return p.getQuantidadeEmEstoque() >= quantidadeParaDarBaixa;
    }

    public String getPosicaoDaLista(Produto produto) {
        int posicao = 0;
        for (Produto p : listaDeProdutos) {
            if (p.getNome().equalsIgnoreCase(produto.getNome())) {
                return produto.getNome() + " está na posiçao " + posicao + " do estoque";
            }
            posicao++;
        }
        return produto + "não existe no estoque!";
    }
    }




