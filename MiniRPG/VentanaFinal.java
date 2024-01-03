package MiniRPG;

import java.awt.*;

import javax.swing.*;

public class VentanaFinal {
	
	private JTextArea areaTxt;
	
	private JLabel imagen;
	private ImageIcon rutaImg;
	
	private JDialog marco;
	private JPanel panelPrincipal;
	
	private int condicion;
	
	private JButton btnSalir;
	
	private Personaje pj;
	
	public static final int VICTORIA = 0;
	public static final int DERROTA = 1;
	
	public VentanaFinal (int condicion, Personaje pj) {
		
		marco = new JDialog();
		panelPrincipal = new JPanel(new BorderLayout());
		
		areaTxt = new JTextArea();
		
		btnSalir = new JButton ("Finalizar");
		
		this.condicion= condicion;
		this.pj= pj;

		
		if(condicion == VICTORIA) rutaImg = new ImageIcon("C:\\Users\\Gonzalo\\eclipse-workspace\\MiniJuego\\src\\MiniRPG\\assets\\image\\victoria.jpg");
		else rutaImg = new ImageIcon ("C:\\\\Users\\\\Gonzalo\\\\eclipse-workspace\\\\MiniJuego\\\\src\\\\MiniRPG\\\\assets\\\\image\\\\derrota.jpg");
		
		 Image imagenEscalada = rutaImg.getImage().getScaledInstance(600, 400, Image.SCALE_SMOOTH);
		   rutaImg = new ImageIcon(imagenEscalada);
		
		imagen = new JLabel(rutaImg);
		
		
		
	}
	
	public void abrir() {
		prepararMsj();
		montarEscena();
		marco.setVisible(true);
	}

	private void prepararMsj() {
		
		String msjFinal;
		
		if(condicion == VICTORIA) {
			
			msjFinal = "Has conseguido derrotar al señor del castillo. Vuelves a tu hogar.-\n"
					+ " Tiene heridad que jamás podrás borrar. Has vencido, pero a qué precio? \n\n"
					+ "Nivel: " + pj.getNivel() + " Has logrado traer contigo " + pj.getOro() + " monedas de oro. "; 
		}else {
			msjFinal = "Fuiste aniquilado en el castillo. Tus seres queridos enterraron lo que quedaba de ti.\n"
					+ "Vuelve a intentarlo si te atreves.";
		}
		
		areaTxt.setText(msjFinal);
	}

	private void montarEscena() {
		
		panelPrincipal.add(imagen, BorderLayout.NORTH);
		panelPrincipal.add(areaTxt, BorderLayout.CENTER);
		panelPrincipal.add(btnSalir, BorderLayout.SOUTH);
		
		areaTxt.setEditable(false);
		areaTxt.setBackground(null);
		
		btnSalir.addActionListener(e-> System.exit(0));
		
		marco.add(panelPrincipal);
		marco.setSize(600,500);
		marco.setLocationRelativeTo(null);
		marco.setModal(true);
	}
	

}
