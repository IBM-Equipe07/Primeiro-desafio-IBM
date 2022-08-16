package core;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class AlterarCadastroJF extends JFrame {

	private Connection connection=null;
	private java.sql.Statement statement=null;
	private ResultSet resultset=null;
	
	private JPanel contentPane;
	private JTextField txtIdCliente;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtTelefone;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlterarCadastroJF frame = new AlterarCadastroJF();
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
	public AlterarCadastroJF() {
		//Se conecta com o banco e com os métodos
		Sistema executar = new Sistema();
		executar.conectar();
		
		String[] cliente = executar.getClienteID("1");
		
		setTitle("Alterar e Deletar Cadastro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 471, 311);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Alterar e deletar cadastro de clientes");
		lblNewLabel.setBounds(10, 11, 237, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID do cliente");
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(10, 36, 80, 28);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nome:");
		lblNewLabel_1_1.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(10, 88, 67, 28);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("CPF");
		lblNewLabel_1_2.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_1_2.setBounds(10, 130, 67, 28);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Telefone");
		lblNewLabel_1_3.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_1_3.setBounds(10, 169, 67, 28);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Email: ");
		lblNewLabel_1_4.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_1_4.setBounds(10, 208, 67, 28);
		contentPane.add(lblNewLabel_1_4);
		
		
		
		txtIdCliente = new JTextField();
		txtIdCliente.setBounds(88, 41, 44, 20);
		txtIdCliente.setText(txtIdCliente.getText() + cliente[0]);
		contentPane.add(txtIdCliente);
		txtIdCliente.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setText(txtNome.getText() + cliente[1]);
		txtNome.setBounds(87, 93, 224, 20);
		contentPane.add(txtNome);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setText(txtEmail.getText() + cliente[2]);
		txtEmail.setBounds(87, 213, 224, 20);
		contentPane.add(txtEmail);
		
		txtCpf = new JTextField();
		txtCpf.setColumns(10);
		txtCpf.setText(txtCpf.getText() + cliente[3]);
		txtCpf.setBounds(87, 135, 116, 20);
		contentPane.add(txtCpf);
		
		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		txtTelefone.setText(txtTelefone.getText() + cliente[4]);
		txtTelefone.setBounds(87, 174, 116, 20);
		contentPane.add(txtTelefone);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBackground(new Color(0, 128, 128));
		btnAlterar.setForeground(new Color(255, 255, 255));
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				executar.AlterarClientes(Integer.parseInt(txtIdCliente.getText()), txtNome.getText(), txtCpf.getText(), txtTelefone.getText(), txtEmail.getText());
				if(txtIdCliente.getText().trim().equals("") || txtNome.getText().trim().equals("") || txtCpf.getText().trim().equals("") || txtTelefone.getText().trim().equals("") || txtEmail.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(btnAlterar, "Preencha todos os campos obrigatórios!");
				}
				else {
					JOptionPane.showMessageDialog(btnAlterar, "Cliente alterado com sucesso!");
				}
			}
		});
		btnAlterar.setBounds(335, 212, 110, 23);
		contentPane.add(btnAlterar);
		
		JButton btnDelete = new JButton("Deletar");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				executar.DeletarClientes(Integer.parseInt(txtIdCliente.getText()));
				if(txtIdCliente.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(btnDelete, "Preencha todos os campos obrigatórios!");
				}
				else {
					JOptionPane.showMessageDialog(btnDelete, "Cliente excluído com sucesso");
				}
			}
		});
		btnDelete.setForeground(new Color(255, 255, 255));
		btnDelete.setBackground(new Color(0, 128, 128));
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDelete.setBounds(142, 39, 110, 23);
		contentPane.add(btnDelete);
	}
}
