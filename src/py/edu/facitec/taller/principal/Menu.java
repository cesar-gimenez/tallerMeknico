package py.edu.facitec.taller.principal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import py.edu.facitec.taller.secundario.FormCiudad;
import py.edu.facitec.taller.secundario.FormCliente;
import py.edu.facitec.taller.secundario.FormServicio;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnRegistro = new JMenu("Enlaces");
		menuBar.add(mnRegistro);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Ciudad");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verFormCiudad();
			}
		});
		mnRegistro.add(mntmNewMenuItem);
		
		JMenuItem mntmCliente = new JMenuItem("Cliente");
		mntmCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				verFormCLiente();
			}
		});
		mnRegistro.add(mntmCliente);
		
		JMenuItem mntmServicio = new JMenuItem("Servicio");
		mntmServicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				verFormServicio();
			}
		});
		mnRegistro.add(mntmServicio);
		
		JMenuItem mntmMantenimiento = new JMenuItem("Mantenimiento");
		mnRegistro.add(mntmMantenimiento);
		
		JMenuItem mntmDetalleMantenimiento = new JMenuItem("Detalle Mantenimiento");
		mnRegistro.add(mntmDetalleMantenimiento);
		
		JMenu mnRegistro_1 = new JMenu("Registro");
		menuBar.add(mnRegistro_1);
		
		JMenu mnInformes = new JMenu("Informes");
		menuBar.add(mnInformes);
		
		JMenu mnAcerca = new JMenu("Acerca");
		menuBar.add(mnAcerca);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TALLER MECANICO");
		lblNewLabel.setFont(new Font("Impact", Font.PLAIN, 40));
		lblNewLabel.setBounds(68, 68, 291, 61);
		contentPane.add(lblNewLabel);
	}
	
	public void verFormCiudad(){
		FormCiudad formCiudad = new FormCiudad();
		formCiudad.setVisible(true);
	}
	
	public void verFormCLiente(){
		FormCliente formCliente = new FormCliente();
		formCliente.setVisible(true);
	}
	
	public void verFormServicio(){
		FormServicio formServicio = new FormServicio();
		formServicio.setVisible(true);
	}
}
