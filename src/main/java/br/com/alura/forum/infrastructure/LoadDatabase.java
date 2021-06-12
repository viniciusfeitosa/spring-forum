package br.com.alura.forum.infrastructure;

import br.com.alura.forum.modelo.Curso;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.modelo.Usuario;
import br.com.alura.forum.repositories.CursoRepository;
import br.com.alura.forum.repositories.TopicoRepository;
import br.com.alura.forum.repositories.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(UsuarioRepository usuarioRepository, CursoRepository cursoRepository, TopicoRepository topicoRepository) {
        return args -> {
            usuarioRepository.save(new Usuario("Aluno", "aluno@email.com", "$2a$10$ZD9X0j.l7i3uX0nxZOT0eO.sve8laqihhtq5FP4quFmvlAxATaym6"));
            usuarioRepository.findAll().forEach(usuario -> log.info("Preloaded " + usuario));

            var c1 = new Curso("Spring Boot", "Programação");
            var c2 = new Curso("HTML 5", "Front-end");
            cursoRepository.save(c1);
            cursoRepository.save(c2);
            cursoRepository.findAll().forEach(curso -> log.info("Preloaded " + curso));

            topicoRepository.save(new Topico("Dúvida", "Erro ao criar projeto", c1));
            topicoRepository.save(new Topico("Dúvida 2", "Projeto não compila", c1));
            topicoRepository.save(new Topico("Dúvida 3", "Tag HTML", c2));
            topicoRepository.findAll().forEach(topico -> log.info("Preloaded " + topico));
        };
    }
}
