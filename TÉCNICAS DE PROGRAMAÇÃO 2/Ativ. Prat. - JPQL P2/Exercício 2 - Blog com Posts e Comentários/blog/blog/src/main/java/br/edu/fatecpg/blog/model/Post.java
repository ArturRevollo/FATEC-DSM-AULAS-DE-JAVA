package br.edu.fatecpg.blog.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Entity
    @Table (name="posts")
    public class Post {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String titulo;
        private String conteudo;

        @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
        private List<Comentario> comentarios = new ArrayList<>();

        public Post(String titulo, String conteudo) {
            this.titulo = titulo;
            this.conteudo = conteudo;
        }

        // getters e setters

        public void setComentarios(Comentario comentario) {
            comentario.setPost(this);
            this.comentarios.add(comentario);
        }

        @Override
        public String toString() {
            return "Post{" +
                    "id=" + id +
                    ", titulo='" + titulo + '\'' +
                    ", conteudo='" + conteudo + '\'' +
                    ", comentarios='" + comentarios +
                    '}';

        }
    }
