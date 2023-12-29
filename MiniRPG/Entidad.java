package MiniRPG;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JProgressBar;

public class Entidad implements IAtacable {
	private String nombre;
	private int vidaActual, ataque, defensa;
	private double vidaMax;
	private boolean estaVivo;
	private JProgressBar barraVida;

	public Entidad(String nombre, int ataque, int defensa, double vidaMax) {
		super();
		this.nombre = nombre;
		this.ataque = ataque;
		this.defensa = defensa;
		this.vidaMax = vidaMax;
		vidaActual = (int) vidaMax;
		estaVivo = true;
		barraVida = new JProgressBar(0, (int) vidaMax);
		barraVida.setPreferredSize(new Dimension(150, 20));
		establecerVida(vidaActual);

	}

	public void establecerVida(int vida) {
		barraVida.setValue(vida);
		barraVida.setForeground(Color.RED);
		barraVida.setStringPainted(true);
		barraVida.setString(vidaActual + "/" + (int) vidaMax);
	}

	@Override
	public void atacar(IAtacable enemigo) {
		enemigo.recibirHerida(ataque);
	}

	@Override
	public void recibirHerida(int cantidad) {
		if(estaVivo) {
			int cantidadTotal  = cantidad - defensa;
			if(cantidadTotal <= 0 )cantidadTotal = 1;
			vidaActual -= cantidadTotal;
			if(vidaActual <= 0) {
				estaVivo = false;
				vidaActual= 0;
					};
		}
	}

	public int getVidaActual() {
		return vidaActual;
	}

	public void setVidaActual(int vidaActual) {
		this.vidaActual = vidaActual;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public double getVidaMax() {
		return vidaMax;
	}

	public void setVidaMax(double vidaMax) {
		this.vidaMax = vidaMax;
	}

	public boolean isEstaVivo() {
		return estaVivo;
	}

	public void setEstaVivo(boolean estaVivo) {
		this.estaVivo = estaVivo;
	}

	public String getNombre() {
		return nombre;
	}

	public JProgressBar getBarraVida() {
		return barraVida;
	}

}
