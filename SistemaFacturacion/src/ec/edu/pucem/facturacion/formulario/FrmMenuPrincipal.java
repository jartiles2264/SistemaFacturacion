package ec.edu.pucem.facturacion.formulario;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;
import java.awt.CardLayout;

public class FrmMenuPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JDesktopPane desktopPane;
	private Map<Class<? extends JInternalFrame>, JInternalFrame> formulariosAbiertos;
	private static FrmListaClientes frmListaClientes;

	public FrmMenuPrincipal() {
		setTitle("SISTEMA DE FACTURACION ELECTRONICA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		formulariosAbiertos = new HashMap<>();

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnArchivo = new JMenu("Archivo");
		mnArchivo.setFont(new Font("Segoe UI", Font.BOLD, 16));
		menuBar.add(mnArchivo);

		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0); 
			}
		});
		mnArchivo.add(mntmSalir);

		JMenu mnClientes = new JMenu("Clientes");
		mnClientes.setFont(new Font("Segoe UI", Font.BOLD, 16));
		menuBar.add(mnClientes);

		JMenuItem mntmNuevoCliente = new JMenuItem("Crear nuevo");
		mntmNuevoCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirFormulario(FrmCrearCliente.class);
			}
		});
		mntmNuevoCliente.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnClientes.add(mntmNuevoCliente);

		JMenuItem mntmListaClientes = new JMenuItem("Lista clientes");
		mntmListaClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (frmListaClientes == null) {
					frmListaClientes = new FrmListaClientes();
					desktopPane.add(frmListaClientes);
				}
				frmListaClientes.setVisible(true);
				frmListaClientes.toFront();
			}
		});
		mntmListaClientes.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnClientes.add(mntmListaClientes);

		JMenu mnProductos = new JMenu("Productos");
		mnProductos.setFont(new Font("Segoe UI", Font.BOLD, 16));
		menuBar.add(mnProductos);

		JMenu mnRedes = new JMenu("Redes");
		mnRedes.setFont(new Font("Segoe UI", Font.BOLD, 16));
		menuBar.add(mnRedes);

		JMenuItem mntmFacebook = new JMenuItem("Facebook");
		mntmFacebook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirFormulario(FrmFacebook.class);
			}
		});
		mntmFacebook.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/ec/edu/pucem/facturacion/imagen/facebook.png")));
		mnRedes.add(mntmFacebook);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));

		desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, "name_506988938504700");
	}

	private void abrirFormulario(Class<? extends JInternalFrame> tipoFormulario) {
		if (!formulariosAbiertos.containsKey(tipoFormulario)) {
			try {
				JInternalFrame formulario = tipoFormulario.getDeclaredConstructor().newInstance();
				formulariosAbiertos.put(tipoFormulario, formulario);
				formulario.setVisible(true);
				desktopPane.add(formulario);
				formulario.setMaximum(true); 
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} else {
			JInternalFrame formulario = formulariosAbiertos.get(tipoFormulario);
			formulario.setVisible(true);
			formulario.toFront();
		}
	}
}
