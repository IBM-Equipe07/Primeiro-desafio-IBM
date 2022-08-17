package View;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import BDController.Sistema;

public class ViewCadastroClientes extends JPanel {

	/**
	 * Create the panel.
	 */
	public ViewCadastroClientes() {
		Sistema executar = new Sistema();
		executar.conectar();

		setBounds(0, 0, 547, 567);
		setBackground(new Color(217, 217, 217));
		setLayout(null);

		
		JLabel lblNewLabel = new JLabel("Alterar e deletar cadastro de clientes");
		lblNewLabel.setLocation(112, 235);

		add(lblNewLabel);
		setVisible(true);
		
		JLabel lblNewLabel_1_1 = new JLabel("NOME");
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(89, 114, 67, 28);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("CPF");
		lblNewLabel_1_2.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(86, 174, 67, 28);
		add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("TELEFONE");
		lblNewLabel_1_3.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_1_3.setBounds(325, 114, 88, 28);
		add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("EMAIL");
		lblNewLabel_1_4.setFont(new Font("Dialog", Font.BOLD, 14));
//		lblNewtFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_1_4.setBounds(245, 176, 67, 25);
		add(lblNewLabel_1_4);
		
		JTextField txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(86, 138, 214, 25);
		add(txtNome);
		
		JTextField txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(242, 201, 224, 25);
		add(txtEmail);
		
		JTextField txtCpf = new JTextField();
		txtCpf.setColumns(10);
		txtCpf.setBounds(84, 201, 133, 25);
		add(txtCpf);
		
		JTextField txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(325, 138, 141, 25);
		add(txtTelefone);
		
		JTextField inputLogradouro = new JTextField();
		inputLogradouro.setColumns(10);
		inputLogradouro.setBounds(45, 284, 451, 25);
		add(inputLogradouro);
		
		JTextField inputNumero = new JTextField();
		inputNumero.setColumns(10);
		inputNumero.setBounds(437, 342, 59, 25);
		add(inputNumero);
		
		JTextField inputUF = new JTextField();
		inputUF.setColumns(10);
		inputUF.setBounds(437, 403, 59, 25);
		add(inputUF);
		
		JTextField inputCEP = new JTextField();
		inputCEP.setColumns(10);
		inputCEP.setBounds(48, 342, 133, 25);
		add(inputCEP);
		
		JTextField inputCidade = new JTextField();
		inputCidade.setColumns(10);
		inputCidade.setBounds(202, 342, 214, 25);
<<<<<<< HEAD
		add(inputCidade);
=======
		add(inputCidade); 
>>>>>>> feat(insert-cliente-endereco)
		
		JTextField inputComplemento = new JTextField();
		inputComplemento.setColumns(10);
		inputComplemento.setBounds(48, 403, 214, 25);
		add(inputComplemento);
		
		JTextField inputBairro = new JTextField();
		inputBairro.setColumns(10);
		inputBairro.setBounds(283, 403, 133, 25);
		add(inputBairro);
		
		Component titleLogradouro = new JLabel("LOGRADOURO");
		titleLogradouro.setFont(new Font("Dialog", Font.BOLD, 14));
		titleLogradouro.setBounds(45, 260, 154, 25);
		add(titleLogradouro);
		
		JLabel titleCEP = new JLabel("CEP");
		titleCEP.setFont(new Font("Dialog", Font.BOLD, 14));
		titleCEP.setBounds(48, 320, 88, 25);
		add(titleCEP);
		
		Container titleCidade = new JLabel("CIDADE");
		titleCidade.setFont(new Font("Dialog", Font.BOLD, 14));
		titleCidade.setBounds(202, 320, 88, 25);
		add(titleCidade);
		
		Component titleComplemento = new JLabel("COMPLEMENTO");
		titleComplemento.setFont(new Font("Dialog", Font.BOLD, 14));
		titleComplemento.setBounds(48, 378, 151, 25);
		add(titleComplemento);
		
		Component titleBairro = new JLabel("BAIRRO");
		titleBairro.setFont(new Font("Dialog", Font.BOLD, 14));
		titleBairro.setBounds(283, 378, 88, 25);
		add(titleBairro);
		
		JLabel titleUF = new JLabel("UF");
		titleUF.setFont(new Font("Dialog", Font.BOLD, 14));
		titleUF.setBounds(437, 378, 33, 25);
		add(titleUF);
		
		Component titleNumero = new JLabel("NUMERO");
		titleNumero.setFont(new Font("Dialog", Font.BOLD, 14));
		titleNumero.setBounds(436, 320, 72, 25);
		add(titleNumero);
		
		JLabel lblNewLabel_3 = new JLabel("DELETAR");
		lblNewLabel_3.setBounds(34, 9, 63, 19);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JPanel cadastrarCliente = new JPanel();
		cadastrarCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txtNome.getText().trim().equals("") || txtCpf.getText().trim().equals("") || txtTelefone.getText().trim().equals("") || txtEmail.getText().trim().equals("")
						  || inputLogradouro.getText().trim().equals("") || inputNumero.getText().trim().equals("") || inputBairro.getText().trim().equals("") || inputCidade.getText().trim().equals("") || inputCEP.getText().trim().equals("") || inputUF.getText().trim().equals("")) {
							JOptionPane.showMessageDialog(cadastrarCliente, "Preencha todos os campos obrigatórios!");
						}else {
<<<<<<< HEAD
							executar.postToClientes(null, txtNome.getText(),txtCpf.getText(),txtTelefone.getText(),txtEmail.getText());
							executar.postToEndereco(null, inputLogradouro.getText(), inputNumero.getText(), inputComplemento.getText(), inputBairro.getText(), inputCidade.getText(), inputCEP.getText(), inputUF.getText());
							JOptionPane.showMessageDialog(cadastrarCliente, "Cliente cadastrado!");
						}
					}
				
=======
							executar.postToClientes(null, txtNome.getText(), txtEmail.getText(), txtCpf.getText(), txtTelefone.getText());
							executar.postToEndereco(null, inputLogradouro.getText(), inputNumero.getText(), inputComplemento.getText(), inputBairro.getText(), inputCidade.getText(), inputCEP.getText(), inputUF.getText());
							JOptionPane.showMessageDialog(cadastrarCliente, "Cliente cadastrado!");
						}
					}	
>>>>>>> feat(insert-cliente-endereco)

		});
		
		
		cadastrarCliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cadastrarCliente.setBounds(207, 473, 133, 37);
		add(cadastrarCliente);
		cadastrarCliente.setLayout(null);
		cadastrarCliente.setBackground(new Color(32, 92, 109));
		
		Component lblNewLabel_2 = new JLabel("CADASTRAR");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNewLabel_2.setBounds(30, 0, 103, 37);
		cadastrarCliente.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel(">>CADASTRAR CLIENTE<<");
		lblNewLabel_1.setFont(new Font("Artifakt Element Black", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(157, 11, 256, 49);
		lblNewLabel_1.setForeground(new Color(32, 92, 109));
		add(lblNewLabel_1);
		
		
		
	}

}
