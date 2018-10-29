package uy.edu.cei.Obligatorio.Client.ui;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.SpringLayout;
import javax.swing.JList;
import java.awt.GridBagLayout;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Probando {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Probando window = new Probando();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Probando() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JList list = new JList();
		springLayout.putConstraint(SpringLayout.NORTH, list, 102, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, list, 292, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, list, -10, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, list, -10, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(list);
		
		DefaultListModel dlm = new DefaultListModel();
		dlm.addElement("mauro");
		dlm.addElement("pepe");
		dlm.addElement("lautaro");
		list.setModel(dlm);
		
		JComboBox comboBox = new JComboBox();
		springLayout.putConstraint(SpringLayout.NORTH, comboBox, 52, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, comboBox, 32, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, comboBox, 77, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, comboBox, 60, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(comboBox);
		
		comboBox.addItem("dasdas");
		comboBox.addItem("loco");
		
		JButton btnAgregar = new JButton("agregar");
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText((String) comboBox.getSelectedItem());
				textField_1.setText((String) list.getSelectedValue());
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnAgregar, 80, SpringLayout.SOUTH, comboBox);
		springLayout.putConstraint(SpringLayout.WEST, btnAgregar, 28, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(btnAgregar);
		
		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField, 29, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, textField, 99, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_1, 0, SpringLayout.NORTH, textField);
		springLayout.putConstraint(SpringLayout.WEST, textField_1, 63, SpringLayout.EAST, textField);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblGente = new JLabel("gente");
		springLayout.putConstraint(SpringLayout.SOUTH, lblGente, -6, SpringLayout.NORTH, list);
		springLayout.putConstraint(SpringLayout.EAST, lblGente, -56, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(lblGente);
	}
}
