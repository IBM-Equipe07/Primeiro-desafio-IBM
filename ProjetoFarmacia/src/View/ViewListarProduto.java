package View;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import BDController.Sistema;

public class ViewListarProduto extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField inputPesquisar;
	private JTable table;
	
	DefaultTableModel model;

	/**
	 * Create the panel.
	 */
	public ViewListarProduto(){
		Sistema executar = new Sistema();
		executar.conectar();
		
		setBounds(0, 0, 547, 567);
		setBackground(new Color(217, 217, 217));
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 147, 527, 410);
		add(scrollPane);
		
		Panel painelTabela = new Panel();
		scrollPane.setViewportView(painelTabela);
		painelTabela.setLayout(null);
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		model = new DefaultTableModel(){  
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column){  
				return false; 
			}
		};  
		Object[] column = {"Codigo", "Nome", "Descrição", "Preço Unt.", "Estoque", "Remedio", "Genérico"};
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
	
		TableColumnModel colmod = table.getColumnModel();
		TableColumn columnCod = colmod.getColumn(0);
		columnCod.setMaxWidth(50);
		TableColumn columnNome = colmod.getColumn(1);
		columnNome.setMaxWidth(80);
		TableColumn columnPreco = colmod.getColumn(3);
		columnPreco.setMaxWidth(70);
		TableColumn columnDescricao = colmod.getColumn(2);
		columnDescricao.setMinWidth(50);
		TableColumn columnEstoque = colmod.getColumn(4);
		columnEstoque.setMaxWidth(50);
		TableColumn columnFlagRemedio = colmod.getColumn(5);
		columnFlagRemedio.setMaxWidth(50);
		TableColumn columnFlagGenerico = colmod.getColumn(6);
		columnFlagGenerico.setMaxWidth(50);
		

		Panel panel = new Panel();
		panel.setBounds(107, 105, 327, 2);
		add(panel);
		panel.setBackground(new Color(32, 92, 109));

		JLabel buttonPesquisar = new JLabel("");
		buttonPesquisar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String search = inputPesquisar.getText();
				System.out.println(search);
				ArrayList<String[]> lista = executar.getProdutoForNome(search);
				insertTable(lista);
				
			}
		});
		
		buttonPesquisar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonPesquisar.setIcon(new ImageIcon(ViewListagem.class.getResource("/View/image/pesquisar.png")));
		buttonPesquisar.setBounds(405, 79, 33, 27);
		add(buttonPesquisar);
		inputPesquisar = new JTextField();
		inputPesquisar.setToolTipText("pesquise aqui");
		inputPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		inputPesquisar.setBounds(107, 77, 294, 27);
		add(inputPesquisar);
		inputPesquisar.setColumns(10);
		setVisible(true);
		inputPesquisar.setBackground(new Color(217, 217, 217));
		inputPesquisar.setBorder(null);
		
		JLabel lblNewLabel = new JLabel(">>LISTAGEM DE PRODUTOS<<");
		lblNewLabel.setFont(new Font("Artifakt Element Black", Font.PLAIN, 17));
		lblNewLabel.setForeground(new Color(32, 92, 109));
		lblNewLabel.setBounds(143, 11, 243, 43);
		add(lblNewLabel);
		
	}
	
	public void insertTable(ArrayList<String[]> dado) {
		((DefaultTableModel) table.getModel()).setRowCount(0);
		
		for(String[] c: dado) {
			final Object[] row = new Object[7];
			toString();
			row[0] = c[0];
			row[1] = c[1];
			row[2] = c[2];
			row[3] = String.format("R$ %.2f", Double.parseDouble(c[3]));
			row[4] = c[4];
			row[5] = c[5];
			row[6] = c[6];
			model.addRow(row);
		}
	}
	public JTable getTable() {
		return table;
	}
}