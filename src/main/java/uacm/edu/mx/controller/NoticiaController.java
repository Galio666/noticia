package uacm.edu.mx.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uacm.edu.mx.Repository.NoticiaRepository;
import uacm.edu.mx.model.Comentario;
import uacm.edu.mx.model.Noticia;

@RequestMapping(value = "/api")
@RestController
public class NoticiaController {

	public static final Logger log= LogManager.getLogger(NoticiaController.class);
	@Autowired
	NoticiaRepository noticiaRepository;
	
	
	@PostMapping(value="/noticia")
	public Noticia addNoticia(@RequestBody Noticia noticia)  {
		log.debug("_______________________________________________________");
		log.debug("CON----------------------Entrando al metodo addNoticia");
		Noticia noticiaReturn =noticiaRepository.save(noticia);
		log.debug(noticiaReturn.toString());
		return noticiaReturn;
		
	}
	
	@PutMapping(value="/noticia")
	public Noticia updateNoticia(@RequestBody Noticia noticia) {
		
		log.debug("_________________________________________________");
		log.debug("CON----------Entrando al metodo updateNoticia");
		Noticia noticiaReturn =noticiaRepository.save(noticia);
		log.debug("Editando"+noticiaReturn.toString());
		return noticiaReturn;
	}

	@DeleteMapping(value="/noticia")
	public String deleteNoticia(@PathVariable String id) {
		noticiaRepository.deleteById(Long.parseLong(id));
		log.debug("Borrando notica"+id);
		return "Noticia Borrada";
		
	}
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
	
	
	
	
	/*
	@GetMapping(value="/noticia/agregar/{nombreNoticia}")
	public String addNoticia(@PathVariable String nombreNoticia) {
		log.debug("--------------------------------------------------");
		log.debug("Entrando al metodo agregar noticia");
		
		Noticia noticia=new Noticia(nombreNoticia, new Date(), "Notcia de  prueba", "tomas");
		Noticia noticiaReturn = noticiaRepository.save(noticia);
		return "Notica"+noticiaReturn.getTitulo()+"agregada";
	}*/
	
	@GetMapping(value = "/noticia/coemtatio/{comentario}")

    public String agregarComentario(@PathVariable String comentario) {

        log.debug("_______________________________________________________");

        log.debug("-CON--------------Entrando al metodo agregar comentario");

        /*

         * Este es el metodo para recueperar por medio del Id el metodo nativo de JPA,

         * el usuarioController nosotros mismos usamos un Query nativa.

         * 

         * Tambien si checan todos los comentarios se los estamos guardando

         * a la noticia con id 1 y si no agregamos una noticia no funciona

         * 

         * de tarea para que practiquen, igual desde la url enviar el id de noticas

         * para que se le agregue la noticia dependiendo el 1

         */

        Optional<Noticia> noticiaRetorn = noticiaRepository.findById(Long.parseLong("1"));

        if (noticiaRetorn == null) {

            return "Noticia no encontrada";

        }

        /*

         * Aqui les estamos agregando el comentario a la noticia

         * */

        noticiaRetorn.get().getComentarios().add(new Comentario(new Date(), comentario));

        noticiaRepository.save(noticiaRetorn.get());

        return "Comentario agregado";

	} 

	
	
	

}
