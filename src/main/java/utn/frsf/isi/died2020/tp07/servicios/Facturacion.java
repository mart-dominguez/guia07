package utn.frsf.isi.died2020.tp07.servicios;

import java.util.List;
import java.util.Optional;

import utn.frsf.isi.died2020.tp07.modelo.Autor;
import utn.frsf.isi.died2020.tp07.modelo.Usuario;

public class Facturacion {
	
	Catalogo catalogo;

	public void pagar(Autor autor) {
		Optional<Autor> autorEncontrado = catalogo.getAutores()
							.filter( a -> a.getNombre().equalsIgnoreCase("martin"))
							.findFirst();
		
		if(autorEncontrado.isPresent()) {
			autorEncontrado.get().setComision(0.99);
		}

	}
	
	public void cobrar(Usuario usuario) {
	}
	
}
