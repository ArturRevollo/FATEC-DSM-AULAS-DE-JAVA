package br.edu.fatecpg.categoria.repository;

import br.edu.fatecpg.categoria.enums.CategoriaTipo;
import br.edu.fatecpg.categoria.models.Categoria;
import jdk.jfr.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    List<Categoria> findByTipo(CategoriaTipo type);

    @Query("SELECT c FROM Categoria c WHERE LEFT(c.nome, 1) = :letra")
    List<Categoria> ProcurePelaPrimeiraLetra(String letra);
}
