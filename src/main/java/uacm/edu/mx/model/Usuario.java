package uacm.edu.mx.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class Usuario {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	@Size(min = 4, max = 30)
	@NotBlank
	private String nombre;
	@Size(min = 4, max = 25)
	@NotBlank
	private String apellidoP;
	@Size(min = 4, max = 25)
	@NotBlank
	private String apellidoM;
	@Email
	@Size(min = 4, max = 25)
	@NotBlank
	private String correo;

	@Size(min = 4, max = 25)
	@NotBlank
	private String pass;
	@Size(min = 4, max = 25)
	@NotBlank
	private String nickname;

	public Usuario() {

	}

	public Usuario(Long id,String nombre, String apellidoP, String apellidoM, String correo, String pass,
			String nickname) {

		this.id=id;
		this.nombre = nombre;
		this.apellidoP = apellidoP;
		this.apellidoM = apellidoM;
		this.correo = correo;
		this.pass = pass;
		this.nickname = nickname;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoP() {
		return apellidoP;
	}

	public void setApellidoP(String apellidoP) {
		this.apellidoP = apellidoP;
	}

	public String getApellidoM() {
		return apellidoM;
	}

	public void setApellidoM(String apellidoM) {
		this.apellidoM = apellidoM;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

}
