package br.univel.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JTabbedPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	/**
	 * Launch the application.
	 */
	private String titulo; 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 372);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{674, 0};
		gbl_contentPane.rowHeights = new int[]{36, 200, -99, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JMenuBar menuBar = new JMenuBar();
		GridBagConstraints gbc_menuBar = new GridBagConstraints();
		gbc_menuBar.fill = GridBagConstraints.BOTH;
		gbc_menuBar.insets = new Insets(0, 0, 5, 0);
		gbc_menuBar.gridx = 0;
		gbc_menuBar.gridy = 0;
		contentPane.add(menuBar, gbc_menuBar);
		
		JMenu mnCadastro = new JMenu("Cadastro");
		menuBar.add(mnCadastro);
		
		JMenuItem mntmCadastroClientes = new JMenuItem("Cadastro Clientes");
		mnCadastro.add(mntmCadastroClientes);
		mntmCadastroClientes.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				TelaCliente();
			}

		});
		
		
		JMenuItem mntmCadastroDeProdutos = new JMenuItem("Cadastro de Produtos");
		mnCadastro.add(mntmCadastroDeProdutos);
		mntmCadastroDeProdutos.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				TelaProduto();
			}

		});
		
		JMenu mnFerramentas = new JMenu("Ferramentas");
		menuBar.add(mnFerramentas);
		
		JMenu mnImportar = new JMenu("Importar");
		mnFerramentas.add(mnImportar);
		
		JMenuItem mntmArquivoXml = new JMenuItem("Arquivo XML");
		mnImportar.add(mntmArquivoXml);
		
		JMenuItem mntmArquivoBinario = new JMenuItem("Arquivo Bin\u00E1rio");
		mnImportar.add(mntmArquivoBinario);
		
		JMenu mnExportar = new JMenu("Exportar");
		mnFerramentas.add(mnExportar);
		
		JMenuItem mntmArquivoBinario_1 = new JMenuItem("Arquivo Bin\u00E1rio");
		mnExportar.add(mntmArquivoBinario_1);
		
		JMenuItem mntmArquivoXml_1 = new JMenuItem("Arquivo XML");
		mnExportar.add(mntmArquivoXml_1);
		
		JMenu mnRelatrios = new JMenu("Relat\u00F3rios");
		menuBar.add(mnRelatrios);
		
		JMenuItem mntmClientes = new JMenuItem("Clientes");
		mnRelatrios.add(mntmClientes);
		
		JMenuItem mntmProdutos = new JMenuItem("Produtos");
		mnRelatrios.add(mntmProdutos);
		
		JMenuItem mntmVendas = new JMenuItem("Vendas");
		mnRelatrios.add(mntmVendas);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.gridheight = 2;
		gbc_tabbedPane.insets = new Insets(0, 0, 5, 0);
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 1;
		contentPane.add(tabbedPane, gbc_tabbedPane);
		
	}

	private void TelaProduto() {
		titulo = "Produto";
		for (int i = 0; i < tabbedPane.getTabCount(); i++){
			if (tabbedPane.getTitleAt(i).equals(titulo)){
				tabbedPane.setSelectedIndex(i);
				return;
			}
			
		}
		CadProduto telaProduto = new CadProduto();
		tabbedPane.addTab(titulo , telaProduto);
		mostra();
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}
	

	private void TelaCliente() {
		titulo = "Cliente";
		for (int i = 0; i < tabbedPane.getTabCount(); i++){
			if (tabbedPane.getTitleAt(i).equals(titulo)){
				tabbedPane.setSelectedIndex(i);
				return;
			}
			
		}
		CadCliente telacliente = new CadCliente();
		tabbedPane.addTab(titulo , telacliente);
		mostra();
	}	
	private void mostra() {
		tabbedPane.setSelectedIndex(tabbedPane.getTabCount()-1);
	}
}
