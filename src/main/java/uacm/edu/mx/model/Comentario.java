package uacm.edu.mx.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="comentario")

public class Comentario {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;

	private Date fecha;
	@Size(min = 4, max = 30)
	@NotBlank
	private String texto;

	public Comentario() {

	}

	public Comentario( Date fecha, String texto) {

	
		this.fecha = fecha;
		this.texto = texto;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

}
