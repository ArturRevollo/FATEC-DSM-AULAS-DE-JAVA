package br.edu.fatecpg.blog;

import br.edu.fatecpg.blog.model.Comentario;
import br.edu.fatecpg.blog.model.Post;
import br.edu.fatecpg.blog.repository.ComentarioRepository;
import br.edu.fatecpg.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import java.util.List;

@SpringBootApplication
public class BlogApplication implements CommandLineRunner {
	@Autowired
	private PostRepository postRepository;
	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
//		System.out.println("Funcionando");
	}

	@Override
	public void run(String... args) throws Exception {
		Post post1 = new Post("Como usar API", "API");
		Post post2 = new Post("Como programar em Java", "Java");

		Comentario comentario1 = new Comentario("Gostei do conteudo", "Bruno");
		Comentario comentario2 = new Comentario("Conteudo muito legal", "Artur");
		Comentario comentario3 = new Comentario("Show de bola", "Luccas");
		Comentario comentario4 = new Comentario("Legal! Amo Java", "Dutra");


		post1.setComentarios(comentario1);
		post1.setComentarios(comentario2);
//		postRepository.save(post1);

		post2.setComentarios(comentario3);
		post2.setComentarios(comentario4);
//		postRepository.save(post2);

//		Comentario comentario1 = new Comentario("Dutra", "interessante");
//		post1.setComentarios(comentario1);
//		postRepository.save(post1);
//
//		Comentario comentario2 = new Comentario("Luccas", "Adoravel");
//		post1.setComentarios(comentario2);
//		postRepository.save(post1);




		postRepository.findAll().forEach(System.out::println);
		System.out.println("------------------------------------");

		postRepository.findByTitulo("Como usar API").forEach(System.out::println);
		System.out.println("------------------------------------");

		List<Post> posts = postRepository.findByKeyword("API");
		posts.forEach(System.out::println);


		// Inserir mais posts e comentários conforme necessário
	}
}
