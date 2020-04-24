package utn.frsf.isi.died2020.tp07.servicios;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Supplier;
import java.util.stream.IntStream;

import utn.frsf.isi.died2020.tp07.excepciones.AdquisicionException;
import utn.frsf.isi.died2020.tp07.modelo.Curso;
import utn.frsf.isi.died2020.tp07.modelo.Libro;
import utn.frsf.isi.died2020.tp07.modelo.Material;
import utn.frsf.isi.died2020.tp07.modelo.Usuario;
import utn.frsf.isi.died2020.tp07.modelo.Video;

public class Registro {
	
	public enum Plan { GRATIS,BASE,PREMIUM};
	private Set<Usuario> usuarios = new LinkedHashSet<>();
	
	private Set<Usuario> usuarios2 = new LinkedHashSet<Usuario>();
	
	public void registrarGratuito(String nombre) {
		Usuario aux = new Usuario();
		aux.setCorreoElectronico(nombre);
		aux.setPuedeAdquirirLibro(u -> u.librosAdquiridos()<1);
		aux.setPuedeAdquirirVideo(u -> u.minutos()<30);
		aux.setPuedeAdquirirCurso(u -> false);

		aux.setCostoCurso( (u,c) -> 0.0 );
		aux.setCostoVideo( (u,c) -> 0.0 );
		aux.setCostoLibro( (u,c) -> 0.0 );
		this.usuarios2.add(aux);
	}

	public void registrarPremium(String nombre,String tarjeta) {
		Usuario aux = new Usuario();
		aux.setCorreoElectronico(nombre);
		aux.setTarjetaCredito(tarjeta);

		aux.setPuedeAdquirirLibro(u -> true);
		aux.setPuedeAdquirirVideo(u -> true);
		aux.setPuedeAdquirirCurso(u -> true);
		
		aux.setCostoCurso( (u,c) -> u.cursosAdquiridos()<1 ? 0.0 : c.precio() * 0.8 );
		aux.setCostoVideo( (u,c) -> u.minutos()<5 ? 0.0 : c.getDuracion()/50 * 0.1);
		aux.setCostoLibro( (u,c) -> u.librosAdquiridos()<2 ? 0.0 : c.getPaginas()/50 * 0.10 );

		this.usuarios2.add(aux);
	}
	
	public void registrarPremium(Usuario aux ,String tarjeta) {
		aux.setTarjetaCredito(tarjeta);

		aux.setPuedeAdquirirLibro(u -> true);
		aux.setPuedeAdquirirVideo(u -> true);
		aux.setPuedeAdquirirCurso(u -> true);
		
		aux.setCostoCurso( (u,c) -> u.cursosAdquiridos()<1 ? 0.0 : c.precio() * 0.8 );
		aux.setCostoVideo( (u,c) -> u.minutos()<5 ? 0.0 : c.getDuracion()/50 * 0.1);
		aux.setCostoLibro( (u,c) -> u.librosAdquiridos()<2 ? 0.0 : c.getPaginas()/50 * 0.10 );
	}
	
	public void adquirir(String correo,Material m) {
		
		Optional<Usuario> user2 = this.usuarios2
										.stream()
										.filter( u -> u.getCorreoElectronico().equalsIgnoreCase(correo))
										.findAny();
	
		if(user2.isPresent()) {
			try {
				user2.get().adquirir(m);
			} catch (AdquisicionException e) {
				System.out.println("NO se pudo adquirir, revise sus datos. Detalle : "+e.getMessage());
			}
		}
	}
	
	public Usuario buscar(String correo) {
		Optional<Usuario> user2 = this.usuarios2
				.stream()
				.filter( u -> u.getCorreoElectronico().equalsIgnoreCase(correo))
				.findAny();
		if(user2.isPresent()) return user2.get();
		else return null;
	}

	public void imprimirAdquisiciones(String correo) {
		Optional<Usuario> user2 = this.usuarios2
				.stream()
				.filter( u -> u.getCorreoElectronico().equalsIgnoreCase(correo))
				.findAny();

			if(user2.isPresent()) {
				user2.get().getAdquisiciones()
							.stream()
							.forEach(a -> System.out.println("Tit: "+a.getMaterial().getTitulo()+" : $"+a.getPrecio()));
			}
	}
}
