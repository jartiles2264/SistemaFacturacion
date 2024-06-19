package ec.edu.pucem.facturacion.formulario;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ec.edu.pucem.facturacion.dominio.Cliente;

import javax.swing.JScrollPane;

public class FrmCrearCliente extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JTextField txtEmail;
	private JTextField txtCedula;
	private JTable table;
	private DefaultTableModel model;

	public FrmCrearCliente() {
		setBounds(100, 100, 366, 435);
		getContentPane().setLayout(null);
		
		JLabel lblCedula = new JLabel("Cedula");
		lblCedula.setBounds(10, 10, 45, 13);
		getContentPane().add(lblCedula);
		
		JLabel lblNombres = new JLabel("Nombres");
		lblNombres.setBounds(10, 33, 45, 13);
		getContentPane().add(lblNombres);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(10, 56, 45, 13);
		getContentPane().add(lblApellidos);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(10, 79, 45, 13);
		getContentPane().add(lblDireccion);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(10, 102, 45, 13);
		getContentPane().add(lblTelefono);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 125, 45, 13);
		getContentPane().add(lblEmail);
		
		txtNombres = new JTextField();
		txtNombres.setColumns(10);
		txtNombres.setBounds(65, 30, 188, 16);
		getContentPane().add(txtNombres);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarCampos();
			}
		});
		btnNuevo.setBounds(10, 166, 85, 21);
		getContentPane().add(btnNuevo);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crearCliente();
			}
		});
		btnGuardar.setBounds(105, 166, 85, 21);
		getContentPane().add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarCampos();
			}
		});
		btnCancelar.setBounds(200, 166, 85, 21);
		getContentPane().add(btnCancelar);
		
		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(65, 53, 188, 16);
		getContentPane().add(txtApellidos);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(65, 76, 188, 16);
		getContentPane().add(txtDireccion);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(65, 99, 188, 16);
		getContentPane().add(txtTelefono);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(65, 122, 188, 16);
		getContentPane().add(txtEmail);
		
		txtCedula = new JTextField();
		txtCedula.setColumns(10);
		txtCedula.setBounds(65, 7, 85, 16);
		getContentPane().add(txtCedula);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 209, 280, 161);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Cedula", "Nombres", "Apellidos"
			}
		));
		scrollPane.setViewportView(table);
		model=(DefaultTableModel) table.getModel();

	}

	private void crearCliente() {
		Cliente cliente = new Cliente();
		cliente.setCedula(this.txtCedula.getText());
		cliente.setNombres(this.txtNombres.getText());
		cliente.setApellidos(this.txtApellidos.getText());
		cliente.setDireccion(this.txtDireccion.getText());
		cliente.setTelefono(this.txtTelefono.getText());
		cliente.setEmail(this.txtEmail.getText());
		agregarClienteTabla(cliente);
	}

	public void agregarClienteTabla(Cliente cliente) {
		Object[] fila = { cliente.getCedula(), cliente.getNombres(), cliente.getApellidos() };
		model.addRow(fila);
	}

	private void limpiarCampos() {
		txtCedula.setText("");
		txtNombres.setText("");
		txtApellidos.setText("");
		txtDireccion.setText("");
		txtTelefono.setText("");
		txtEmail.setText("");
		txtCedula.requestFocus();
	}
}
