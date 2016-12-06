package py.edu.facitec.taller.secundario;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;

public class FormMantenimiento extends JDialog {
	private JTextField tfCodigo;
	private JTextField tfFecha;
	private JTextField tfClienteCodigo;
	private JTextField tfCondicion;
	private JTextField tfTotal;
	private JTextField tfObservacoin;
	private JTextField tfSituacion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormMantenimiento dialog = new FormMantenimiento();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public FormMantenimiento() {
		setBounds(100, 100, 450, 350);
		getContentPane().setLayout(null);
		
		JLabel lblFormularioMantenimiento = new JLabel("FORMULARIO MANTENIMIENTO");
		lblFormularioMantenimiento.setFont(new Font("Stencil", Font.PLAIN, 16));
		lblFormularioMantenimiento.setBounds(84, 11, 254, 14);
		getContentPane().add(lblFormularioMantenimiento);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(10, 42, 46, 14);
		getContentPane().add(lblCodigo);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(10, 70, 46, 14);
		getContentPane().add(lblFecha);
		
		JLabel lblClienteCodigo = new JLabel("Cliente Codigo:");
		lblClienteCodigo.setBounds(10, 105, 85, 14);
		getContentPane().add(lblClienteCodigo);
		
		JLabel lblCondicion = new JLabel("Condicion:");
		lblCondicion.setBounds(10, 139, 67, 14);
		getContentPane().add(lblCondicion);
		
		JLabel lblImporteTotal = new JLabel("Importe Total:");
		lblImporteTotal.setBounds(10, 173, 85, 14);
		getContentPane().add(lblImporteTotal);
		
		JLabel lblObservacion = new JLabel("Observacion:");
		lblObservacion.setBounds(10, 202, 85, 14);
		getContentPane().add(lblObservacion);
		
		JLabel lblSituacion = new JLabel("Situacion:");
		lblSituacion.setBounds(10, 236, 67, 14);
		getContentPane().add(lblSituacion);
		
		tfCodigo = new JTextField();
		tfCodigo.setBounds(74, 39, 86, 20);
		getContentPane().add(tfCodigo);
		tfCodigo.setColumns(10);
		
		tfFecha = new JTextField();
		tfFecha.setText("");
		tfFecha.setBounds(74, 67, 86, 20);
		getContentPane().add(tfFecha);
		tfFecha.setColumns(10);
		
		tfClienteCodigo = new JTextField();
		tfClienteCodigo.setBounds(97, 102, 86, 20);
		getContentPane().add(tfClienteCodigo);
		tfClienteCodigo.setColumns(10);
		
		tfCondicion = new JTextField();
		tfCondicion.setBounds(97, 136, 86, 20);
		getContentPane().add(tfCondicion);
		tfCondicion.setColumns(10);
		
		tfTotal = new JTextField();
		tfTotal.setBounds(97, 170, 86, 20);
		getContentPane().add(tfTotal);
		tfTotal.setColumns(10);
		
		tfObservacoin = new JTextField();
		tfObservacoin.setText("");
		tfObservacoin.setBounds(97, 199, 275, 20);
		getContentPane().add(tfObservacoin);
		tfObservacoin.setColumns(10);
		
		tfSituacion = new JTextField();
		tfSituacion.setBounds(74, 233, 86, 20);
		getContentPane().add(tfSituacion);
		tfSituacion.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(10, 277, 89, 23);
		getContentPane().add(btnGuardar);
		
		JButton btnAnular = new JButton("Anular");
		btnAnular.setBounds(140, 277, 89, 23);
		getContentPane().add(btnAnular);

	}

}
