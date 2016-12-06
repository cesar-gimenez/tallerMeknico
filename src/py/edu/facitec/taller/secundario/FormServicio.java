package py.edu.facitec.taller.secundario;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JCheckBox;

import py.edu.facitec.taller.dao.ServicioDao;
import py.edu.facitec.taller.entidad.Servicio;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormServicio extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfCodigo;
	private JTextField tfNombre;
	private JTextField tfDescripcion;
	private JTextField tfUnitario;
	private JCheckBox chActivo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FormServicio dialog = new FormServicio();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FormServicio() {
		setBounds(100, 100, 378, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblFormularioServicio = new JLabel("FORMULARIO SERVICIO");
			lblFormularioServicio.setFont(new Font("Stencil", Font.PLAIN, 16));
			lblFormularioServicio.setBounds(77, 11, 182, 14);
			contentPanel.add(lblFormularioServicio);
		}
		{
			JLabel lblCodigo = new JLabel("Codigo:");
			lblCodigo.setBounds(10, 39, 46, 14);
			contentPanel.add(lblCodigo);
		}
		{
			JLabel lblNombre = new JLabel("Nombre:");
			lblNombre.setBounds(10, 74, 46, 14);
			contentPanel.add(lblNombre);
		}
		{
			JLabel lblDescripcion = new JLabel("Descripcion:");
			lblDescripcion.setBounds(10, 99, 74, 14);
			contentPanel.add(lblDescripcion);
		}
		{
			JLabel lblValorUnitario = new JLabel("Valor Unitario:");
			lblValorUnitario.setBounds(10, 132, 85, 14);
			contentPanel.add(lblValorUnitario);
		}
		{
			JLabel lblEstado = new JLabel("Estado:");
			lblEstado.setBounds(10, 167, 46, 14);
			contentPanel.add(lblEstado);
		}
		
		tfCodigo = new JTextField();
		tfCodigo.setBounds(66, 36, 86, 20);
		contentPanel.add(tfCodigo);
		tfCodigo.setColumns(10);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(66, 71, 141, 20);
		contentPanel.add(tfNombre);
		tfNombre.setColumns(10);
		
		tfDescripcion = new JTextField();
		tfDescripcion.setBounds(89, 96, 215, 20);
		contentPanel.add(tfDescripcion);
		tfDescripcion.setColumns(10);
		
		tfUnitario = new JTextField();
		tfUnitario.setBounds(89, 129, 86, 20);
		contentPanel.add(tfUnitario);
		tfUnitario.setColumns(10);
		
		chActivo = new JCheckBox("Activo");
		chActivo.setBounds(62, 163, 97, 23);
		contentPanel.add(chActivo);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultarServicioPorCodigo();
			}
		});
		btnBuscar.setBounds(239, 35, 89, 23);
		contentPanel.add(btnBuscar);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarServicio();
			}
		});
		btnGuardar.setBounds(10, 210, 89, 23);
		contentPanel.add(btnGuardar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editarServicio();
			}
		});
		btnModificar.setBounds(136, 210, 89, 23);
		contentPanel.add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletarServicio();
			}
		});
		btnEliminar.setBounds(239, 210, 89, 23);
		contentPanel.add(btnEliminar);
	}
	
	private void registrarServicio(){
		Servicio servicio = new Servicio();
		servicio.setNombre(tfNombre.getText());
		servicio.setDescripcion(tfDescripcion.getText());
		servicio.setValor_unitario(Double.parseDouble(tfUnitario.getText()));
		servicio.setEstado(chActivo.isSelected());
		
		ServicioDao.guardarServicio(servicio);
		limpiarCampos();
	}
	
	private void consultarServicioPorCodigo(){
		
		int codigo = Integer.parseInt(tfCodigo.getText());
		
		Servicio servicio = ServicioDao.recuperarServicioPorCodigo(codigo);
		
		System.out.println(servicio);
		
		if(servicio != null){
			tfNombre.setText(servicio.getNombre());
			tfDescripcion.setText(servicio.getDescripcion());
			tfUnitario.setText(servicio.getValor_unitario()+"");
			chActivo.setSelected(servicio.isEstado());
		}
	}
	
	private void editarServicio(){
		Servicio servicio = new Servicio();
		servicio.setCodigo(Integer.parseInt(tfCodigo.getText()));
		servicio.setNombre(tfNombre.getText());
		servicio.setDescripcion(tfDescripcion.getText());
		servicio.setValor_unitario(Double.parseDouble(tfUnitario.getText()));
		servicio.setEstado(chActivo.isSelected());
		ServicioDao.modificarServicio(servicio);
		limpiarCampos();
	}
	
	private void deletarServicio(){
		int codigo = Integer.parseInt(tfCodigo.getText());
		ServicioDao.eliminarServicio(codigo);
		limpiarCampos();
	}
	
	private void limpiarCampos(){
		tfCodigo.setText("");
		tfNombre.setText("");
		tfDescripcion.setText("");
		tfUnitario.setText("");
		chActivo.setSelected(false);
	}
}
