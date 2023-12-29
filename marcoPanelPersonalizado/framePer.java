package marcoPanelPersonalizado;

import javax.swing.JFrame;

public class framePer extends JFrame{
	
	public framePer(int ancho, int alto, String titulo, boolean esPrincipal) {
		setSize(ancho,alto);
		setTitle(titulo);
		this.setLocationRelativeTo(null);
		
		if(esPrincipal) this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
