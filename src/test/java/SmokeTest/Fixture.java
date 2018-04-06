package SmokeTest;
import Domain.*;

public class Fixture {
	
	public Prenda camisaCualquiera() {
		return new Prenda(1, TipoPrenda.Camisa, new Nueva());
	}
	
	public Prenda camisaNueva(double precioBase) {
		return new Prenda(precioBase, TipoPrenda.Camisa, new Nueva());
	}

	public Prenda camisaPromocion(double precioBase, double restaPromo) {
		return new Prenda(precioBase, TipoPrenda.Camisa, new Promocion(restaPromo));
	}

	public Prenda camisaLiquidacion(double precioBase) {
		return new Prenda(precioBase, TipoPrenda.Camisa, new Liquidacion());
	}
}
