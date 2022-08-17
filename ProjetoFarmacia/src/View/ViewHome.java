

package View;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import BDController.Sistema;

public class ViewHome extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	
	
	private JPanel contentPane;
	
	// referencia das views
	private ViewListagem viewListagem;
	private ViewListarProduto viewCadastrarProduto;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewHome frame = new ViewHome(); 
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
	public ViewHome(){
		Sistema executar = new Sistema();
		executar.conectar();
		
		viewListagem = new ViewListagem();
		viewCadastrarProduto = new ViewListarProduto();
		
		setUndecorated(true);
		setRootPaneCheckingEnabled(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(new Color(217, 217, 217));
		contentPane.setLayout(null);
		
		JPanel backgroud = new JPanel();
		backgroud.setBounds(0, 0, 800, 600);
		contentPane.add(backgroud);
		backgroud.setLayout(null);
		backgroud.setBackground(new Color(217, 217, 217));
		
		JLabel buttonClose = new JLabel("");
		buttonClose.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		
		JLabel buttonMin = new JLabel("");
		buttonMin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonMin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(ViewHome.ICONIFIED);
			}

			
		});
		
		JPanel painelMain = new JPanel();
		painelMain.setBounds(253, 33, 547, 567);
		backgroud.add(painelMain);
		
		
		
		buttonMin.setIcon(new ImageIcon(ViewHome.class.getResource("/View/image/mi.png")));
		buttonMin.setBounds(738, 11, 20, 14);
		backgroud.add(buttonMin);
		buttonClose.setIcon(new ImageIcon(ViewHome.class.getResource("/View/image/clos.png")));
		buttonClose.setBounds(770, 11, 20, 14);
		backgroud.add(buttonClose);
		
		JPanel PainelEsquerdo = new JPanel();
		PainelEsquerdo.setBounds(0, 33, 254, 567);
		backgroud.add(PainelEsquerdo);
		PainelEsquerdo.setBackground(new Color(32, 92, 109));
		PainelEsquerdo.setLayout(null);
		
		JPanel buttonListagem = new JPanel();
		buttonListagem.setBounds(0, 162, 254, 71);
		PainelEsquerdo.add(buttonListagem);
		buttonListagem.setBackground(new Color(32, 92, 109));
		buttonListagem.setLayout(null);
		buttonListagem.addMouseListener(new PanelButtonMouseAdapter(buttonListagem) {
	
			@Override
			public void mouseClicked(MouseEvent e) {
				ArrayList<String[]> lista = executar.getClientes();
				viewListagem.insertTable(lista);
				menuClicked(viewListagem);
			}
		});
		
		JLabel txtListarClientes = new JLabel("LISTAR CLIENTES");
		txtListarClientes.setHorizontalTextPosition(SwingConstants.LEADING);
		txtListarClientes.setForeground(Color.WHITE);
		txtListarClientes.setFont(new Font("Dialog", Font.BOLD, 14));
		txtListarClientes.setBounds(70, 20, 174, 33);
		buttonListagem.add(txtListarClientes);
		
		JLabel imgListarClientes = new JLabel("");
		imgListarClientes.setIcon(new ImageIcon(ViewHome.class.getResource("/View/image/cliente.png")));
		imgListarClientes.setBounds(25, 20, 31, 33);
		buttonListagem.add(imgListarClientes);
		
		JPanel buttonCadastrar = new JPanel();

		buttonCadastrar.setBackground(new Color(32, 92, 109));
		buttonCadastrar.setBounds(0, 232, 254, 71);
		PainelEsquerdo.add(buttonCadastrar);
		buttonCadastrar.setLayout(null);
		buttonCadastrar.addMouseListener(new PanelButtonMouseAdapter(buttonCadastrar) {
			@Override
			public void mouseClicked(MouseEvent e) {
//				menuClicked();
			}
		});
		
		
		JLabel txtCadastrarClientes = new JLabel("CADASTRAR CLIENTES");
		txtCadastrarClientes.setHorizontalTextPosition(SwingConstants.LEADING);
		txtCadastrarClientes.setForeground(Color.WHITE);
		txtCadastrarClientes.setFont(new Font("Dialog", Font.BOLD, 14));
		txtCadastrarClientes.setBounds(70, 20, 177, 33);
		buttonCadastrar.add(txtCadastrarClientes);
		
		JLabel imgCadastarClientes = new JLabel("");
		imgCadastarClientes.setIcon(new ImageIcon(ViewHome.class.getResource("/View/image/cadastrar.png")));
		imgCadastarClientes.setBounds(25, 17, 31, 41);
		buttonCadastrar.add(imgCadastarClientes);
		
		JPanel buttonControleEstoque = new JPanel();
		buttonControleEstoque.addMouseListener(new PanelButtonMouseAdapter(buttonControleEstoque));
		buttonControleEstoque.setBackground(new Color(32, 92, 109));
		buttonControleEstoque.setBounds(0, 373, 254, 71);
		PainelEsquerdo.add(buttonControleEstoque);
		buttonControleEstoque.setLayout(null);
		buttonControleEstoque.addMouseListener(new PanelButtonMouseAdapter(buttonControleEstoque) {
			@Override
			public void mouseClicked(MouseEvent e) {
//				menuClicked();
			}
		});
		
		JLabel txtControleEstoque = new JLabel("CONTROLE ESTOQUE");
		txtControleEstoque.setHorizontalTextPosition(SwingConstants.LEADING);
		txtControleEstoque.setForeground(Color.WHITE);
		txtControleEstoque.setFont(new Font("Dialog", Font.BOLD, 14));
		txtControleEstoque.setBounds(70, 20, 174, 33);
		buttonControleEstoque.add(txtControleEstoque);
		
		JLabel imgControleEstoque = new JLabel("");
		imgControleEstoque.setIcon(new ImageIcon(ViewHome.class.getResource("/View/image/produto.png")));
		imgControleEstoque.setBounds(25, 17, 31, 41);
		buttonControleEstoque.add(imgControleEstoque);
		
		JPanel buttonHistoricoTransacao = new JPanel();
		buttonHistoricoTransacao.addMouseListener(new PanelButtonMouseAdapter(buttonHistoricoTransacao));
		buttonHistoricoTransacao.setBackground(new Color(32, 92, 109));
		buttonHistoricoTransacao.setBounds(0, 443, 254, 71);
		PainelEsquerdo.add(buttonHistoricoTransacao);
		buttonHistoricoTransacao.setLayout(null);
		buttonHistoricoTransacao.addMouseListener(new PanelButtonMouseAdapter(buttonHistoricoTransacao) {
			@Override
			public void mouseClicked(MouseEvent e) {
//				menuClicked();
			}
		});
		
		JLabel txtHistoricoTransacao = new JLabel("HISTORICO TRANSACAO");
		txtHistoricoTransacao.setHorizontalTextPosition(SwingConstants.LEADING);
		txtHistoricoTransacao.setForeground(Color.WHITE);
		txtHistoricoTransacao.setFont(new Font("Dialog", Font.BOLD, 14));
		txtHistoricoTransacao.setBounds(70, 20, 174, 33);
		buttonHistoricoTransacao.add(txtHistoricoTransacao);
		
		JLabel imgHistoricoTransacao = new JLabel("");
		imgHistoricoTransacao.setBounds(25, 17, 31, 41);
		buttonHistoricoTransacao.add(imgHistoricoTransacao);
		imgHistoricoTransacao.setIcon(new ImageIcon(ViewHome.class.getResource("/View/image/transacao.png")));
		
		JPanel buttonCadastrarProduto = new JPanel();
		buttonCadastrarProduto.setBounds(0, 303, 254, 71);
		PainelEsquerdo.add(buttonCadastrarProduto);
		buttonCadastrarProduto.setBackground(new Color(32, 92, 109));
		buttonCadastrarProduto.setLayout(null);
		buttonCadastrarProduto.addMouseListener(new PanelButtonMouseAdapter(buttonCadastrarProduto) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(viewCadastrarProduto);
				ArrayList<String[]> lista = executar.getProdutos();
				viewCadastrarProduto.insertTable(lista);

			}
		});
		
		JLabel txtCadastrarProdutos = new JLabel("LISTAR PRODUTOS");
		txtCadastrarProdutos.setHorizontalTextPosition(SwingConstants.LEADING);
		txtCadastrarProdutos.setForeground(Color.WHITE);
		txtCadastrarProdutos.setFont(new Font("Dialog", Font.BOLD, 14));
		txtCadastrarProdutos.setBounds(70, 20, 177, 33);
		buttonCadastrarProduto.add(txtCadastrarProdutos);
		
		JLabel imgCadastrarProdutos = new JLabel("");
		imgCadastrarProdutos.setIcon(new ImageIcon(ViewHome.class.getResource("/View/image/produtoadd.png")));
		imgCadastrarProdutos.setBounds(18, 15, 60, 47);
		buttonCadastrarProduto.add(imgCadastrarProdutos);
		
		
		JPanel PainelSuperior = new JPanel();
		PainelSuperior.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				
				int xx = e.getXOnScreen();
				int yy = e.getYOnScreen();
				setLocation(xx-x, yy-y);
				
				
			}
		});
		
		PainelSuperior.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				x = e.getX();
				y = e.getY();
			}
		});
		PainelSuperior.setForeground(Color.DARK_GRAY);
		PainelSuperior.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		PainelSuperior.setBounds(0, 0, 800, 36);
		backgroud.add(PainelSuperior);
		painelMain.setLayout(null);

		painelMain.add(viewListagem);
		painelMain.add(viewCadastrarProduto);
		
		menuClicked(viewListagem);
		
	}
	
	
	public void menuClicked(JPanel panel) {
		viewListagem.setVisible(false);
		viewCadastrarProduto.setVisible(false);
		
		panel.setVisible(true);
	}
	
	
	private class PanelButtonMouseAdapter extends MouseAdapter{
		
		JPanel panel;
		public PanelButtonMouseAdapter(JPanel panel) {
			this.panel = panel;
			
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			panel.setBackground(new Color(4, 42, 53));
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			panel.setBackground(new Color(32, 92, 109));
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			panel.setBackground(new Color(18, 67, 82));
		}
		
		@Override
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(new Color(4, 42, 53));
		}
		
		
	}
}


