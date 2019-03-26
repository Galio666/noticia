package uacm.edu.mx.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uacm.edu.mx.Repository.ComentarioRepository;
import uacm.edu.mx.model.Comentario;

@RequestMapping(value = "/api")
@RestController

public class ComentarioController {
	@Autowired
	ComentarioRepository comentarioRepository;

	@GetMapping(value = "/comentario")
	public List<Comentario> allComents() {

		List<Comentario> comentarios = new ArrayList<Comentario>();
		return comentarios;
	}

	@GetMapping(value = "/comentario/id")
	Comentario getComentario(@PathVariable String id) {

		Date date = new Date(2019-03-01);

		Comentario comen = new Comentario(date, "Prueba de comentario");
		return comen;
	}

}
