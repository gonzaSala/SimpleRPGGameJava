package MiniRPG;

public class Main {
	public static void main (String []args ) {
		Personaje heroe =  new Personaje ("Gonzalo", 6,2,80);
		
		VentanaPrincipal juego = new VentanaPrincipal (heroe);
		
		juego.ComenzarJuego();
	}
}
