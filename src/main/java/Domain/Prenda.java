package Domain;

public class Prenda {
	private double precioBase;
	private TipoPrenda tipo;
	private Estado estado;
	
	public Prenda(double precioBase, TipoPrenda tipo, Estado estado) {
		this.precioBase = precioBase;
		this.tipo = tipo;
		this.estado = estado;
	}
	
	public double consultarPrecio() {
		return estado.precio(precioBase);
	}
	
	public TipoPrenda consultarTipo() {
		return tipo;
	}
}
