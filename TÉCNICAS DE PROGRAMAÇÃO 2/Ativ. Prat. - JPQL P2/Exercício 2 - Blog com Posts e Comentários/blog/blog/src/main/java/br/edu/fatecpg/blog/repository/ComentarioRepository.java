package br.edu.fatecpg.blog.repository;

import br.edu.fatecpg.blog.model.Comentario;
import br.edu.fatecpg.blog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

}
