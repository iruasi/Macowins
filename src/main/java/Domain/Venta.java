package Domain;
import Repositorio.RepositorioVentas;
import java.util.ArrayList;
import java.util.Date;

public class Venta {
	ArrayList<Item> items;
	Date fecha;
	double coefRecargo;
	FormaDePago formaPago;

	public Venta(double coefRecargo, FormaDePago formaPago){
		this.coefRecargo = coefRecargo;
		this.fecha = new Date();
		this.items = new ArrayList<>();
		this.formaPago = formaPago;
	}

	public void agregarPrenda(Prenda prenda) {
		items.add(new Item(prenda, 1));
	}
	
	public double precioVenta() {
		return items.stream()
				    .mapToDouble(item -> formaPago.precio(item.precio()))
				    .sum();
	}
	
	public void realizarVenta() {
		RepositorioVentas.getRepositorio().registrarVenta(this);
	}
}
