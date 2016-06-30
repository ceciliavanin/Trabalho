package br.univel.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Insets;

@SuppressWarnings("serial")
public class Venda extends JPanel {
	private JTextField tfData;
	private JTextField tfId;
	private JTextField tfNomeCliente;
	private JTable tableProdutos;
	private JTextField tfTotal;
	private JTextField tfRecebido;
	private JTextField tfTroco;

	/**
	 * Create the panel.
	 */
	public Venda() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 59, 33, 51, 22, 46, 6, 49, 77, 0};
		gridBagLayout.rowHeights = new int[]{20, 20, 23, 34, 14, 103, 20, 20, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNVenda = new JLabel("N\u00BA Venda");
		GridBagConstraints gbc_lblNVenda = new GridBagConstraints();
		gbc_lblNVenda.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNVenda.insets = new Insets(0, 0, 5, 5);
		gbc_lblNVenda.gridx = 1;
		gbc_lblNVenda.gridy = 0;
		add(lblNVenda, gbc_lblNVenda);
		
		tfId = new JTextField();
		GridBagConstraints gbc_tfId = new GridBagConstraints();
		gbc_tfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfId.anchor = GridBagConstraints.NORTH;
		gbc_tfId.insets = new Insets(0, 0, 5, 5);
		gbc_tfId.gridwidth = 2;
		gbc_tfId.gridx = 2;
		gbc_tfId.gridy = 0;
		add(tfId, gbc_tfId);
		tfId.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Data");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);
		
		tfData = new JTextField();
		GridBagConstraints gbc_tfData = new GridBagConstraints();
		gbc_tfData.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfData.anchor = GridBagConstraints.NORTH;
		gbc_tfData.insets = new Insets(0, 0, 5, 5);
		gbc_tfData.gridwidth = 2;
		gbc_tfData.gridx = 2;
		gbc_tfData.gridy = 1;
		add(tfData, gbc_tfData);
		tfData.setColumns(10);
		
		JLabel lblCliente = new JLabel("Cliente");
		GridBagConstraints gbc_lblCliente = new GridBagConstraints();
		gbc_lblCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblCliente.gridx = 1;
		gbc_lblCliente.gridy = 2;
		add(lblCliente, gbc_lblCliente);
		
		tfNomeCliente = new JTextField();
		GridBagConstraints gbc_tfNomeCliente = new GridBagConstraints();
		gbc_tfNomeCliente.anchor = GridBagConstraints.NORTH;
		gbc_tfNomeCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfNomeCliente.insets = new Insets(0, 0, 5, 5);
		gbc_tfNomeCliente.gridwidth = 5;
		gbc_tfNomeCliente.gridx = 2;
		gbc_tfNomeCliente.gridy = 2;
		add(tfNomeCliente, gbc_tfNomeCliente);
		tfNomeCliente.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaCliente consulta =  new ConsultaCliente();
				consulta.setVisible(true);
				
			}
		});
		GridBagConstraints gbc_btnPesquisar = new GridBagConstraints();
		gbc_btnPesquisar.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnPesquisar.insets = new Insets(0, 0, 5, 0);
		gbc_btnPesquisar.gridwidth = 2;
		gbc_btnPesquisar.gridx = 7;
		gbc_btnPesquisar.gridy = 2;
		add(btnPesquisar, gbc_btnPesquisar);
		
		JLabel lblProduto = new JLabel("Produto");
		GridBagConstraints gbc_lblProduto = new GridBagConstraints();
		gbc_lblProduto.anchor = GridBagConstraints.NORTH;
		gbc_lblProduto.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblProduto.insets = new Insets(0, 0, 5, 5);
		gbc_lblProduto.gridx = 1;
		gbc_lblProduto.gridy = 4;
		add(lblProduto, gbc_lblProduto);
		
		tableProdutos = new JTable();
		GridBagConstraints gbc_tableProdutos = new GridBagConstraints();
		gbc_tableProdutos.fill = GridBagConstraints.BOTH;
		gbc_tableProdutos.insets = new Insets(0, 0, 5, 5);
		gbc_tableProdutos.gridwidth = 7;
		gbc_tableProdutos.gridx = 1;
		gbc_tableProdutos.gridy = 5;
		add(tableProdutos, gbc_tableProdutos);
		
		JButton btnAdicionar = new JButton("Adicionar");
		GridBagConstraints gbc_btnAdicionar = new GridBagConstraints();
		gbc_btnAdicionar.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnAdicionar.insets = new Insets(0, 0, 5, 0);
		gbc_btnAdicionar.gridx = 8;
		gbc_btnAdicionar.gridy = 5;
		add(btnAdicionar, gbc_btnAdicionar);
		
		JLabel lblNewLabel_1 = new JLabel("Valor Total");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridwidth = 2;
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 6;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		tfTotal = new JTextField();
		GridBagConstraints gbc_tfTotal = new GridBagConstraints();
		gbc_tfTotal.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfTotal.anchor = GridBagConstraints.NORTH;
		gbc_tfTotal.insets = new Insets(0, 0, 5, 5);
		gbc_tfTotal.gridx = 3;
		gbc_tfTotal.gridy = 6;
		add(tfTotal, gbc_tfTotal);
		tfTotal.setColumns(10);
		
		JLabel lblValorRecebido = new JLabel("Valor Recebido");
		GridBagConstraints gbc_lblValorRecebido = new GridBagConstraints();
		gbc_lblValorRecebido.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblValorRecebido.insets = new Insets(0, 0, 5, 5);
		gbc_lblValorRecebido.gridwidth = 2;
		gbc_lblValorRecebido.gridx = 1;
		gbc_lblValorRecebido.gridy = 7;
		add(lblValorRecebido, gbc_lblValorRecebido);
		
		tfRecebido = new JTextField();
		GridBagConstraints gbc_tfRecebido = new GridBagConstraints();
		gbc_tfRecebido.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfRecebido.anchor = GridBagConstraints.NORTH;
		gbc_tfRecebido.insets = new Insets(0, 0, 5, 5);
		gbc_tfRecebido.gridx = 3;
		gbc_tfRecebido.gridy = 7;
		add(tfRecebido, gbc_tfRecebido);
		tfRecebido.setColumns(10);
		
		JLabel lblTroco = new JLabel("Troco");
		GridBagConstraints gbc_lblTroco = new GridBagConstraints();
		gbc_lblTroco.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblTroco.insets = new Insets(0, 0, 5, 5);
		gbc_lblTroco.gridx = 5;
		gbc_lblTroco.gridy = 7;
		add(lblTroco, gbc_lblTroco);
		
		tfTroco = new JTextField();
		GridBagConstraints gbc_tfTroco = new GridBagConstraints();
		gbc_tfTroco.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfTroco.insets = new Insets(0, 0, 5, 5);
		gbc_tfTroco.anchor = GridBagConstraints.NORTH;
		gbc_tfTroco.gridwidth = 2;
		gbc_tfTroco.gridx = 6;
		gbc_tfTroco.gridy = 7;
		add(tfTroco, gbc_tfTroco);
		tfTroco.setColumns(10);
		
		JButton btnGravar = new JButton("Gravar");
		GridBagConstraints gbc_btnGravar = new GridBagConstraints();
		gbc_btnGravar.insets = new Insets(0, 0, 0, 5);
		gbc_btnGravar.gridx = 2;
		gbc_btnGravar.gridy = 9;
		add(btnGravar, gbc_btnGravar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				System.exit(0);
			
			}
		});
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancelar.gridx = 3;
		gbc_btnCancelar.gridy = 9;
		add(btnCancelar, gbc_btnCancelar);
		
	}
}
