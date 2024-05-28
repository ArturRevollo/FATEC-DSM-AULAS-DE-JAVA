package br.edu.fatecpg.categoria;

import br.edu.fatecpg.categoria.enums.CategoriaTipo;
import br.edu.fatecpg.categoria.models.Categoria;
import br.edu.fatecpg.categoria.models.Produto;
import br.edu.fatecpg.categoria.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CategoriaApplication implements CommandLineRunner {
	@Autowired
	private CategoriaRepository CategoriaRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;

	public static void main(String[] args) {
		SpringApplication.run(CategoriaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria categoria1 = new Categoria(CategoriaTipo.ELETRONICOS);
		Categoria categoria2 = new Categoria(CategoriaTipo.LIVROS);

		Produto produto1 = new Produto("Notebook", 2999);
		Produto produto2 = new Produto("Xbox", 4000);
		Produto produto3 = new Produto("Livro1", 50);
		Produto produto4 = new Produto("Livro2", 500);

		//categoria1.setProdutos(produto1);
		//categoria1.setProdutos(produto2);
		//categoriaRepository.save(categoria1);

		//categoria2.setProdutos(produto3);
		//categoria2.setProdutos(produto4);
		//categoriaRepository.save(categoria2);

		categoriaRepository.findAll().forEach(System.out::println);
		System.out.println("------------------------------------------");

		categoriaRepository.findByTipo(CategoriaTipo.LIVROS).forEach(System.out::println);
		System.out.println("------------------------------------------");

		categoriaRepository.ProcurePelaPrimeiraLetra("E").forEach(System.out::println);

	}
}
