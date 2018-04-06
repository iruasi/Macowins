package main.java.Domain;

public class Promocion implements Estado{
	private double disminucionPromo;

	public Promocion(double disminucionPromo){
		this.disminucionPromo = disminucionPromo;
	}
	
	public double precio(double precioBase) {
		return precioBase - disminucionPromo;
	}
}
