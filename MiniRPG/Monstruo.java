package MiniRPG;

import java.awt.*;

import javax.swing.*;

public class Monstruo extends Entidad {

	private int premioOro;
	private int premioExp;

	private JLabel etNombre, imagen;

	private static String[] nombresFacil = { "Monster Blue", "Ogre", "Viking" };
	private static String[] nombresMedio = { "Demon One", "Demon Two", "Demon Three" };
	private static String[] nombresDificil = { "Dragon", "Ghost", "Demonik" };

	private static final int IMAGEN_ANCHO = 200;
	private static final int IMAGEN_ALTO = 200;

	public Monstruo(String nombre, int ataque, int defensa, double vidaMax, String dificultad) {
		super(nombre, ataque, defensa, vidaMax);

		etNombre = new JLabel(nombre);
		etNombre.setFont(new Font("Roboto", Font.BOLD, 20));

		String rutaImg = "C:\\\\Users\\\\Gonzalo\\\\eclipse-workspace\\\\MiniJuego\\\\src\\\\MiniRPG\\\\assets\\\\image\\\\"
				+ nombre.toLowerCase() + ".png";
		imagen = new JLabel();
		ImageIcon icono = new ImageIcon(rutaImg);
		Image imagenEscalada = icono.getImage().getScaledInstance(IMAGEN_ANCHO, IMAGEN_ALTO, Image.SCALE_SMOOTH);
		icono = new ImageIcon(imagenEscalada);
		imagen.setIcon(icono);

		switch (dificultad) {
		case "facil":
			premioExp = (int) (Math.random() * 2 + 1);
			premioOro = (int) (Math.random() * 5 + 1);
			etNombre.setForeground(Color.GREEN);
			break;

		case "medio":
			premioExp = (int) (Math.random() * 6 + 2);
			premioOro = (int) (Math.random() * 20 + 1);
			etNombre.setForeground(Color.ORANGE);
			break;

		case "dificil":
			premioExp = (int) (Math.random() * 16 + 5);
			premioOro = (int) (Math.random() * 50 + 1);
			etNombre.setForeground(Color.RED);
			break;
		default:
			premioExp = 500;
			premioOro = 1000;
			etNombre.setForeground(Color.BLUE);
			break;
		}

	}

	public static Monstruo generaMonstruo(int i) {

		Monstruo m;

		int nMonstruo = (int) (Math.random() * 3);
		int nVida = (int) (Math.random() * 30);
		int nAtaque = (int) (Math.random() * 5);
		int nDefensa = (int) (Math.random() * 2);

		if (i < 80) {
			m = new Monstruo(nombresFacil[nMonstruo], nAtaque + 1, nDefensa, nVida + 15, "facil");
		} else if (i < 140) {
			m = new Monstruo(nombresMedio[nMonstruo], nAtaque + 4, nDefensa + 2, nVida + 30, "medio");
		} else if (i < 200) {
			m = new Monstruo(nombresDificil[nMonstruo], nAtaque + 8, nDefensa + 5, nVida + 80, "dificil");
		} else {
			m = new Monstruo("Jefe", nAtaque + 15, nDefensa + 10, nVida + 150, "jefe");
		}

		return m;

	}

	public int getPremioOro() {
		return premioOro;
	}

	public int getPremioExp() {
		return premioExp;
	}

	public JLabel getEtNombre() {
		return etNombre;
	}

	public JLabel getImagen() {
		return imagen;
	}

}
