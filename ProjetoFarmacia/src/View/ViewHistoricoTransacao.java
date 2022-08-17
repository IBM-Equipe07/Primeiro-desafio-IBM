package View;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import BDController.Sistema;

public class ViewHistoricoTransacao extends JPanel {

	/**
	 * Create the panel.
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	DefaultTableModel model;
	
	public ViewHistoricoTransacao() {
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
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
	
//				String idCast =  (String) table.getValueAt(table.getSelectedRow(), 0);
//				System.out.println(idCast);
			}
		});
		
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
		Object[] column = {"Nota Fiscal", "Codigo Cliente", "CPF", "Nome", "Codigo Produto", "Nome Produto", "Qtds.:", "Valor Unitario", "Valor Unico", "Valor Total"};
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
		TableColumnModel colmod = table.getColumnModel();
		TableColumn columnCod = colmod.getColumn(3);
		columnCod.setMinWidth(100);
		

		Panel panel = new Panel();
		panel.setBounds(107, 105, 327, 2);
		add(panel);
		panel.setBackground(new Color(32, 92, 109));

		JLabel buttonPesquisar = new JLabel("");
		buttonPesquisar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		buttonPesquisar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonPesquisar.setIcon(new ImageIcon(ViewListagem.class.getResource("/View/image/pesquisar.png")));
		buttonPesquisar.setBounds(405, 79, 33, 27);
		add(buttonPesquisar);
		JComponent inputPesquisar = new JTextField();
		inputPesquisar.setToolTipText("pesquise aqui");
		inputPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		inputPesquisar.setBounds(107, 77, 294, 27);
		add(inputPesquisar);
		setVisible(true);
		inputPesquisar.setBackground(new Color(217, 217, 217));
		inputPesquisar.setBorder(null);
		
		JLabel lblNewLabel = new JLabel(">>HISTÓRICO DE TRANSAÇÕES<<");
		lblNewLabel.setFont(new Font("Artifakt Element Black", Font.PLAIN, 17));
		lblNewLabel.setForeground(new Color(32, 92, 109));
		lblNewLabel.setBounds(143, 11, 307, 43);
		add(lblNewLabel);
		
	}
	
	public void insertTable(ArrayList<String[]> dado) {
		((DefaultTableModel) table.getModel()).setRowCount(0);
		
		for(String[] c: dado) {
			final Object[] row = new Object[10];
			row[0] = c[0];
			row[1] = c[1];
			row[2] = c[2];
			row[3] = c[3];
			row[4] = c[4];
			row[5] = c[5];
			row[6] = c[6];
			row[7] = String.format("R$ %.2f", Double.parseDouble(c[7]));
			row[8] = String.format("R$ %.2f", Double.parseDouble(c[8]));
			row[9] = String.format("R$ %.2f", Double.parseDouble(c[9]));	
			model.addRow(row);
		}
	}
	public JTable getTable() {
		return table;
	}

}
