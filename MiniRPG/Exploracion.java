package MiniRPG;

import java.awt.*;

import javax.swing.*;

public class Exploracion {

	private JDialog marco;

	private JPanel panelPrincipal, panelSuperior, panelInferior, panelMonstruo, panelMonstruoSec;

	private JButton btnAtacar, btnHuir;

	private JTextArea infoExploracion;
	private JScrollPane barraDes;

	private Personaje pj;
	private Monstruo enemigo;

	
	private static int numExploracion = 0;
	
	private VentanaPrincipal vp;

	public Exploracion(VentanaPrincipal vp) {
		
		this.vp=vp;
		
		pj = vp.getPj();
		
		marco = new JDialog();
		
		panelPrincipal = new JPanel(new BorderLayout());
		panelSuperior = vp.getPanelSuperior();
		panelInferior = new JPanel();
		panelMonstruo = new JPanel();
		panelMonstruoSec = new JPanel();
		
		infoExploracion = new JTextArea ();
		infoExploracion.setEditable(false);
		infoExploracion.setBackground(null);
		
		barraDes = new JScrollPane(infoExploracion);
		barraDes.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		btnAtacar = new JButton("Atacar");
		btnHuir = new JButton("Huir");
	}
	
	public void comenzarExploracion () {
		decidirDificultad();
		montarInterfaz();
	}


	private void decidirDificultad() {
		
		int numAlea = (int)(Math.random()*100) + numExploracion;
		
		numExploracion++;
		
		enemigo = Monstruo.generaMonstruo(numAlea);
		
		
		
	}

	private void montarInterfaz() {
		
		panelPrincipal.add(barraDes ,BorderLayout.CENTER);
		
		panelMonstruoSec.add(enemigo.getEtNombre());
		panelMonstruoSec.add(enemigo.getBarraVida());
		
		panelMonstruo.setLayout(new BoxLayout(panelMonstruo, BoxLayout.Y_AXIS));
		panelMonstruo.add(enemigo.getImagen());
		panelMonstruo.add(panelMonstruoSec);
		

		btnAtacar.addActionListener(e->atacar());
		
		btnHuir.addActionListener(e->marco.dispose());
		
		panelInferior.add(btnAtacar);
		panelInferior.add(new JLabel ("           "));
		panelInferior.add(btnHuir);
		
		panelPrincipal.add(panelSuperior, BorderLayout.NORTH);
		panelPrincipal.add(panelInferior, BorderLayout.SOUTH);
		panelPrincipal.add(panelMonstruo, BorderLayout.EAST);
		
		marco.add(panelPrincipal);
		marco.setSize(680,500);
		marco.setLocationRelativeTo(null);
		marco.setModal(true);
		marco.setVisible(true);
		
	}

	private void atacar() {
		
		int damage;
		
		pj.atacar(enemigo);
		
		infoExploracion.setText(infoExploracion.getText() + pj.getNombre() 
								+ " ataca con una fuerza de " + pj.getAtaque() + ".\n");
		
		damage = pj.getAtaque() - enemigo.getDefensa();
		if(damage <= 0) damage = 1;
		
		infoExploracion.setText(infoExploracion.getText() + enemigo.getNombre() 
								+ " ha recibido "+ damage + " de daño gracias a su defensa.\n\n");
		
		enemigo.establecerVida(enemigo.getVidaActual());
		
		if(!enemigo.isEstaVivo()) {
			enemigoDerrotado();
		}else {
			enemigo.atacar(pj);

			infoExploracion.setText(infoExploracion.getText() + enemigo.getNombre() 
			+ " ataca con una fuerza de " + enemigo.getAtaque() + ".\n");
			
			damage = enemigo.getAtaque() - pj.getDefensa();
			if(damage <= 0) damage = 1;
			
			infoExploracion.setText(infoExploracion.getText() + pj.getNombre() 
									+ " ha recibido "+ damage + " de daño gracias a su defensa.\n\n");
			
			pj.establecerVida(pj.getVidaActual());
			
			if(!pj.isEstaVivo()) {
				derrota();
			}

		}
		
		
	}

	private void derrota() {
		
		
		
	}

	private void enemigoDerrotado() {
		
		btnAtacar.setEnabled(false);
		btnHuir.setText("Salir");
		
		infoExploracion.setText(infoExploracion.getText() + enemigo.getNombre() + " ha sido derrotado.-\n"
									+ "Has obtenido " + enemigo.getPremioOro() + " de oro.-\n"
									+ "Ganas " + enemigo.getPremioExp() + " puntos de experiencia.\n");
		
		pj.subirExp(enemigo.getPremioExp());
		vp.getEtExp().setText( " Exp:  "+ pj.getExp() + "/" + pj.getExpNecesaria());
		vp.getEtNivel().setText(" Lvl: " + pj.getNivel());
		vp.getEtAtributos().setText("Atq: " + pj.getAtaque() + " | Def:  " + pj.getDefensa() + "  Vida: ");
		
		pj.setOro(enemigo.getPremioOro());
		vp.getEtOro().setText("Oro: " + pj.getOro());
	}
}
