package br.com.estoque;

public class EstoqueProduto {

    private String nomeProduto;
    private int quantidadeAtual;

    /**
     * Construtor da classe EstoqueProduto.
     *
     * @param nomeProduto      O nome do produto.
     * @param quantidadeInicial A quantidade inicial em estoque.
     * @throws IllegalArgumentException Se a quantidade inicial for negativa.
     */
    public EstoqueProduto(String nomeProduto, int quantidadeInicial) {
        if (quantidadeInicial < 0) {
            throw new IllegalArgumentException("Quantidade inicial não pode ser negativa.");
        }
        this.nomeProduto = nomeProduto;
        this.quantidadeAtual = quantidadeInicial;
    }

    /**
     * Adiciona uma quantidade ao estoque.
     *
     * @param quantidade A quantidade a ser adicionada.
     * @throws IllegalArgumentException Se a quantidade for menor ou igual a zero.
     */
    public void adicionar(int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade a adicionar deve ser maior que zero.");
        }
        this.quantidadeAtual += quantidade;
    }

    /**
     * Remove uma quantidade do estoque.
     *
     * @param quantidade A quantidade a ser removida.
     * @throws IllegalArgumentException    Se a quantidade for menor ou igual a zero.
     * @throws EstoqueInsuficienteException Se a remoção resultar em estoque negativo.
     */
    public void remover(int quantidade) throws EstoqueInsuficienteException {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade a remover deve ser maior que zero.");
        }

        if ((this.quantidadeAtual - quantidade) < 0) {
            throw new EstoqueInsuficienteException("Estoque insuficiente. Tentativa de remover " +
                    quantidade + " quando há apenas " + this.quantidadeAtual + ".");
        }

        this.quantidadeAtual -= quantidade;
    }

    /**
     * Retorna a quantidade atual de itens no estoque.
     *
     * @return A quantidade atual.
     */
    public int getQuantidadeAtual() {
        return this.quantidadeAtual;
    }

    // Getter para o nome (opcional, mas bom para testes)
    public String getNomeProduto() {
        return nomeProduto;
    }
}