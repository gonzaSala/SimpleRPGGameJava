package MiniRPG;

import java.awt.*;

import javax.swing.*;

import marcoPanelPersonalizado.framePer;

public class VentanaInicio {

	private framePer marco;

	private JLayeredPane layeredPane;

	private JPanel panelPrincipal, panelBotones;

	private JButton btnIniciar, btnOpciones, btnSalir;

	private JLabel img;

	private Personaje pj;

	public VentanaInicio(Personaje pj) {

		this.pj = pj;
		marco = new framePer(600, 500, "miniRPG", true);

		layeredPane = new JLayeredPane();

		panelPrincipal = new JPanel(new BorderLayout());
		panelBotones = new JPanel(new FlowLayout());

		btnIniciar = new JButton("Iniciar");
		btnOpciones = new JButton("Opciones");
		btnSalir = new JButton("Salir");

		img = new JLabel();

	}

	public void comenzarJuego() {
		mostrarEscena();
		marco.setVisible(true);
	}

	private void mostrarEscena() {
	    int anchoMarco = marco.getWidth();
	    int altoMarco = marco.getHeight();

	    ImageIcon imgPrincipal = new ImageIcon(
	            "C:\\Users\\Gonzalo\\eclipse-workspace\\MiniJuego\\src\\MiniRPG\\assets\\image\\imgPrincipal.jpg");
	    Image imagenOriginal = imgPrincipal.getImage();
	    Image imagenEscalada = imagenOriginal.getScaledInstance(anchoMarco, altoMarco, Image.SCALE_SMOOTH);
	    ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);
	    img.setIcon(iconoEscalado);

	    layeredPane.setLayout(new BorderLayout());

		layeredPane.setLayout(new OverlayLayout(layeredPane));
	    layeredPane.add(new JLabel(iconoEscalado), JLayeredPane.DEFAULT_LAYER);

	    panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS));
	    btnIniciar.setAlignmentX(Component.CENTER_ALIGNMENT);
	    btnOpciones.setAlignmentX(Component.CENTER_ALIGNMENT);
	    btnSalir.setAlignmentX(Component.CENTER_ALIGNMENT);

	    panelBotones.setOpaque(false);

	    panelBotones.add(Box.createVerticalGlue());
	    btnIniciar.addActionListener(e->iniciarPartida());
	    panelBotones.add(btnIniciar);
	    panelBotones.add(Box.createVerticalStrut(20));
	    panelBotones.add(btnOpciones);
	    panelBotones.add(Box.createVerticalStrut(10));
	    btnSalir.addActionListener(e->System.exit(0));
	    panelBotones.add(btnSalir);
	    panelBotones.add(Box.createVerticalGlue());

	    layeredPane.add(panelBotones,JLayeredPane.PALETTE_LAYER);

	    

	    marco.add(layeredPane);
	}

	private void iniciarPartida() {
		VentanaPrePrincipal vpp = new VentanaPrePrincipal(this);
		  vpp.montarEscena();
    }
	
	

}
