package core;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;


public class recebeCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField campo_nome;
	private JTextField campo_email;
	private JTextField campo_endereco;
	private JTextField campo_cidade;
	private JTextField campo_num;
	private JTextField campo_complemento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					recebeCadastro frame = new recebeCadastro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace(); 
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public recebeCadastro() throws ParseException {
		
		Sistema executar = new Sistema();
		executar.conectar();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 582, 555);
		contentPane = new JPanel();
		contentPane.setToolTipText("Dados");
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_dados = new JPanel();
		panel_dados.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel_dados.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Dados pessoais", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_dados.setToolTipText("");
		panel_dados.setBounds(10, 45, 546, 185);
		contentPane.add(panel_dados);
		panel_dados.setLayout(null);
		
		JLabel text_nome = new JLabel("Nome:");
		text_nome.setBounds(10, 24, 46, 14);
		panel_dados.add(text_nome);
		
		campo_nome = new JTextField();
		campo_nome.setBounds(10, 44, 507, 20);
		panel_dados.add(campo_nome);
		campo_nome.setColumns(10);
		
		JLabel text_cpf = new JLabel("CPF:");
		text_cpf.setBounds(10, 75, 46, 14);
		panel_dados.add(text_cpf);
		
		JLabel text_telefone = new JLabel("Telefone:");
		text_telefone.setBounds(10, 131, 74, 14);
		panel_dados.add(text_telefone);
		
		JLabel text_email = new JLabel("Email:");
		text_email.setBounds(240, 75, 46, 14);
		panel_dados.add(text_email);
		
		campo_email = new JTextField();
		campo_email.setBounds(238, 95, 279, 20);
		panel_dados.add(campo_email);
		campo_email.setColumns(10);
		
		JFormattedTextField campo_cpf = new JFormattedTextField();
		MaskFormatter mask_cpf = new MaskFormatter("###.###.###-##");
		mask_cpf.install(campo_cpf);
		campo_cpf.setToolTipText("");
		campo_cpf.setBounds(10, 95, 194, 20);
		panel_dados.add(campo_cpf);
		
		JFormattedTextField campo_tel = new JFormattedTextField();
		MaskFormatter mask_tel = new MaskFormatter("(##) #####-####");
		mask_tel.install(campo_tel);
		campo_tel.setBounds(10, 150, 194, 20);
		panel_dados.add(campo_tel);
		
		JLabel ob1 = new JLabel("*");
		ob1.setForeground(Color.RED);
		ob1.setBounds(520, 47, 9, 14);
		panel_dados.add(ob1);
		
		JLabel ob3 = new JLabel("*");
		ob3.setForeground(Color.RED);
		ob3.setBounds(520, 95, 9, 14);
		panel_dados.add(ob3);
		
		JLabel ob2 = new JLabel("*");
		ob2.setForeground(Color.RED);
		ob2.setBounds(208, 95, 9, 14); 
		panel_dados.add(ob2);
		
		JLabel ob4 = new JLabel("*");
		ob4.setForeground(Color.RED);
		ob4.setBounds(208, 150, 9, 14);
		panel_dados.add(ob4);
		
		JLabel title1 = new JLabel("Cadastro de Pessoa Física");
		title1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		title1.setBounds(10, 11, 191, 25);
		contentPane.add(title1);
		
		JPanel panel_endereco = new JPanel();
		panel_endereco.setForeground(Color.RED);
		panel_endereco.setLayout(null);
		panel_endereco.setToolTipText("");
		panel_endereco.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel_endereco.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Dados de endereço", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_endereco.setBounds(10, 242, 546, 194);
		contentPane.add(panel_endereco);
		
		JLabel text_logradouro = new JLabel("Logradouro:");
		text_logradouro.setBounds(10, 26, 79, 14);
		panel_endereco.add(text_logradouro);
		
		campo_endereco = new JTextField();
		campo_endereco.setColumns(10);
		campo_endereco.setBounds(10, 44, 507, 20);
		panel_endereco.add(campo_endereco);
		
		JLabel text_bairro = new JLabel("Bairro:");
		text_bairro.setBounds(10, 128, 46, 14);
		panel_endereco.add(text_bairro);
		
		JLabel text_estado = new JLabel("U.F.:");
		text_estado.setBounds(454, 128, 46, 14);
		panel_endereco.add(text_estado);
		
		JLabel text_cidade = new JLabel("Cidade:");
		text_cidade.setBounds(295, 128, 46, 14);
		panel_endereco.add(text_cidade);
		
		campo_cidade = new JTextField();
		campo_cidade.setColumns(10);
		campo_cidade.setBounds(295, 144, 134, 20);
		panel_endereco.add(campo_cidade);
		
		JFormattedTextField campo_bairro = new JFormattedTextField();
		campo_bairro.setBounds(10, 144, 186, 20);
		panel_endereco.add(campo_bairro);
		
		JComboBox campo_uf = new JComboBox();
		campo_uf.setMaximumRowCount(3);
		campo_uf.setAutoscrolls(true);
		campo_uf.setModel(new DefaultComboBoxModel(new String[] {"", "RO", "AC", "AM", "RR", "PA", "AP", "TO", "MA", "PI", "CE", "RN", "PB", "PE", "AL", "SE", "BA", "MG", "ES", "RJ", "SP", "PR", "SC", "RS", "MS", "MT", "GO", "DF"}));
		campo_uf.setBackground(Color.WHITE);
		campo_uf.setForeground(Color.BLACK);
		campo_uf.setBounds(454, 144, 63, 20);
		panel_endereco.add(campo_uf);
		
		JLabel ob5 = new JLabel("*");
		ob5.setForeground(Color.RED);
		ob5.setBounds(520, 44, 9, 14);
		panel_endereco.add(ob5);
		
		JLabel ob6 = new JLabel("*");
		ob6.setForeground(Color.RED);
		ob6.setBounds(198, 147, 9, 14);
		panel_endereco.add(ob6);
		
		JLabel ob7 = new JLabel("*");
		ob7.setForeground(Color.RED);
		ob7.setBounds(431, 147, 9, 14);
		panel_endereco.add(ob7);
		
		JLabel ob8 = new JLabel("*");
		ob8.setForeground(Color.RED);
		ob8.setBounds(520, 147, 9, 14);
		panel_endereco.add(ob8);
		
		JLabel text_num = new JLabel("Número:");
		text_num.setBounds(217, 128, 63, 14);
		panel_endereco.add(text_num);
		
		campo_num = new JTextField();
		campo_num.setColumns(10);
		campo_num.setBounds(217, 144, 57, 20);
		panel_endereco.add(campo_num);
		
		JLabel ob9 = new JLabel("*");
		ob9.setForeground(Color.RED);
		ob9.setBounds(276, 147, 9, 14);
		panel_endereco.add(ob9);
		
		campo_complemento = new JTextField();
		campo_complemento.setColumns(10);
		campo_complemento.setBounds(10, 92, 281, 20);
		panel_endereco.add(campo_complemento);
		
		JLabel text_logradouro_1 = new JLabel("Complemento:");
		text_logradouro_1.setBounds(10, 75, 144, 14);
		panel_endereco.add(text_logradouro_1);
		
		JLabel text_num_1 = new JLabel("CEP:");
		text_num_1.setBounds(401, 75, 63, 14);
		panel_endereco.add(text_num_1);
		
		JFormattedTextField campo_cep = new JFormattedTextField();
		campo_cep.setBounds(401, 92, 116, 20);
		panel_endereco.add(campo_cep);
		
		JLabel ob10 = new JLabel("*");
		ob10.setForeground(Color.RED);
		ob10.setBounds(520, 92, 9, 14);
		panel_endereco.add(ob10);
		
		JButton btn_buscar = new JButton("Buscar");
		btn_buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_buscar.setBounds(306, 91, 89, 20);
		panel_endereco.add(btn_buscar);
		
		JButton btn_Sair = new JButton("Sair");
		btn_Sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		}); 
		
		btn_Sair.setAutoscrolls(true);
		btn_Sair.setBounds(467, 482, 89, 23);
		contentPane.add(btn_Sair);
		
		JButton btn_inserir = new JButton("Salvar");
		btn_inserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				executar.inserirClientes(campo_nome.getText(),campo_cpf.getText(),campo_tel.getText(),campo_email.getText());
				//executar.inserirEndereco();
				if(campo_nome.getText().trim().equals("") || campo_cpf.getText().trim().equals("") || campo_tel.getText().trim().equals("") || campo_email.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(btn_inserir, "Preencha todos os campos obrigatórios!");
				}else {
					JOptionPane.showMessageDialog(btn_inserir, "Cliente cadastrado!");
				}
			}
			
		});
		btn_inserir.setBounds(230, 447, 89, 23); 
		contentPane.add(btn_inserir); 
	}
}

//executa o select 
