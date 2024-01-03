package MiniRPG;

import java.awt.*;

import javax.swing.*;

public class Tienda {

	private JDialog marco;

	private JPanel panelPrincipal, panelSuperior, panelInferior, panelTienda;
	private JPanel panelEspada, panelEscudo, panelPocion, panelMapa;

	private JLabel imgEspada, imgEscudo, imgPocion, imgMapa;
	private JLabel desEspada, desEscudo, desPocion, desMapa;

	private static JButton btnEspada, btnEscudo, btnPocion, btnMapa;
	private static boolean agoEspada=false,agoEscudo=false,agoPocion=false,agoMapa=false;

	private JButton btnSalir;

	private VentanaPrincipal vp;
	private Personaje pj;

	public Tienda(VentanaPrincipal vp) {

		this.vp = vp;
		pj = vp.getPj();

		marco = new JDialog();

		panelPrincipal = new JPanel(new BorderLayout());
		panelSuperior = vp.getPanelSuperior();
		panelInferior = new JPanel();
		panelTienda = new JPanel(new GridLayout(2, 2));

		panelEspada = new JPanel();
		panelEscudo = new JPanel();
		panelPocion = new JPanel();
		panelMapa = new JPanel();

		imgEspada = new JLabel(new ImageIcon(
				"C:\\Users\\Gonzalo\\eclipse-workspace\\MiniJuego\\src\\MiniRPG\\assets\\image\\sword.png"));
		imgEscudo = new JLabel(new ImageIcon(
				"C:\\Users\\Gonzalo\\eclipse-workspace\\MiniJuego\\src\\MiniRPG\\assets\\image\\shield.png"));
		imgPocion = new JLabel(new ImageIcon(
				"C:\\Users\\Gonzalo\\eclipse-workspace\\MiniJuego\\src\\MiniRPG\\assets\\image\\potion.png"));
		imgMapa = new JLabel(new ImageIcon(
				"C:\\Users\\Gonzalo\\eclipse-workspace\\MiniJuego\\src\\MiniRPG\\assets\\image\\map.png"));

		desEspada = new JLabel("Espada - 100 oro");
		desEscudo = new JLabel("Escudo - 100 oro");
		desPocion = new JLabel("Pocion - 50 oro");
		desMapa = new JLabel("Mapa - 10 oro");

		btnEspada = new JButton("Comprar");
		btnEscudo = new JButton("Comprar");
		btnPocion = new JButton("Comprar");
		btnMapa = new JButton("Comprar");
		
		btnSalir = new JButton("Salir");

	}

	public void abrirTienda() {

		montarInterfaz();
		marco.setVisible(true);


	}

	private void montarInterfaz() {

		panelPrincipal.add(panelSuperior, BorderLayout.NORTH);

		addObjeto( panelEspada, imgEspada, desEspada, btnEspada, "espada", agoEspada);
		addObjeto( panelEscudo, imgEscudo, desEscudo, btnEscudo, "escudo", agoEscudo);
		addObjeto( panelPocion, imgPocion, desPocion, btnPocion, "pocion", agoPocion);
		addObjeto( panelMapa, imgMapa, desMapa, btnMapa, "mapa", agoMapa);

		panelPrincipal.add(panelTienda, BorderLayout.CENTER);
		
		btnSalir.addActionListener(e-> marco.dispose());
		panelInferior.add(btnSalir);
		panelPrincipal.add(panelInferior, BorderLayout.SOUTH);
		
		marco.setSize(600,600);
		marco.setLocationRelativeTo(null);
		marco.setModal(true);
		marco.add(panelPrincipal);
		
		
		
	}

	private void addObjeto( JPanel panelObjeto, JLabel img, JLabel descripcion, JButton btn, String nombre, boolean agotado) {
		
		img.setAlignmentX(Component.CENTER_ALIGNMENT);
		descripcion.setAlignmentX(Component.CENTER_ALIGNMENT);
		btn.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		btn.addActionListener(e -> comprarObjeto(btn, nombre));
		
		if(agotado)btn.setEnabled(false);
		
		
		panelObjeto.setLayout(new BoxLayout(panelObjeto, BoxLayout.Y_AXIS));
		panelObjeto.add(img);
		panelObjeto.add(descripcion);
		panelObjeto.add(btn);
		
		panelTienda.add(panelObjeto);
	}

	private void comprarObjeto(JButton btn, String nombre) {
		
		switch (nombre) {
			
		case "espada": 
			if(pj.getOro()>= 100) {
				pj.setAtaque(pj.getAtaque()+3);
				vp.getEtAtributos().setText("Atq: " + pj.getAtaque() + " | Def:  " + pj.getDefensa() + "  Vida: ");
				pj.setOro(pj.getOro()-100);
				vp.getEtOro().setText("Oro: " + pj.getOro());
				btn.setEnabled(false);
				agoEspada = true;
			}
			break;
			
		case "escudo": 
			if(pj.getOro()>= 100) {
				pj.setDefensa(pj.getDefensa()+1);
				vp.getEtAtributos().setText("Atq: " + pj.getAtaque() + " | Def:  " + pj.getDefensa() + "  Vida: ");
				pj.setOro(pj.getOro()-100);
				vp.getEtOro().setText("Oro: " + pj.getOro());
				btn.setEnabled(false);
				agoEscudo = true;

			}
			break;
		case "pocion": 
			if(pj.getOro()>= 50) {
				pj.setVidaActual((int)pj.getVidaMax());
				pj.establecerVida(pj.getVidaActual());
				pj.setOro(pj.getOro()-50);
				vp.getEtOro().setText("Oro: " + pj.getOro());
				btn.setEnabled(false);
				agoPocion = true;

			}
			break;
		case "mapa": 
			if(pj.getOro()>= 10) {
				Exploracion.setNumExploracion(250);
				pj.setOro(pj.getOro()-10);
				vp.getEtOro().setText("Oro: " + pj.getOro());
				btn.setEnabled(false);
				agoMapa = true;

			}
			break;
		}
	}

}
