package View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import BDController.Sistema;
import java.awt.Font;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

public class ViewControleEstoque extends JPanel {

	/**
	 * Create the panel.
	 * @throws ParseException 
	 */
	public ViewControleEstoque() throws ParseException {
		Sistema executar = new Sistema();
<<<<<<< HEAD
		executar.conectar();
=======
		executar.conectar(); 
>>>>>>> feat(insert-cliente-endereco)

		setBounds(0, 0, 547, 567);
		setBackground(new Color(217, 217, 217));
		setLayout(null);
		
		JTextField campo_cliente = new JTextField();
		campo_cliente.setBounds(146, 191, 116, 25);
		add(campo_cliente);
		campo_cliente.setColumns(10);
		
		JTextField inputCampo_produto = new JTextField();
		inputCampo_produto.setBounds(55, 112, 122, 25);
		add(inputCampo_produto);
		inputCampo_produto.setColumns(10);
		
		JTextField campo_total = new JTextField();
		campo_total.setBounds(337, 254, 94, 25);
		add(campo_total);
		campo_total.setColumns(10);
		
		JTextField campo_unt = new JTextField();
		campo_unt.setBounds(92, 254, 94, 25);
		add(campo_unt);
		campo_unt.setColumns(10);
		
		JTextField campo_desconto = new JTextField();
		campo_desconto.setBounds(215, 254, 94, 25);
		add(campo_desconto);

		
		JLabel lblNewLabel = new JLabel("Código do cliente:");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel.setBounds(146, 174, 131, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Código do produto:");
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(55, 95, 122, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Data:");
		lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(287, 174, 46, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Valor unitário:");
		lblNewLabel_3.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(92, 237, 92, 14);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Desconto:");
		lblNewLabel_4.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(215, 237, 75, 14);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Valor final:");
		lblNewLabel_5.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(337, 237, 75, 14);
		add(lblNewLabel_5);
		
		JFormattedTextField campo_data = new JFormattedTextField();
		campo_data.setBounds(287, 191, 86, 25);
		MaskFormatter mask_data = new MaskFormatter("##/##/####");
		mask_data.install(campo_data);
		add(campo_data);
		
		JTextField campo_nome = new JTextField();
		campo_nome.setBounds(213, 111, 272, 25);
		add(campo_nome);
		campo_nome.setColumns(10);
		
		JLabel campo_nomeProd = new JLabel("Nome:");
		campo_nomeProd.setFont(new Font("Dialog", Font.PLAIN, 14));
		campo_nomeProd.setBounds(213, 95, 255, 14);
		add(campo_nomeProd);
		
		JLabel lblNewLabel_6 = new JLabel("Qtd.:");
		lblNewLabel_6.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(227, 423, 46, 14);
		add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Valor unt.:");
		lblNewLabel_7.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(102, 423, 67, 14);
		add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Valor total:");
		lblNewLabel_8.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_8.setBounds(338, 423, 86, 19);
		add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Nota fiscal:");
		lblNewLabel_9.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_9.setBounds(148, 369, 90, 14);
		add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Código do pedido:");
		lblNewLabel_10.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_10.setBounds(293, 369, 116, 14);
		add(lblNewLabel_10);
		
		JFormattedTextField campo_numsequencial = new JFormattedTextField();
		campo_numsequencial.setBounds(148, 386, 92, 25);
		add(campo_numsequencial);
		
		JTextField campo_idcompra = new JTextField();
		campo_idcompra.setBounds(293, 384, 122, 25);
		campo_idcompra.setColumns(10);
		add(campo_idcompra);
		
		JTextField campo_valodesc = new JTextField();
		campo_valodesc.setBounds(102, 438, 67, 25);
		campo_valodesc.setColumns(10);
		add(campo_valodesc);
		
		JTextField campo_qtd = new JTextField();
		campo_qtd.setBounds(227, 438, 67, 25);
		campo_qtd.setColumns(10);
		add(campo_qtd);
		
		JTextField campo_valTotal = new JTextField();
		campo_valTotal.setBounds(338, 440, 103, 25);
		campo_valTotal.setColumns(10);
		add(campo_valTotal);
		
		JPanel btn_cadastrar = new JPanel();
		btn_cadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
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
		btn_cadastrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_cadastrar.setBackground(new Color(70, 130, 180));
		btn_cadastrar.setBounds(210, 290, 103, 33);
		btn_cadastrar.setBackground(new Color(32, 92, 109));
		add(btn_cadastrar);
		btn_cadastrar.setLayout(null);
		
		JLabel lblNewLabel_11 = new JLabel("CADASTRAR");
		lblNewLabel_11.setForeground(new Color(255, 255, 255));
		lblNewLabel_11.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_11.setBounds(10, 9, 85, 14);
		btn_cadastrar.add(lblNewLabel_11);
		
		JPanel btn_insereCompra = new JPanel();
		btn_insereCompra.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String search = campo_idcompra.getText();
				campo_valodesc.setText(executar.getPrecoCompra(search));
			}
		});
		
		btn_insereCompra.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_insereCompra.setLayout(null);
		btn_insereCompra.setBackground(new Color(70, 130, 180));
		btn_insereCompra.setBounds(146, 494, 103, 33);
		btn_insereCompra.setBackground(new Color(32, 92, 109));
		add(btn_insereCompra);
		
		JLabel lblNewLabel_11_1 = new JLabel("INSERIR");
		lblNewLabel_11_1.setForeground(Color.WHITE);
		lblNewLabel_11_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_11_1.setBounds(25, 9, 53, 14);
		
		btn_insereCompra.add(lblNewLabel_11_1);
		
		JPanel btn_salvar = new JPanel();
		btn_salvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
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
		
		btn_salvar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_salvar.setLayout(null);
		btn_salvar.setBounds(270, 494, 103, 33);
		btn_salvar.setBackground(new Color(32, 92, 109));
		add(btn_salvar);
		
		JLabel lblNewLabel_11_2 = new JLabel("SALVAR");
		lblNewLabel_11_2.setForeground(Color.WHITE);
		lblNewLabel_11_2.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_11_2.setBounds(24, 9, 54, 14);
		btn_salvar.add(lblNewLabel_11_2);
		
		JPanel btn_buscarProduto = new JPanel();
		btn_buscarProduto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
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
		btn_buscarProduto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_buscarProduto.setBounds(64, 141, 104, 22);
		btn_buscarProduto.setBackground(new Color(32, 92, 109));
		add(btn_buscarProduto);
		
		JLabel lblNewLabel_12 = new JLabel("BUSCAR CODIGO");
		lblNewLabel_12.setFont(new Font("Dialog", Font.PLAIN, 10));
		lblNewLabel_12.setForeground(new Color(255, 255, 255));
		lblNewLabel_12.setBackground(new Color(255, 255, 255));
		btn_buscarProduto.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel(">>CONTROLE DE ESTOQUE<<");
		lblNewLabel_13.setFont(new Font("Artifakt Element Black", Font.PLAIN, 17));
		lblNewLabel_13.setBounds(162, 11, 260, 43);
		lblNewLabel_13.setForeground(new Color(32, 92, 109));

		add(lblNewLabel_13);

	}

}
