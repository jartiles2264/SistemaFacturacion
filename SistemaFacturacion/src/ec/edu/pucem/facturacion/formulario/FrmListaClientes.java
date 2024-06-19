package ec.edu.pucem.facturacion.formulario;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FrmListaClientes extends JInternalFrame{

    private static final long serialVersionUID = 1L;
    private JTable table;
    private DefaultTableModel model;

    public FrmListaClientes() {
        setTitle("Lista de Clientes");
        setClosable(true);
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 10, 414, 240);
        getContentPane().add(scrollPane);

        table = new JTable();
        table.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] { "Apellidos", "Nombres", "Cedula" }
        ));
        scrollPane.setViewportView(table);
        model = (DefaultTableModel) table.getModel();
    }

    public void agregarCliente(String apellidos, String nombres, String cedula) {
        Object[] fila = { apellidos, nombres, cedula };
        model.addRow(fila);
    }

}
