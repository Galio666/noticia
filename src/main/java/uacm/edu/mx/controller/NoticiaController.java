package uacm.edu.mx.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uacm.edu.mx.Repository.NoticiaRepository;
import uacm.edu.mx.model.Noticia;

@RequestMapping(value = "/api")
@RestController
public class NoticiaController {

	public static final Logger log= LogManager.getLogger(NoticiaController.class);
	@Autowired
	NoticiaRepository noticiaRepository;

	/*@GetMapping(value = "/noticia")
	public List<Noticia> allNews() {
		List<Noticia> noticias = new ArrayList<Noticia>();
		return noticias;

	}*/
	
	
	@GetMapping(value = "/noticia")
	public List<Noticia> allNews() {
		List<Noticia> noticias= (List<Noticia>) noticiaRepository.findAll();
		return noticias;
	}
	
	
	@GetMapping(value="/noticia/agregar/{nombreNoticia}")
	public String addNoticia(@PathVariable String nombreNoticia) {
		log.debug("--------------------------------------------------");
		log.debug("Entrando al metodo agregar noticia");
		
		Noticia noticia=new Noticia(nombreNoticia, new Date(), "Notcia de  prueba", "tomas");
		Noticia noticiaReturn = noticiaRepository.save(noticia);
		return "Notica"+noticiaReturn.getTitulo()+"agregada";
	}
	

	
	

}
