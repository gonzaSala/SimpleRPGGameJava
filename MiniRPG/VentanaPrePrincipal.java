package MiniRPG;

import java.awt.*;

import javax.swing.*;

public class VentanaPrePrincipal {
	private JDialog marco;

	private JPanel panelPrincipal;

	private JButton btnSalir, btnAceptar;

	private JTextField nombre;
	private JComboBox<String> guerrero;

	private JLabel lblNombre;
	private JLabel lblGuerrero;
	private VentanaInicio vi;

	private Personaje pj;

	public VentanaPrePrincipal(VentanaInicio vi) {
		this.vi = vi;

		marco = new JDialog();

		panelPrincipal = new JPanel(new GridLayout(3, 2));

		btnSalir = new JButton("Salir");
		btnAceptar = new JButton("Aceptar");

		lblNombre = new JLabel("Nombre:");
		nombre = new JTextField();
		lblGuerrero = new JLabel("Tipo de Guerrero:");
		guerrero = new JComboBox<>(new String[] { "Guerrero 1", "Guerrero 2", "Guerrero 3" });

	}

	public void montarEscena() {

		panelPrincipal.add(lblNombre);
		panelPrincipal.add(nombre);
		panelPrincipal.add(lblGuerrero);
		panelPrincipal.add(guerrero);

		panelPrincipal.add(btnAceptar);
		panelPrincipal.add(btnSalir);

		btnAceptar.addActionListener(e -> iniciarJuego());
		btnSalir.addActionListener(e -> marco.dispose());

		marco.add(panelPrincipal);
		marco.setVisible(true);
		marco.setSize(600, 500);
		marco.setLocationRelativeTo(null);
		marco.setModal(true);

	}

	private void iniciarJuego() {
		String nombrePersonaje = nombre.getText(); 
		int ataqueBase = 0;
		int defensaBase = 0;
		int vidaBase = 0;

		String tipoGuerrero = (String) guerrero.getSelectedItem();
		switch (tipoGuerrero) {
		case "Guerrero 1":
			ataqueBase = 10;
			defensaBase = 5;
			vidaBase = 100;
			break;
		case "Guerrero 2":
			ataqueBase = 8;
			defensaBase = 8;
			vidaBase = 80;
			break;
		case "Guerrero 3":
			ataqueBase = 12;
			defensaBase = 3;
			vidaBase = 120;
			break;

		default:
			
			break;
		}
		pj = new Personaje(nombrePersonaje, ataqueBase, defensaBase, vidaBase);
		VentanaPrincipal vp = new VentanaPrincipal(pj);
		vp.ComenzarJuego();
		marco.dispose();
	}

}
