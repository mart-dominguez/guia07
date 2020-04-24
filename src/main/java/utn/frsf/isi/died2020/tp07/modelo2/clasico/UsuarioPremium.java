package utn.frsf.isi.died2020.tp07.modelo2.clasico;

import utn.frsf.isi.died2020.tp07.modelo.Curso;
import utn.frsf.isi.died2020.tp07.modelo.Libro;
import utn.frsf.isi.died2020.tp07.modelo.Video;

public class UsuarioPremium extends Usuario2{
	private String tarjetaCredito;

	public String getTarjetaCredito() {
		return tarjetaCredito;
	}

	public void setTarjetaCredito(String tarjetaCredito) {
		this.tarjetaCredito = tarjetaCredito;
	}

	@Override
	public Double costoLibro(Libro l) {
		return this.cantidadLibro()<2? 0.0 : l.getPaginas()/50 * 0.10;
	}

	@Override
	public Double costoVideo(Video l) {
		return this.minutosVideo()<5? 0.0 : l.getDuracion()/50 * 0.10;
	}

	@Override
	public Double costoCurso(Curso l) {
		return this.cantidadCurso()<1 ? 0.0 : l.precio() * 0.8;
	}

	@Override
	public Boolean puedeAdquirirLibro() {
		return true;
	}

	@Override
	public Boolean puedeAdquirirVideo() {
		return true;
	}

	@Override
	public Boolean puedeAdquirirCurso() {
		return true;
	}

}
