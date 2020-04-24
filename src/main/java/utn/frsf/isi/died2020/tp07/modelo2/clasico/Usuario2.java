package utn.frsf.isi.died2020.tp07.modelo2.clasico;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import utn.frsf.isi.died2020.tp07.excepciones.AdquisicionException;
import utn.frsf.isi.died2020.tp07.modelo.Adquisicion;
import utn.frsf.isi.died2020.tp07.modelo.Curso;
import utn.frsf.isi.died2020.tp07.modelo.Libro;
import utn.frsf.isi.died2020.tp07.modelo.Material;
import utn.frsf.isi.died2020.tp07.modelo.Video;

public abstract class Usuario2 {
	protected Integer id;
	protected String correoElectronico;
	protected Double gastos;
	
	private List<Adquisicion> adquisiciones = new ArrayList<Adquisicion>();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	public Double getGastos() {
		return gastos;
	}
	public void setGastos(Double gastos) {
		this.gastos = gastos;
	}
	public List<Adquisicion> getAdquisiciones() {
		return adquisiciones;
	}
	public void setAdquisiciones(List<Adquisicion> adquisiciones) {
		this.adquisiciones = adquisiciones;
	}
	public abstract Double costoLibro(Libro l);
	public abstract Double costoVideo(Video l);
	public abstract Double costoCurso(Curso l);

	public abstract Boolean puedeAdquirirLibro();
	public abstract Boolean puedeAdquirirVideo();
	public abstract Boolean puedeAdquirirCurso();
	
	public int cantidadLibro() {
		int cantidad = 0;
		for(Adquisicion a : adquisiciones) {
			if(a.getMaterial() instanceof Libro) cantidad++;
		}
		return cantidad;
	}
	
	public int cantidadCurso() {
		int cantidad = 0;
		for(Adquisicion a : adquisiciones) {
			if(a.getMaterial() instanceof Curso) cantidad++;
		}
		return cantidad;
	}

	public int minutosVideo() {
		int cantidad = 0;
		for(Adquisicion a : adquisiciones) {
			if(a.getMaterial() instanceof Video) cantidad+= ((Video)a.getMaterial()).getDuracion();
		}
		return cantidad;
	}
	
	public void adquirir(Material material) throws AdquisicionException {
		System.out.println("Adquiriendo material...");
		if(material.puedeAdquirir(this)) {
			this.adquisiciones.add(new Adquisicion(material, LocalDateTime.now(), material.costo(this)));
			System.out.println("Adquirido "+material.getTitulo()+" $"+material.costo(this));
		} else throw new AdquisicionException("no puede adquirir el material "+material.getTitulo());
	}


}
