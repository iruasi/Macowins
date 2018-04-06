package main.java.Domain;

public class Liquidacion implements Estado{

	public double precio(double precioBase) {
		return precioBase * 0.5;
	}
}
