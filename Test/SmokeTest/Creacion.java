package SmokeTest;

import Domain.*;
import Repositorio.RepositorioVentas;

import static org.junit.Assert.*;

import org.junit.Test;

public class Creacion {

	static Fixture fixture = new Fixture();

	@Test
	public void camisaNuevaDe400Vale400() {
		Prenda camisaNueva = fixture.camisaNueva(400.0);

		assertEquals(400.0, camisaNueva.consultarPrecio(), 0.1);
	}

	@Test
	public void camisaPromocionDe400Con50DescuentoVale350(){
		Prenda camisa = fixture.camisaPromocion(400.0, 50);

		assertEquals(350.0, camisa.consultarPrecio(), 0.1);
	}

	@Test
	public void tipoPrendaDeUnaCamisaEsUnaCamisa() {
		Prenda camisa = fixture.camisaCualquiera();

		assertSame(TipoPrenda.Camisa, camisa.consultarTipo());
	}

	@Test
	public void camisaLiquidacionDe400ValeLaMitad() {
		Prenda camisa = fixture.camisaLiquidacion(400.0);
		double mitadPrecio = 200.0;

		assertEquals(mitadPrecio, camisa.consultarPrecio(), 0.1);
	}

	@Test
	public void precioVentaDeCamisaCualquieraConEfectivoNoAlteraPrecioFinal() {
		Prenda camisa = fixture.camisaCualquiera();
		Venta venta = new Venta(0, new Efectivo());
		venta.agregarPrenda(camisa);

		assertEquals(camisa.consultarPrecio(), venta.precioVenta(), 0.1);
	}

	@Test
	public void precioVentaDeCamisaCualquieraConTarjetaAlteraPrecioFinal() {
		Prenda camisa = fixture.camisaNueva(400.0);
		Venta venta = new Venta(0, new Credito(12, 0.03));
		venta.agregarPrenda(camisa);
		double precioEsperado = 4.0 + 12 * 0.03;

		assertEquals(precioEsperado, venta.precioVenta(), 0.1);
	}

	@Test
	public void realizarUnaVentaLaRegistraEnElrepositorio() {
		RepositorioVentas elRepoVentas = RepositorioVentas.getRepositorio();
		Venta venta = new Venta(0, new Efectivo());
		venta.agregarPrenda(fixture.camisaCualquiera());
		
		venta.realizarVenta();
		assertSame(venta, elRepoVentas.getUltimaVenta());
	}

	@Test
	public void lasGananciasDelDiaConUnaVentaEsElPrecioDeLaVenta() {
		RepositorioVentas elRepoVentas = RepositorioVentas.getRepositorio();
		Venta venta = new Venta(0, new Efectivo());
		venta.agregarPrenda(fixture.camisaCualquiera());
		
		venta.realizarVenta();
		assertEquals(venta.precioVenta(), elRepoVentas.gananciasDia(), 0.1);
	}
}
