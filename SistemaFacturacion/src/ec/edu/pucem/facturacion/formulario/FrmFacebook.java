package ec.edu.pucem.facturacion.formulario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

public class FrmFacebook extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	public FrmFacebook() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JButton btnAlerta = new JButton("Alerta");
		btnAlerta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Mensaje", "Titulo", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnAlerta.setBounds(152, 26, 113, 21);
		getContentPane().add(btnAlerta);
		
		JButton btnConfirmacion = new JButton("Confirmacion");
		btnConfirmacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int dialogResult=JOptionPane.showConfirmDialog(null, "Estas seguro?", "Confirme", JOptionPane.YES_NO_OPTION);
				if(dialogResult==JOptionPane.YES_OPTION) {
					System.out.println("Pulso en SI");
				}else {
					System.out.println("Pulsado en NO");
				}
			}
		});
		btnConfirmacion.setBounds(152, 61, 113, 21);
		getContentPane().add(btnConfirmacion);

	}

}
