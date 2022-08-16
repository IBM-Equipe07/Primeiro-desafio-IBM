package View;

import java.awt.Color;
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
		Object[] column = {"Codigo", "Nome", "Email"};
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
	
		TableColumnModel colmod = table.getColumnModel();
		TableColumn TC_ProdName = colmod.getColumn(0);
		TC_ProdName.setMaxWidth(100);
		
		
		
		Panel panel = new Panel();
		panel.setBounds(107, 105, 327, 2);
		add(panel);
		panel.setBackground(new Color(32, 92, 109));

		JLabel buttonPesquisar = new JLabel("");
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
