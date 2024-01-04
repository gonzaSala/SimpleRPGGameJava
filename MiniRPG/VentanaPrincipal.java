package MiniRPG;

import java.awt.*;
import javax.swing.*;
import marcoPanelPersonalizado.framePer;

public class VentanaPrincipal {
	private JDialog marco;
	private JPanel panelPrincipal, panelSuperior, panelInferior;

	private JLabel etNombre, etOro, etNivel, etExp, etAtributos;
	private JLabel etImagen;

	private JButton btnExplorar, btnTienda, btnSalir;

	private Personaje pj;

	public VentanaPrincipal(Personaje pj) {
		this.pj = pj;

		marco = new JDialog();

		panelPrincipal = new JPanel(new BorderLayout());
		panelSuperior = new JPanel();
		panelInferior = new JPanel();

		etNombre = new JLabel(pj.getNombre() + "     ");
		etNivel = new JLabel(" Lvl: " + pj.getNivel());
		etExp = new JLabel(" Exp: " + pj.getExp() + "/" + pj.getExpNecesaria());
		etOro = new JLabel("Oro: " + pj.getOro());
		etAtributos = new JLabel("Atq: " + pj.getAtaque() + " | Def:  " + pj.getDefensa() + "  Vida: ");

		etImagen = new JLabel();

		btnExplorar = new JButton("Explorar");
		btnTienda = new JButton ("Tienda");
		btnSalir =new JButton ("Salir");
	}

	public void ComenzarJuego() {
		mostrarEscena();
		marco.setUndecorated(true);
		marco.setVisible(true);
		marco.setLocationRelativeTo(null);
		marco.setModal(true);
	}

	private void mostrarEscena() {
		
		
		marco.setSize(600,500);
		

		modificarFuentes();

		panelSuperior.add(etNombre);
		panelSuperior.add(etNivel);
		panelSuperior.add(etExp);
		panelSuperior.add(etOro);
		panelSuperior.add(etAtributos);
		panelSuperior.add(pj.getBarraVida());

		int anchoMarco = marco.getWidth();
		int altoMarco = marco.getHeight();

		ImageIcon imgPrincipal = new ImageIcon(
				"C:\\Users\\Gonzalo\\eclipse-workspace\\MiniJuego\\src\\MiniRPG\\assets\\image\\imgPrincipal.jpg");
		Image imagenOriginal = imgPrincipal.getImage();
		Image imagenEscalada = imagenOriginal.getScaledInstance(anchoMarco, altoMarco, Image.SCALE_SMOOTH);
		ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);
		etImagen.setIcon(iconoEscalado);

		panelPrincipal.add(etImagen, BorderLayout.CENTER);

		btnExplorar.addActionListener(e -> nuevaExploracion());
		panelInferior.add(btnExplorar);
		btnTienda.addActionListener(e-> abrirTienda() );
		panelInferior.add(btnTienda);
		btnSalir.addActionListener(e -> marco.dispose());
		panelInferior.add(btnSalir);

		panelPrincipal.add(panelSuperior, BorderLayout.NORTH);
		panelPrincipal.add(panelInferior, BorderLayout.SOUTH);

		marco.add(panelPrincipal);
	}

	private void abrirTienda() {
		
		Tienda t = new Tienda(this);
		t.abrirTienda();
		panelPrincipal.add(panelSuperior, BorderLayout.NORTH);
		marco.repaint();
		
		
	}

	private void modificarFuentes() {
		Font miFuente = new Font("Roboto", Font.BOLD, 15);
		etNombre.setFont(miFuente);
	}

	private void nuevaExploracion() {

		Exploracion ex = new Exploracion(this);
		ex.comenzarExploracion();
		panelPrincipal.add(panelSuperior, BorderLayout.NORTH);
		marco.repaint();

		// VentanaFinal v = new VentanaFinal(VentanaFinal.DERROTA,pj);
		// v.abrir();

	}

	public Personaje getPj() {
		return pj;
	}

	public JPanel getPanelSuperior() {
		return panelSuperior;
	}

	public JLabel getEtOro() {
		return etOro;
	}

	public JLabel getEtNivel() {
		return etNivel;
	}

	public JLabel getEtExp() {
		return etExp;
	}

	public JLabel getEtAtributos() {
		return etAtributos;
	}

}