package br.univel.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import br.univel.Cliente;
import br.univel.ExecutaBanco;
import br.univel.Produto;
import br.univel.model.ClienteModel;
import br.univel.model.ProdutoModel;

public class ConsultaProduto extends JFrame {

	private JPanel contentPane;
	private JTable table; 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaProduto frame = new ConsultaProduto();
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
	public ConsultaProduto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

	protected void listarProduto(){

		List<Produto> listaProduto = new ExecutaBanco().listarTodosProdutos();
		 ProdutoModel pm = new ProdutoModel(listaProduto);
		table.setModel(pm);
		
	}
}
