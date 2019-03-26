package uacm.edu.mx.model;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import uacm.edu.mx.Repository.NoticiaRepository;

@RunWith(SpringRunner.class)
@SpringBootTest

public class NoticiaTest {
	@Autowired
	NoticiaRepository noticiaRepository;

	@Test
	public void addNoticia() {

		Noticia noticia = new Noticia();
		noticia.setTitulo("Titulo Prueba");
		noticia.setAutor("Tomas Ascencio");
		noticia.setFecha(new Date());
		noticia.setNota("Prueba de Nota");
		
	    
		Noticia noticaReturn = noticiaRepository.save(noticia);
		
		Assert.assertThat(noticaReturn, is(notNullValue()));
	}

}
