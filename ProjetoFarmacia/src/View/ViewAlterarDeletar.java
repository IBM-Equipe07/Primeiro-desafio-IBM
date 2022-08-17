package View;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import BDController.Sistema;

public class ViewAlterarDeletar extends JPanel {
	private Connection connection=null;
	private java.sql.Statement statement=null;
	private ResultSet resultset=null;
	
	private JPanel contentPane;
	private JTextField txtIdCliente;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtTelefone;
	private JTextField txtEmail;
	private JTextField inputLogradouro;
	private JTextField inputNumero;
	private JTextField inputUF;
	private JTextField inputCEP;
	private JTextField inputCidade;
	private JTextField inputComplemento;
	private JTextField inputBairro;
	private JLabel titleLogradouro;
	private JLabel titleCEP;
	private JLabel titleCidade;
	private JLabel titleComplemento;
	private JLabel titleBairro;
	private JLabel titleUF;
	private JLabel titleNumero;
	private JPanel buttonDeletar;
	private JPanel buttonAlterarCliente;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JPanel buttonAlterarEndereco;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	/**
	 * Create the panel.
	 */
	public ViewAlterarDeletar() {
		setBounds(0, 0, 547, 567);
		setBackground(new Color(217, 217, 217));
		setLayout(null);
		
		
		Sistema executar = new Sistema();
		executar.conectar();
		


//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Alterar e deletar cadastro de clientes");
		lblNewLabel.setLocation(112, 235);

		add(lblNewLabel);
		
		
		Panel panel = new Panel();
		panel.setBounds(107, 108, 327, 2);
		add(panel);
		panel.setBackground(new Color(32, 92, 109));
		
		JLabel buttonPesquisar = new JLabel("");
		buttonPesquisar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonPesquisar.setIcon(new ImageIcon(ViewListagem.class.getResource("/View/image/pesquisar.png")));
		buttonPesquisar.setBounds(405, 82, 33, 27);
		add(buttonPesquisar);
		JTextField inputPesquisar = new JTextField();
		inputPesquisar.setToolTipText("pesquise aqui");
		inputPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		inputPesquisar.setBounds(132, 80, 269, 27);
		add(inputPesquisar);
		inputPesquisar.setColumns(10);
		setVisible(true);
		inputPesquisar.setBackground(new Color(217, 217, 217));
		inputPesquisar.setBorder(null);
		
		buttonPesquisar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String search = inputPesquisar.getText();
				String[] lista;
				String[] listEnd;
				lista = executar.getClienteID(search);
			
				listEnd = executar.getEnderecoID(lista[0]);
				
				
				txtIdCliente.setText(lista[0]);
				txtNome.setText(lista[1]);
				txtEmail.setText(lista[2]);
				txtCpf.setText(lista[3]);
				txtTelefone.setText(lista[4]);
				
				inputLogradouro.setText(listEnd[0]);
				inputCEP.setText(listEnd[1]);
				inputCidade.setText(listEnd[2]);
				inputNumero.setText(listEnd[3]);
				inputComplemento.setText(listEnd[4]);
				inputBairro.setText(listEnd[5]);
				inputUF.setText(listEnd[6]);
				
			
				
			}
		});
	
		
		
		
		JLabel lblNewLabel_1 = new JLabel("ID ");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_1.setBounds(51, 138, 33, 37);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("NOME");
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(135, 142, 67, 28);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("CPF");
		lblNewLabel_1_2.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(92, 203, 67, 28);
		add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("TELEFONE");
		lblNewLabel_1_3.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_1_3.setBounds(384, 142, 88, 28);
		add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("EMAIL");
		lblNewLabel_1_4.setFont(new Font("Dialog", Font.BOLD, 14));
