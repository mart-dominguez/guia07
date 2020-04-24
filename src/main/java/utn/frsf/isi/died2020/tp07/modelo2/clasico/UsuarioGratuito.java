package utn.frsf.isi.died2020.tp07.modelo2.clasico;

import utn.frsf.isi.died2020.tp07.modelo.Curso;
import utn.frsf.isi.died2020.tp07.modelo.Libro;
import utn.frsf.isi.died2020.tp07.modelo.Usuario;
import utn.frsf.isi.died2020.tp07.modelo.Video;

public class UsuarioGratuito extends Usuario2{

	@Override
	public Double costoLibro(Libro l) {
		// TODO Auto-generated method stub
		return 0.0;
	}

	@Override
	public Double costoVideo(Video l) {
		// TODO Auto-generated method stub
		return 0.0;
	}

	@Override
	public Double costoCurso(Curso l) {
		// TODO Auto-generated method stub
		return 0.0;
	}

	@Override
	public Boolean puedeAdquirirLibro() {
		return this.cantidadLibro()<1;
	}

	@Override
	public Boolean puedeAdquirirVideo() {
		return this.minutosVideo()<30;
	}

	@Override
	public Boolean puedeAdquirirCurso() {
		return false;
	}

	
}
