package main.java.Repositorio;
import java.util.ArrayList;
import main.java.Domain.Venta;

public final class RepositorioVentas {
	ArrayList<Venta> ventas = new ArrayList<>();
	private static RepositorioVentas repositorioDeVentas;

	static {
		repositorioDeVentas = new RepositorioVentas();
	}

	public static RepositorioVentas getRepositorio() {
		return repositorioDeVentas;
	}

	public double gananciasDia() {
		return ventas.stream().mapToDouble(venta -> venta.precioVenta()).sum();
	}

	public void registrarVenta(Venta unaVenta) {
		ventas.add(unaVenta);
	}

	public Venta getUltimaVenta() {
		return ventas.get(ventas.size() - 1);
	}
}
