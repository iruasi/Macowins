package Domain;

public class Item {
	private Prenda prenda;
	private int cantidad;
	
	public Item(Prenda prenda, int cant) {
		this.prenda = prenda;
		this.cantidad = cant;
	}
	
	double precio() {
		return prenda.consultarPrecio() * cantidad;
	}
}
