package utn.frsf.isi.died2020.tp07.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Material implements Comparable<Material>{
	
	private static Integer _IDS = 1;

	protected Integer id;
	protected String titulo;
	protected LocalDateTime fechaPublicacion;
	protected Integer calificacion;
	protected Autor autor;
	protected List<Tema> temas;
	protected List<Adquisicion> adquisiciones;	
	
	public Material() {
		
	}
	
	public Material(String titulo, LocalDateTime fechaPublicacion, Integer calificacion, Autor autor,
			List<Tema> temas) {
		super();
		this.id = _IDS++;
		this.titulo = titulo;
		this.fechaPublicacion = fechaPublicacion;
		this.calificacion = calificacion;
		this.autor = autor;
		this.temas = temas;
		this.adquisiciones = new ArrayList<Adquisicion>();
	}

	public abstract Double costo(Usuario usuario);

	public abstract Boolean puedeAdquirir(Usuario usuario);
	
	public abstract Double rating();
	
	@Override
	public int compareTo(Material o) {
		return 0;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public List<Tema> getTemas() {
		return temas;
	}

	public void setTemas(List<Tema> temas) {
		this.temas = temas;
	}

	public List<Adquisicion> getAdquisiciones() {
		return adquisiciones;
	}

	public void setAdquisiciones(List<Adquisicion> adquisiciones) {
		this.adquisiciones = adquisiciones;
	}

	public LocalDateTime getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(LocalDateTime fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public Integer getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Integer calificacion) {
		this.calificacion = calificacion;
	}

	@Override
	public String toString() {
		return this.getClass().getCanonicalName()+ ";id=" + id + "; titulo=" + titulo + "; fechaPublicacion=" + fechaPublicacion + "; calificacion="
				+ calificacion + "; autor=" + autor.getNombre() + "; temas=" + temas;
	}
	
	
	
}
