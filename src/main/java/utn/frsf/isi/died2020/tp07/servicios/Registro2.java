package utn.frsf.isi.died2020.tp07.servicios;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import utn.frsf.isi.died2020.tp07.excepciones.AdquisicionException;
import utn.frsf.isi.died2020.tp07.modelo.Material;
import utn.frsf.isi.died2020.tp07.modelo2.clasico.Usuario2;
import utn.frsf.isi.died2020.tp07.modelo2.clasico.UsuarioGratuito;
import utn.frsf.isi.died2020.tp07.modelo2.clasico.UsuarioPremium;

public class Registro2 {
	
	private Set<Usuario2> usuarios2 = new LinkedHashSet<Usuario2>();
	
	public void registrarGratuito(String nombre) {
		Usuario2 aux = new UsuarioGratuito();
		aux.setCorreoElectronico(nombre);
		this.usuarios2.add(aux);
	}

	public void registrarPremium(String nombre,String tarjeta) {
		UsuarioPremium aux = new UsuarioPremium();
		aux.setCorreoElectronico(nombre);
		aux.setTarjetaCredito(tarjeta);
		this.usuarios2.add(aux);
	}
	
	public void adquirir(String correo,Material m) {
		
		Optional<Usuario2> user2 = this.usuarios2
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

	public void imprimirAdquisiciones(String correo) {
		Optional<Usuario2> user2 = this.usuarios2
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
