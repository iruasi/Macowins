package main.java.Domain;

public class Credito implements FormaDePago{
	
	double coeficientePorCuota;
	double razonCredito;
	int cuotas;

	public Credito(int cuotas, double coefCuota){
		razonCredito = 0.01;
		this.coeficientePorCuota = coefCuota;
		this.cuotas = cuotas;
	}
	
	public double precio(double precioBase) {
		return razonCredito * precioBase + cuotas * coeficientePorCuota;
	}
}
