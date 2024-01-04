package MiniRPG;

public class Main {
	public static void main (String []args ) {
		Personaje heroe =  new Personaje ("Gonzalo", 60,20,80);
		
		VentanaInicio juego = new VentanaInicio (heroe);
		
		juego.comenzarJuego();
	}
}
