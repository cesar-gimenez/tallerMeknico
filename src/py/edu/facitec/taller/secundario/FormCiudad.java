package py.edu.facitec.taller.secundario;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;

import py.edu.facitec.taller.dao.CiudadDao;
import py.edu.facitec.taller.entidad.Ciudad;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FormCiudad extends JDialog {
	private JTextField tfCodigo;
	private JTextField tfNombre;
	private JTextField tfIso;
	private JCheckBox chActivo;
	private JButton btnBuscar;
	private JButton btnGuardar;
	private JButton btnModificar;
	private JButton btnEliminar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormCiudad dialog = new FormCiudad();
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
	public FormCiudad() {
		setBounds(100, 100, 371, 300);
		getContentPane().setLayout(null);
		
		JLabel lblFormularioCiudad = new JLabel("Formulario Ciudad");
		lblFormularioCiudad.setFont(new Font("Stencil", Font.PLAIN, 16));
		lblFormularioCiudad.setBounds(89, 11, 171, 14);
		getContentPane().add(lblFormularioCiudad);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(11, 53, 46, 14);
		getContentPane().add(lblCodigo);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(11, 88, 46, 14);
		getContentPane().add(lblNombre);
		
		JLabel lblIso = new JLabel("Iso:");
		lblIso.setBounds(11, 130, 46, 14);
		getContentPane().add(lblIso);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(11, 171, 46, 14);
		getContentPane().add(lblEstado);
		
		tfCodigo = new JTextField();
		tfCodigo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					tfNombre.requestFocus();
				}
			}
		});
		tfCodigo.setBounds(67, 50, 86, 20);
		getContentPane().add(tfCodigo);
		tfCodigo.setColumns(10);
		
		tfNombre = new JTextField();
		tfNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					tfIso.requestFocus();
				}
			}
		});
		tfNombre.setBounds(67, 85, 282, 20);
		getContentPane().add(tfNombre);
		tfNombre.setColumns(10);
		
		tfIso = new JTextField();
		tfIso.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					chActivo.requestFocus();
				}
			}
		});
		tfIso.setBounds(67, 127, 86, 20);
		getContentPane().add(tfIso);
		tfIso.setColumns(10);
		
		chActivo = new JCheckBox("Activo");
		chActivo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					btnGuardar.requestFocus();
				}
			}
		});
		chActivo.setBounds(67, 167, 97, 23);
		getContentPane().add(chActivo);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				consultarCiudadPorCodigo();
			}
		});
		btnBuscar.setBounds(260, 49, 89, 23);
		getContentPane().add(btnBuscar);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addKeyListener(new KeyAdapter() {
		
		});
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				registrarCiudad();
			}
		});
		btnGuardar.setBounds(11, 227, 89, 23);
		getContentPane().add(btnGuardar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addKeyListener(new KeyAdapter() {
		
		});
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editarCiudad();
			}
		});
		btnModificar.setBounds(128, 227, 89, 23);
		getContentPane().add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addKeyListener(new KeyAdapter() {
		
		});
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletarCiudad();
			}
		});
		btnEliminar.setBounds(244, 227, 89, 23);
		getContentPane().add(btnEliminar);

	}
	
	private void registrarCiudad(){
		Ciudad ciudad = new Ciudad();
		if(tfNombre.getText().isEmpty()){
			JOptionPane.showConfirmDialog(null, "campo Nombre obligatorio");
			tfNombre.requestFocus();
		}
		if(tfIso.getText().isEmpty()){
			JOptionPane.showConfirmDialog(null, "campo Iso obligatorio");
			tfIso.requestFocus();
			
		}
		
		if(!tfNombre.getText().isEmpty()&& !tfIso.getText().isEmpty()){
			ciudad.setNombre(tfNombre.getText());
			ciudad.setIso(tfIso.getText());
			ciudad.setEstado(chActivo.isSelected());
			
			CiudadDao.guardarCiudad(ciudad);
			limpiarCampos();
			
		}
		
	}
	
	private void consultarCiudadPorCodigo(){
		
		int codigo = Integer.parseInt(tfCodigo.getText());
		Ciudad ciudad = CiudadDao.recuperarCiudadPorCodigo(codigo);
		
		System.out.println(ciudad);
		
		if(ciudad != null){
			tfNombre.setText(ciudad.getNombre());
			tfIso.setText(ciudad.getIso());
			chActivo.setSelected(ciudad.isEstado());
		}
		
	}
	
	private void editarCiudad(){
		Ciudad ciudad = new Ciudad();
		ciudad.setCodigo(Integer.parseInt(tfCodigo.getText()));
		ciudad.setNombre(tfNombre.getText());
		ciudad.setIso(tfIso.getText());
		ciudad.setEstado(chActivo.isSelected());
		CiudadDao.modificarCiudad(ciudad);
		limpiarCampos();
	}
	
	private void deletarCiudad(){
		int codigo = Integer.parseInt(tfCodigo.getText());
		CiudadDao.eliminarCiudad(codigo);
		limpiarCampos();
		
	}
	private void limpiarCampos(){
		tfCodigo.setText("");
		tfNombre.setText("");
		tfIso.setText("");
		chActivo.setSelected(false);
	
	}
}
