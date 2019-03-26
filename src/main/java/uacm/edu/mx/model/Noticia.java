package uacm.edu.mx.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "noticia")

public class Noticia {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long id;
	@Size(min = 4, max = 60)
	@NotBlank
	private String titulo;

	private Date fecha;
	@Size(min = 10, max = 600)
	@NotBlank
	private String Nota;
	@Size(min = 4, max = 30)
	@NotBlank
	private String Autor;
	
	@OneToMany(cascade =CascadeType.ALL,orphanRemoval=true)
	private List<Comentario> comentarios = new ArrayList<>();

	public Noticia() {

	}

	public Noticia(String titulo, Date fecha, String nota, String autor) {

		
		this.titulo = titulo;
		this.fecha = fecha;
		Nota = nota;
		Autor = autor;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getNota() {
		return Nota;
	}

	public void setNota(String nota) {
		Nota = nota;
	}

	public String getAutor() {
		return Autor;
	}

	public void setAutor(String autor) {
		Autor = autor;
	}
	
	public List<Comentario> getComentarios(){
		return comentarios;
		
		
	}

}
