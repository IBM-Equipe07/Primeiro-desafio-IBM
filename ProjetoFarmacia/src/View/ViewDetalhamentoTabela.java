package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BDController.Sistema;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class ViewDetalhamentoTabela extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewDetalhamentoTabela frame = new ViewDetalhamentoTabela();
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
	
	int x, y;
	public ViewDetalhamentoTabela(String id) {
		Sistema executar = new Sistema();
		executar.conectar();
		
		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 547, 567);
		setBackground(new Color(217, 217, 217));
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(0, 562, 547, 5);
		contentPane.add(panel_2);
		panel_2.setBackground(new Color(32, 92, 109));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 28, 5, 539);
		contentPane.add(panel_1);
		panel_1.setBackground(new Color(32, 92, 109));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(542, 28, 5, 539);
		contentPane.add(panel);
		panel.setBackground(new Color(32, 92, 109));
		
		JPanel BarraSuperior = new JPanel();
		BarraSuperior.setBackground(Color.WHITE);
		BarraSuperior.setBounds(0, 0, 547, 30);
		contentPane.add(BarraSuperior);
		BarraSuperior.setLayout(null);
		BarraSuperior.setBackground(new Color(32, 92, 109));
		
		JLabel btnClose = new JLabel("");
		BarraSuperior.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				
				int xx = e.getXOnScreen();
				int yy = e.getYOnScreen();
				setLocation(xx-x, yy-y);
				
				
			}
		});
		
		BarraSuperior.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				x = e.getX();
				y = e.getY();
			}
		});
		
		btnClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose(); 
			}
		});
		

		
		btnClose.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnClose.setBounds(522, 8, 15, 15);
		BarraSuperior.add(btnClose);
		btnClose.setIcon(new ImageIcon(ViewDetalhamentoTabela.class.getResource("/View/image/closWhite.png")));
		
		JLabel lblNewLabel = new JLabel("NOME:");
		lblNewLabel.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
		lblNewLabel.setBounds(59, 66, 64, 30);
		contentPane.add(lblNewLabel);
		
		JLabel txtNome = new JLabel("Nao Encontrado");
		txtNome.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
		txtNome.setBounds(59, 90, 421, 30);
		contentPane.add(txtNome);
		
		JLabel lblEmail = new JLabel("EMAIL:");
		lblEmail.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
		lblEmail.setBounds(59, 136, 64, 30);
		contentPane.add(lblEmail);
		
		JLabel txtEmail = new JLabel("Nao Encontrado");
		txtEmail.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
		txtEmail.setBounds(59, 160, 313, 30);
		contentPane.add(txtEmail);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
		lblCpf.setBounds(59, 201, 64, 30);
		contentPane.add(lblCpf);
		
		JLabel txtCPF = new JLabel("Nao Encontrado");
		txtCPF.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
		txtCPF.setBounds(59, 227, 148, 30);
		contentPane.add(txtCPF);
		
		JLabel txtTEL = new JLabel("Nao Encontrado");
		txtTEL.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
		txtTEL.setBounds(239, 227, 148, 30);
		contentPane.add(txtTEL);
		
		JLabel lblTel = new JLabel("TEL:");
		lblTel.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
		lblTel.setBounds(239, 201, 64, 30);
		contentPane.add(lblTel);
		
		JLabel txtID = new JLabel("Null");
		txtID.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
		txtID.setBounds(416, 225, 45, 30);
		contentPane.add(txtID);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
		lblId.setBounds(416, 201, 64, 30);
		contentPane.add(lblId);
		
		JLabel lblComplemento = new JLabel("LOGRADOURO:");
		lblComplemento.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
		lblComplemento.setBounds(59, 313, 195, 30);
		contentPane.add(lblComplemento);
		
		JLabel txtLogradouro = new JLabel("Nao Encontrado");
		txtLogradouro.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
		txtLogradouro.setBounds(59, 337, 421, 30);
		contentPane.add(txtLogradouro);
		
		JLabel txtComplemento = new JLabel("Nao Encontrado");
		txtComplemento.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
		txtComplemento.setBounds(59, 494, 148, 30);
		contentPane.add(txtComplemento);
		
		JLabel lblComplemento_1 = new JLabel("COMPLEMENTO:");
		lblComplemento_1.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
		lblComplemento_1.setBounds(59, 468, 148, 30);
		contentPane.add(lblComplemento_1);
		
		JLabel txtBairro = new JLabel("Nao Encontrado");
		txtBairro.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
		txtBairro.setBounds(239, 494, 148, 30);
		contentPane.add(txtBairro);
		
		JLabel lblBairro = new JLabel("BAIRRO:");
		lblBairro.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
		lblBairro.setBounds(239, 468, 89, 30);
		contentPane.add(lblBairro);
		
		JLabel lblUf = new JLabel("UF:");
		lblUf.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
		lblUf.setBounds(416, 468, 64, 30);
		contentPane.add(lblUf);
		
		JLabel txtUF = new JLabel("Null");
		txtUF.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
		txtUF.setBounds(416, 492, 53, 30);
		contentPane.add(txtUF);
		
		JLabel lblComplemento_1_1 = new JLabel("CEP:");
		lblComplemento_1_1.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
		lblComplemento_1_1.setBounds(59, 387, 148, 30);
		contentPane.add(lblComplemento_1_1);
		
		JLabel txtCEP = new JLabel("Nao Encontrado");
		txtCEP.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
		txtCEP.setBounds(59, 413, 148, 30);
		contentPane.add(txtCEP);
		
		JLabel lblCidade = new JLabel("CIDADE:");
		lblCidade.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
		lblCidade.setBounds(239, 387, 89, 30);
		contentPane.add(lblCidade);
		
		JLabel txtCidade = new JLabel("Nao Encontrado");
		txtCidade.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
		txtCidade.setBounds(239, 413, 148, 30);
		contentPane.add(txtCidade);
		
		JLabel txtNumero = new JLabel("Null");
		txtNumero.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
		txtNumero.setBounds(416, 411, 53, 30);
		contentPane.add(txtNumero);
		
		JLabel lblNumero = new JLabel("NUMERO:");
		lblNumero.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
		lblNumero.setBounds(416, 387, 89, 30);
		contentPane.add(lblNumero);
		
		String[] dadosCliente = executar.getClienteID(id);
		String[] dadosEndereco = executar.getEnderecoID(id);
		
		txtID.setText(dadosCliente[0]);
		txtNome.setText(dadosCliente[1]);
		txtEmail.setText(dadosCliente[2]);
		txtCPF.setText(dadosCliente[3]);
		txtTEL.setText(dadosCliente[4]);
		
		txtLogradouro.setText(dadosEndereco[0]);
		txtNumero.setText(dadosEndereco[1]);
		txtComplemento.setText(dadosEndereco[2]);
		txtBairro.setText(dadosEndereco[3]);
		txtCidade.setText(dadosEndereco[4]);
		txtCEP.setText(dadosEndereco[5]);
		txtUF.setText(dadosEndereco[6]);
		

	}
}