//		lblNewtFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_1_4.setBounds(251, 205, 67, 25);
		add(lblNewLabel_1_4);
		
		
		
		txtIdCliente = new JTextField();
		txtIdCliente.setBounds(48, 166, 60, 25);
		add(txtIdCliente);
		txtIdCliente.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(132, 166, 214, 25);
		add(txtNome);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(248, 230, 224, 25);
		add(txtEmail);
		
		txtCpf = new JTextField();
		txtCpf.setColumns(10);
		txtCpf.setBounds(90, 230, 133, 25);
		add(txtCpf);
		
		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(371, 166, 128, 25);
		add(txtTelefone);
		
		inputLogradouro = new JTextField();
		inputLogradouro.setColumns(10);
		inputLogradouro.setBounds(51, 313, 451, 25);
		add(inputLogradouro);
		
		inputNumero = new JTextField();
		inputNumero.setColumns(10);
		inputNumero.setBounds(443, 371, 59, 25);
		add(inputNumero);
		
		inputUF = new JTextField();
		inputUF.setColumns(10);
		inputUF.setBounds(443, 432, 59, 25);
		add(inputUF);
		
		inputCEP = new JTextField();
		inputCEP.setColumns(10);
		inputCEP.setBounds(54, 371, 133, 25);
		add(inputCEP);
		
		inputCidade = new JTextField();
		inputCidade.setColumns(10);
		inputCidade.setBounds(208, 371, 214, 25);
		add(inputCidade);
		
		inputComplemento = new JTextField();
		inputComplemento.setColumns(10);
		inputComplemento.setBounds(54, 432, 214, 25);
		add(inputComplemento);
		
		inputBairro = new JTextField();
		inputBairro.setColumns(10);
		inputBairro.setBounds(289, 432, 133, 25);
		add(inputBairro);
		
		titleLogradouro = new JLabel("LOGRADOURO");
		titleLogradouro.setFont(new Font("Dialog", Font.BOLD, 14));
		titleLogradouro.setBounds(51, 289, 154, 25);
		add(titleLogradouro);
		
		titleCEP = new JLabel("CEP");
		titleCEP.setFont(new Font("Dialog", Font.BOLD, 14));
		titleCEP.setBounds(54, 349, 88, 25);
		add(titleCEP);
		
		titleCidade = new JLabel("CIDADE");
		titleCidade.setFont(new Font("Dialog", Font.BOLD, 14));
		titleCidade.setBounds(208, 349, 88, 25);
		add(titleCidade);
		
		titleComplemento = new JLabel("COMPLEMENTO");
		titleComplemento.setFont(new Font("Dialog", Font.BOLD, 14));
		titleComplemento.setBounds(54, 407, 151, 25);
		add(titleComplemento);
		
		titleBairro = new JLabel("BAIRRO");
		titleBairro.setFont(new Font("Dialog", Font.BOLD, 14));
		titleBairro.setBounds(289, 407, 88, 25);
		add(titleBairro);
		
		titleUF = new JLabel("UF");
		titleUF.setFont(new Font("Dialog", Font.BOLD, 14));
		titleUF.setBounds(443, 407, 33, 25);
		add(titleUF);
		
		titleNumero = new JLabel("NUMERO");
		titleNumero.setFont(new Font("Dialog", Font.BOLD, 14));
		titleNumero.setBounds(442, 349, 72, 25);
		add(titleNumero);
		
		buttonDeletar = new JPanel();
		buttonDeletar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				executar.DeletarClientes(Integer.parseInt(txtIdCliente.getText()));
				JOptionPane.showMessageDialog(buttonDeletar, "CLIENTE EXCLUIDO COM SUCESSO");
			}
		});
		
		buttonDeletar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonDeletar.setBounds(366, 496, 133, 37);
		add(buttonDeletar);
		buttonDeletar.setLayout(null);
		buttonDeletar.setBackground(new Color(32, 92, 109));
		
		lblNewLabel_3 = new JLabel("DELETAR");
		lblNewLabel_3.setBounds(34, 9, 63, 19);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 14));
		buttonDeletar.add(lblNewLabel_3);
		
		buttonAlterarCliente = new JPanel();
		buttonAlterarCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				executar.AlterarClientes(Integer.parseInt(
						
					txtIdCliente.getText()),
					txtNome.getText(),
					txtCpf.getText(),
					txtEmail.getText(),
					txtTelefone.getText());
				
				JOptionPane.showMessageDialog(buttonAlterarCliente, "CLIENTE ALTERADO COM SUCESSO");
				
			}
		});
		
		
		buttonAlterarCliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonAlterarCliente.setBounds(51, 496, 133, 37);
		add(buttonAlterarCliente);
		buttonAlterarCliente.setLayout(null);
		buttonAlterarCliente.setBackground(new Color(32, 92, 109));
		
		lblNewLabel_2 = new JLabel("ALTERAR CLIENTE");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNewLabel_2.setBounds(15, 0, 103, 37);
		buttonAlterarCliente.add(lblNewLabel_2);
		
		buttonAlterarEndereco = new JPanel();
		buttonAlterarEndereco.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				executar.AlterarEndereco(Integer.parseInt(
						
					txtIdCliente.getText()), 
					inputLogradouro.getText(),
					inputNumero.getText(),
					inputComplemento.getText(),
					inputBairro.getText(),
					inputCidade.getText(),
					inputCEP.getText(),
					inputUF.getText());
					
					JOptionPane.showMessageDialog(buttonAlterarCliente, "ENDEREÇO ALTERADO COM SUCESSO");
			}
		});
		
		buttonAlterarEndereco.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonAlterarEndereco.setLayout(null);
		buttonAlterarEndereco.setBounds(211, 496, 133, 37);
		add(buttonAlterarEndereco);
		buttonAlterarEndereco.setBackground(new Color(32, 92, 109));
		
		lblNewLabel_4 = new JLabel("ALTERAR ENDEREÇO");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNewLabel_4.setBounds(8, 0, 118, 37);
		buttonAlterarEndereco.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("ID ");
		lblNewLabel_5.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_5.setBounds(109, 73, 33, 37);
		add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel(">> ALTERAR E DELETAR <<");
		lblNewLabel_6.setForeground(new Color(32, 92, 109));
		lblNewLabel_6.setFont(new Font("Artifakt Element Black", Font.PLAIN, 17));
		lblNewLabel_6.setBounds(162, 11, 224, 42);
		add(lblNewLabel_6);

	}
}

