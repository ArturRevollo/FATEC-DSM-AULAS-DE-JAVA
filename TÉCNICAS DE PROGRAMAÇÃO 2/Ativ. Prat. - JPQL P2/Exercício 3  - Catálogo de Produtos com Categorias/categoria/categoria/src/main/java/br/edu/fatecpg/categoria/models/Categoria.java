package br.edu.fatecpg.categoria.models;

import br.edu.fatecpg.categoria.enums.CategoriaTipo;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    private CategoriaTipo tipo;
    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Produto> produtos=new ArrayList<>();

    public Categoria() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public CategoriaTipo getTipo() {
        return tipo;
    }

    public void setTipo(CategoriaTipo tipo) {
        this.tipo = tipo;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(Produto produtos) {
        produtos.setCategoria(this);
        this.produtos.add(produtos) ;
    }

    public Categoria(CategoriaTipo tipo) {
        this.tipo = tipo;
        this.nome = tipo.getNome();
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", tipo=" + tipo +
                ", produtos=" + produtos +
                '}';
    }
}
