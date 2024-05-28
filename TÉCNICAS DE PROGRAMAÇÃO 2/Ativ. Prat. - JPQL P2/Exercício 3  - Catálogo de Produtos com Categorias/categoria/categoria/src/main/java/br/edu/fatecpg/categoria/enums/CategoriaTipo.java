package br.edu.fatecpg.categoria.enums;

public enum CategoriaTipo {
    ELETRONICOS("Eletronico"),
    LIVROS("Livro"),
    ELETRODOMESTICOS("Eletrodomestico");

    private String nome;
    CategoriaTipo(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }

}
