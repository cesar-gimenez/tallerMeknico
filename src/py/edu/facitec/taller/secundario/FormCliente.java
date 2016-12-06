package py.edu.facitec.taller.secundario;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import py.edu.facitec.taller.dao.ClienteDao;
import py.edu.facitec.taller.entidad.Cliente;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfCodigo;
	private JTextField tfNombre;
	private JTextField tfApellido;
	private JTextField tfDireccion;
	private JTextField tfCelular;
	private JTextField tfCredito;
	private JCheckBox chActivo;
	private JButton btnBuscar;
	private JButton btnGuardar;
	private JTextField tfCiudadCodigo;
	private JButton btnModificar;
	private JButton btnEliminar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FormCliente dialog = new FormCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FormCliente() {
		setBounds(100, 100, 375, 374);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblFormularioCliente = new JLabel("FORMULARIO CLIENTE");
		lblFormularioCliente.setFont(new Font("Stencil", Font.PLAIN, 16));
		lblFormularioCliente.setBounds(81, 11, 194, 14);
		contentPanel.add(lblFormularioCliente);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(10, 51, 46, 14);
		contentPanel.add(lblCodigo);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 76, 46, 14);
		contentPanel.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(10, 104, 46, 14);
		contentPanel.add(lblApellido);
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setBounds(10, 129, 56, 14);
		contentPanel.add(lblDireccion);
		
		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setBounds(10, 197, 46, 14);
		contentPanel.add(lblCelular);
		
		JLabel lblCredito = new JLabel("Credito:");
		lblCredito.setBounds(10, 231, 46, 14);
		contentPanel.add(lblCredito);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(11, 257, 46, 14);
		contentPanel.add(lblEstado);
		
		tfCodigo = new JTextField();
		tfCodigo.setBounds(66, 48, 86, 20);
		contentPanel.add(tfCodigo);
		tfCodigo.setColumns(10);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(66, 73, 237, 20);
		contentPanel.add(tfNombre);
		tfNombre.setColumns(10);
		
		tfApellido = new JTextField();
		tfApellido.setBounds(66, 101, 237, 20);
		contentPanel.add(tfApellido);
		tfApellido.setColumns(10);
		
		tfDireccion = new JTextField();
		tfDireccion.setBounds(66, 126, 237, 20);
		contentPanel.add(tfDireccion);
		tfDireccion.setColumns(10);
		
		tfCelular = new JTextField();
		tfCelular.setBounds(60, 193, 132, 20);
		contentPanel.add(tfCelular);
		tfCelular.setColumns(10);
		
		tfCredito = new JTextField();
		tfCredito.setBounds(62, 225, 86, 20);
		contentPanel.add(tfCredito);
		tfCredito.setColumns(10);
		
		chActivo = new JCheckBox("Activo");
		chActivo.setBounds(57, 250, 97, 23);
		contentPanel.add(chActivo);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				consultarClientePorCodigo();
			}
		});
		btnBuscar.setBounds(253, 47, 89, 23);
		contentPanel.add(btnBuscar);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				registrarCliente();
			}
		});
		btnGuardar.setBounds(12, 283, 89, 23);
		contentPanel.add(btnGuardar);
		
		JLabel lblCiudadCodigo = new JLabel("Ciudad Codigo:");
		lblCiudadCodigo.setBounds(12, 162, 78, 14);
		contentPanel.add(lblCiudadCodigo);
		
		tfCiudadCodigo = new JTextField();
		tfCiudadCodigo.setBounds(106, 157, 86, 20);
		contentPanel.add(tfCiudadCodigo);
		tfCiudadCodigo.setColumns(10);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				editarCliente();
			}
		});
		btnModificar.setBounds(131, 283, 89, 23);
		contentPanel.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				deletarCliente();
			}
		});
		btnEliminar.setBounds(253, 283, 89, 23);
		contentPanel.add(btnEliminar);
	}
	
	private void registrarCliente(){
		Cliente cliente = new Cliente();
		//cliente.setCodigo(Integer.parseInt(tfCodigo.getText()));
		cliente.setNombre(tfNombre.getText());
		cliente.setApellido(tfApellido.getText());
		cliente.setDireccion(tfDireccion.getText());
		cliente.setCiudad_codigo(Integer.parseInt(tfCiudadCodigo.getText()));
		cliente.setCelular(tfCelular.getText());
		cliente.setCredito(Double.parseDouble(tfCredito.getText()));
		cliente.setEstado(chActivo.isSelected());
		
		ClienteDao.guardarCliente(cliente);
		limpiarCampos();
	}
	
	private void consultarClientePorCodigo(){
		
		int codigo = Integer.parseInt(tfCodigo.getText());
		
		Cliente cliente = ClienteDao.recuperarClientePorCodigo(codigo);
		
		System.out.println(cliente);
		
		if(cliente != null){
			tfNombre.setText(cliente.getNombre());
			tfApellido.setText(cliente.getApellido());
			tfDireccion.setText(cliente.getDireccion());
			tfCiudadCodigo.setText(cliente.getCiudad_codigo()+"");
			tfCelular.setText(cliente.getCelular());
			tfCredito.setText(cliente.getCredito()+"");
			chActivo.setSelected(cliente.isEstado());
		}
	}
	
	private void editarCliente(){
		Cliente cliente = new Cliente();
		cliente.setCodigo(Integer.parseInt(tfCodigo.getText()));
		cliente.setNombre(tfNombre.getText());
		cliente.setApellido(tfApellido.getText());
		cliente.setDireccion(tfDireccion.getText());
		cliente.setCiudad_codigo(Integer.parseInt(tfCiudadCodigo.getText()));
		cliente.setCelular(tfCelular.getText());
		cliente.setCredito(Double.parseDouble(tfCredito.getText()));
		cliente.setEstado(chActivo.isSelected());
		ClienteDao.modificarCliente(cliente);
		limpiarCampos();
	}
	
	private void deletarCliente(){
		int codigo = Integer.parseInt(tfCodigo.getText());
		ClienteDao.eliminarCliente(codigo);
		limpiarCampos();
	}
	
	private void limpiarCampos(){
		tfCodigo.setText("");
		tfNombre.setText("");
		tfApellido.setText("");
		tfDireccion.setText("");
		tfCiudadCodigo.setText("");
		tfCelular.setText("");
		tfCredito.setText("");
		chActivo.setSelected(false);
	}
}
