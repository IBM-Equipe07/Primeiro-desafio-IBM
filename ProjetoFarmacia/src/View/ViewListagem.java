package View;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Panel;
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

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ViewListagem extends JPanel {
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
	public ViewListagem() {
		Sistema executar = new Sistema();
		executar.conectar();

		setBounds(0, 0, 547, 567);
		setBackground(new Color(217, 217, 217));
		setLayout(null);
		model = new DefaultTableModel(){  
			/**
			 * 
			 */
			
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int row, int column){  
				return false; 
			}
		};  
		Object[] column = {"Codigo", "Nome", "Email"};
		model.setColumnIdentifiers(column);
//		TableColumnModel mod = table.getColumnModel();
//		TableColumn TC_ProdName = mod.getColumn(0);
//		TC_ProdName.setMaxWidth(100);
		setVisible(true);
	
		
		JPanel listagem = new JPanel();
		listagem.setBounds(0, 0, 547, 567);
		add(listagem);
		listagem.setLayout(null);
		listagem.setBackground(new Color(217, 217, 217));
		
		JLabel lblNewLabel = new JLabel(">>LISTAGEM CLIENTES<<");
		lblNewLabel.setBounds(160, 11, 207, 37);
		listagem.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Artifakt Element Black", Font.PLAIN, 17));
		lblNewLabel.setForeground(new Color(32, 92, 109));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 146, 527, 410);
		listagem.add(scrollPane);
		
		Panel painelTabela = new Panel();
		scrollPane.setViewportView(painelTabela);
		painelTabela.setLayout(null);
		

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String idCast =  (String) table.getValueAt(table.getSelectedRow(), 0);
				ViewDetalhamentoTabela detalhamento = new ViewDetalhamentoTabela(idCast);
				detalhamento.setVisible(true);
						
				
			}
		});
		
		table.setBackground(new Color(255, 255, 255));
		table.setModel(model);
		scrollPane.setViewportView(table);
		inputPesquisar = new JTextField();
		inputPesquisar.setBounds(107, 76, 294, 27);
		listagem.add(inputPesquisar);
		inputPesquisar.setToolTipText("pesquise aqui");
		inputPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		inputPesquisar.setColumns(10);
		inputPesquisar.setBackground(new Color(217, 217, 217));
		inputPesquisar.setBorder(null);

	
		JLabel buttonPesquisar = new JLabel("");
		buttonPesquisar.setBounds(405, 76, 33, 27);
		listagem.add(buttonPesquisar);
		buttonPesquisar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String search = inputPesquisar.getText();
				
					ArrayList<String[]> lista = new ArrayList<>();
					if (executar.getClientesPesquisar("idClientes", search).size() != 0) {
						lista = executar.getClientesPesquisar("idClientes", search);
						insertTable(lista);
					} else if (executar.getClientesPesquisar("email", search).size() != 0) {
						lista = executar.getClientesPesquisar("email", search);
						insertTable(lista);
					} else if (executar.getClientesPesquisar("cpf", search).size() != 0) {
						lista = executar.getClientesPesquisar("cpf", search);
						insertTable(lista);
					} else if (executar.getClientesPesquisar("nome", search).size() != 0) {
						lista = executar.getClientesPesquisar("nome", search);
						insertTable(lista);
					}
			}
		});
		
		buttonPesquisar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonPesquisar.setIcon(new ImageIcon(ViewListagem.class.getResource("/View/image/pesquisar.png")));
		
		
		
		Panel panel = new Panel();
		panel.setBounds(107, 109, 327, 2);
		listagem.add(panel);
		panel.setBackground(new Color(32, 92, 109));
		
		JPanel detalhamento = new JPanel();
		detalhamento.setBounds(0, 0, 547, 567);
		add(detalhamento);
		detalhamento.setLayout(null);
		detalhamento.setBackground(new Color(217, 217, 217));
	}
	
	
	public void insertTable(ArrayList<String[]> dado) {
		((DefaultTableModel) table.getModel()).setRowCount(0);
		
		for(String[] c: dado) {
			final Object[] row = new Object[3];
			row[0] = c[0];
			row[1] = c[1];
			row[2] = c[2];
			model.addRow(row);
			
		}
	}
	public JTable getTable() {
		return table;
	}
}

