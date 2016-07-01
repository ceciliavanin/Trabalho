package br.univel.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import br.univel.Cliente;
import br.univel.banco.ExecutaBanco;
import br.univel.model.ClienteModel;
import java.util.List;

public class ConsultaCliente extends JFrame {
	JTable table;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaCliente frame = new ConsultaCliente();
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
	public ConsultaCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 605, 395);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		JScrollPane jsc = new JScrollPane();
		table = new JTable();
		jsc.setViewportView(table);		
		contentPane.add(jsc, BorderLayout.CENTER);
		setContentPane(contentPane);
		listarClientes();
		
	}
	
	protected void listarClientes(){

		List<Cliente> listaCliente = new ExecutaBanco().listarTodosClientes();
		 ClienteModel cm = new ClienteModel(listaCliente);
		table.setModel(cm);
		
	}

}
