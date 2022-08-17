package BDController;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class registraPedido extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField campo_cliente;
	private JTextField inputCampo_produto;
	private JTextField campo_total;
	private JTextField campo_unt;
	private JTextField campo_desconto;
	private JTextField campo_nome;
	private JTextField campo_idcompra;
	private JTextField campo_valodesc;
	private JTextField campo_valTotal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registraPedido frame = new registraPedido();
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
	public registraPedido() throws ParseException {
		
		Sistema executar = new Sistema();
		executar.conectar();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 289, 543);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		campo_cliente = new JTextField();
		campo_cliente.setBounds(10, 60, 86, 20);
		contentPane.add(campo_cliente);
		campo_cliente.setColumns(10);
		
		inputCampo_produto = new JTextField();
		inputCampo_produto.setBounds(10, 119, 95, 20);
		contentPane.add(inputCampo_produto);
		inputCampo_produto.setColumns(10);
		
		campo_total = new JTextField();
		campo_total.setBounds(193, 175, 67, 20);
		contentPane.add(campo_total);
		campo_total.setColumns(10);
		
		campo_unt = new JTextField();
		campo_unt.setBounds(10, 175, 67, 20);
		contentPane.add(campo_unt);
		campo_unt.setColumns(10);
		
		campo_desconto = new JTextField();
		campo_desconto.setBounds(101, 175, 67, 20);
		contentPane.add(campo_desconto);
		campo_desconto.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Código do cliente:");
		lblNewLabel.setBounds(10, 35, 111, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Código do produto:");
		lblNewLabel_1.setBounds(10, 94, 111, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Data:");
		lblNewLabel_2.setBounds(174, 35, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Valor unitário:");
		lblNewLabel_3.setBounds(10, 159, 67, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Desconto:");
		lblNewLabel_4.setBounds(101, 159, 75, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Valor final:");
		lblNewLabel_5.setBounds(193, 159, 75, 14);
		contentPane.add(lblNewLabel_5);
		
		JButton btn_buscarProduto = new JButton("Buscar");
		btn_buscarProduto.setBounds(109, 118, 89, 23);
		contentPane.add(btn_buscarProduto);
		
		JFormattedTextField campo_data = new JFormattedTextField();
		MaskFormatter mask_data = new MaskFormatter("##/##/####");
		mask_data.install(campo_data);
		campo_data.setBounds(174, 60, 86, 20);
		contentPane.add(campo_data);
		
		campo_nome = new JTextField();
		campo_nome.setBounds(10, 226, 250, 20);
		contentPane.add(campo_nome);
		campo_nome.setColumns(10);
		
		JLabel campo_nomeProd = new JLabel("Nome:");
		campo_nomeProd.setBounds(10, 210, 67, 14);
		contentPane.add(campo_nomeProd);
		
		JButton btn_sair = new JButton("Sair");
		btn_sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			} 
		});
		
		btn_sair.setBounds(79, 473, 89, 23);
		contentPane.add(btn_sair);
		
		JButton btn_cadastrar = new JButton("Cadastrar");
		btn_cadastrar.setBounds(75, 257, 111, 23);
		contentPane.add(btn_cadastrar);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Cadastro de pedido", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(0, 11, 268, 288);
		contentPane.add(panel);
		
		JLabel lblNewLabel_6 = new JLabel("Qtd.:");
		lblNewLabel_6.setBounds(101, 375, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Valor unt.:");
		lblNewLabel_7.setBounds(10, 375, 67, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Valor total:");
		lblNewLabel_8.setBounds(157, 373, 86, 19);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Nota fiscal:");
		lblNewLabel_9.setBounds(10, 327, 67, 14);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Código do pedido:");
		lblNewLabel_10.setBounds(155, 327, 105, 14);
		contentPane.add(lblNewLabel_10);
		
		JFormattedTextField campo_numsequencial = new JFormattedTextField();
		campo_numsequencial.setBounds(10, 344, 95, 20);
		contentPane.add(campo_numsequencial);
		
		campo_idcompra = new JTextField();
		campo_idcompra.setColumns(10);
		campo_idcompra.setBounds(155, 342, 105, 20);
		contentPane.add(campo_idcompra);
		
		campo_valodesc = new JTextField();
		campo_valodesc.setColumns(10);
		campo_valodesc.setBounds(10, 390, 67, 20);
		contentPane.add(campo_valodesc);
		
		JTextField campo_qtd = new JTextField();
		campo_qtd.setColumns(10);
		campo_qtd.setBounds(101, 390, 46, 20);
		contentPane.add(campo_qtd);
		
		campo_valTotal = new JTextField();
		campo_valTotal.setColumns(10);
		campo_valTotal.setBounds(157, 390, 103, 20);
		contentPane.add(campo_valTotal);
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Registro de compra", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(0, 310, 268, 119);
		contentPane.add(panel_1);
		
		btn_cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(campo_cliente.getText().trim().equals("") || inputCampo_produto.getText().trim().equals("") || campo_data.getText().trim().equals("") || campo_unt.getText().trim().equals("") || campo_desconto.getText().trim().equals("") || campo_total.getText().trim().equals("")){
						JOptionPane.showMessageDialog(btn_cadastrar, "Preencha todos os campos!");
				}else {
						executar.postPedido(campo_cliente.getText(), inputCampo_produto.getText(), campo_data.getText(),  campo_unt.getText(), campo_desconto.getText(), campo_total.getText());
						String search = campo_idcompra.getText();
						campo_idcompra.setText(executar.getCodCompra(search));			
						JOptionPane.showMessageDialog(btn_cadastrar, "Pedido cadastrado!");
					 }
			}
		});
		
		btn_buscarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String search = inputCampo_produto.getText();
				if(inputCampo_produto.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(btn_buscarProduto, "Preencha o campo");
				}else {
					campo_nome.setText(executar.getProdutoNomeID(search));
					campo_unt.setText(executar.getProdutoPrecoID(search));
					campo_total.setText(executar.getProdutoPrecoFinalID(search));
					campo_desconto.setText(executar.getProdutoPrecoDescontoID(search));
				}
				
			}
	});
		
		JButton btn_insereCompra = new JButton("Inserir");
		btn_insereCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String search = campo_idcompra.getText();
				campo_valodesc.setText(executar.getPrecoCompra(search));
			}
		});
		btn_insereCompra.setBounds(32, 439, 89, 23);
		contentPane.add(btn_insereCompra);
		
		JButton btn_salvar = new JButton("Salvar");
		btn_salvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(campo_numsequencial.getText().trim().equals("") || campo_idcompra.getText().trim().equals("") || inputCampo_produto.getText().trim().equals("") || campo_valodesc.getText().trim().equals("") || campo_qtd.getText().trim().equals("")){
					JOptionPane.showMessageDialog(btn_salvar, "Preencha todos os campos!");
				}else {
					if(executar.postCompra(campo_numsequencial.getText(), campo_idcompra.getText(), inputCampo_produto.getText(), campo_qtd.getText(), campo_valodesc.getText()) != false) {
						JOptionPane.showMessageDialog(btn_salvar, "Pedido cadastrado!");
					}else {
						JOptionPane.showMessageDialog(btn_salvar, "Estoque insuficiente!");
					}
					
				 }
		}
				
		});
		
		btn_salvar.setBounds(131, 439, 89, 23);
		contentPane.add(btn_salvar);
		
}
}

