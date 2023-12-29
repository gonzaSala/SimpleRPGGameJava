package MiniRPG;

import java.awt.*;
import javax.swing.*;
import marcoPanelPersonalizado.framePer;

public class VentanaPrincipal {
    private framePer marco;
    private JPanel panelPrincipal, panelSuperior, panelInferior;

    private JLabel etNombre, etOro, etNivel, etExp, etAtributos;
    private JLabel etImagen;

    private JButton botExplorar;

    private Personaje pj;

    public VentanaPrincipal(Personaje pj) {
        this.pj = pj;

        marco = new framePer(600, 500, "miniRPG", true);

        panelPrincipal = new JPanel(new BorderLayout());
        panelSuperior = new JPanel();
        panelInferior = new JPanel();

        etNombre = new JLabel(pj.getNombre() + "     ");
        etNivel = new JLabel(" Lvl: " + pj.getNivel());
        etExp = new JLabel(" Exp: " + pj.getExp() + "/" + pj.getExpNecesaria());
        etOro = new JLabel("Oro: " + pj.getOro());
        etAtributos = new JLabel("Atq: " + pj.getAtaque() + " | Def:  " + pj.getDefensa() + "  Vida: ");

        etImagen = new JLabel();

        botExplorar = new JButton("Explorar");
    }

    public void ComenzarJuego() {
        mostrarEscena();
        marco.setVisible(true);
    }

    private void mostrarEscena() {
    	
    	modificarFuentes();
    	
        panelSuperior.add(etNombre);
        panelSuperior.add(etNivel);
        panelSuperior.add(etExp);
        panelSuperior.add(etOro);
        panelSuperior.add(etAtributos);
        panelSuperior.add(pj.getBarraVida());

        int anchoMarco = marco.getWidth();
        int altoMarco = marco.getHeight();
        
        ImageIcon imgPrincipal = new ImageIcon("C:\\Users\\Gonzalo\\eclipse-workspace\\Portfolio\\src\\MiniRPG\\assets\\image\\imgPrincipal.jpg");
        Image imagenOriginal = imgPrincipal.getImage();
        Image imagenEscalada = imagenOriginal.getScaledInstance(anchoMarco, altoMarco, Image.SCALE_SMOOTH);
        ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);
        etImagen.setIcon(iconoEscalado);

        panelPrincipal.add(etImagen, BorderLayout.CENTER);

        botExplorar.addActionListener(e -> nuevaExploracion());
        panelInferior.add(botExplorar);
        
        

        panelPrincipal.add(panelSuperior, BorderLayout.NORTH);
        panelPrincipal.add(panelInferior, BorderLayout.SOUTH);

        marco.add(panelPrincipal);
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
	
		//VentanaFinal v = new VentanaFinal(VentanaFinal.DERROTA,pj);
		//v.abrir();
		
		
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