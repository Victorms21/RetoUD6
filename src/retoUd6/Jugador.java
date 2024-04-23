package retoUd6;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Jugador {
	
	
	private String nombre, arma, habitacion, horaPartida;
	
	public Jugador(String nombre, String arma, String habitacion) {
		this.nombre=nombre;
		this.arma=arma;
		this.habitacion=habitacion;
		horaPartida=LocalTime.now().truncatedTo(ChronoUnit.MINUTES).toString();
	}

	@Override
	public String toString() {
		return "Jugador[nombre=" + nombre + ",arma=" + arma + ",habitacion=" + habitacion + ",horaPartida=" + horaPartida + "]";
		
	}
	
}
