package uacm.edu.mx.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.bytebuddy.asm.Advice.Return;
import uacm.edu.mx.Repository.UsuarioRepository;
import uacm.edu.mx.model.Usuario;

@RequestMapping(value = "/api")
@RestController

public class UserController {
	
	public static final Logger log= LogManager.getLogger(UserController.class);
	
	@Autowired
	UsuarioRepository usuarioRepository;

	/*
	 * @GetMapping(value="/user")
	 * 
	 * public Usuario Allsuario() {
	 * 
	 * Usuario user=new Usuario(1, "tomas", "ascencio", "hernandez",
	 * "ascencio847@gmail.com","1234" ,"teemoo66"); return user;
	 * 
	 * }
	 */
	
	
	@GetMapping(value = "/user/agregar/{nombre}/{apellidoP}")
	public String agregarUsuario(@PathVariable String nombre, @PathVariable String apellidoP) {
		
		log.debug("______________________________________________________");
		log.debug("-CON--------------Entrando al metodo agregarUsuario");
		
		Usuario usuario = new Usuario(new Long(1),nombre,apellidoP,"Hernandez","ascencio847@gmail.com","123456","tomas1991");
		Usuario usuarioReturn = usuarioRepository.save(usuario);
		return "Usuario"+ usuarioReturn.getNombre()+"agregado";
	}
	
	

	@GetMapping(value = "/user")
	public List<Usuario> allUser() {

		return (List<Usuario>) usuarioRepository.findAll();

	}

	/*
	@GetMapping(value = "/user/id")
	Usuario getUsuario(@PathVariable String id) {

		Usuario user = new Usuario(new Long(1),"tomas", "ascencio", "hernandez", "ascencio847@gmail.com", "1234", "teemoo66");

		return user;

	}
	*/
	
	@GetMapping(value = "/user/{id}")
	public Usuario getUsuario(@PathVariable String id) {
		
		Usuario usuarioReturn = usuarioRepository.findById_usuario(Long.parseLong(id));
		
		return usuarioReturn;
		
		
	}



}
