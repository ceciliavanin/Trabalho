package br.univel.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.univel.Cliente;
import br.univel.Produto;
import br.univel.Venda;

import javax.swing.JRadioButton;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class Relatorio extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Relatorio frame = new Relatorio();
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
	public Relatorio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblSelecioneRelatrioDesejado = new JLabel("Selecione Relat\u00F3rio Desejado");
		lblSelecioneRelatrioDesejado.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblSelecioneRelatrioDesejado = new GridBagConstraints();
		gbc_lblSelecioneRelatrioDesejado.insets = new Insets(0, 0, 5, 5);
		gbc_lblSelecioneRelatrioDesejado.gridx = 3;
		gbc_lblSelecioneRelatrioDesejado.gridy = 1;
		contentPane.add(lblSelecioneRelatrioDesejado, gbc_lblSelecioneRelatrioDesejado);
		
		JRadioButton rdbtnVendas = new JRadioButton("Vendas");
		GridBagConstraints gbc_rdbtnVendas = new GridBagConstraints();
		gbc_rdbtnVendas.fill = GridBagConstraints.HORIZONTAL;
		gbc_rdbtnVendas.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnVendas.gridx = 1;
		gbc_rdbtnVendas.gridy = 2;
		contentPane.add(rdbtnVendas, gbc_rdbtnVendas);
		
		JRadioButton rdbtnProdutos = new JRadioButton("Produtos");
		GridBagConstraints gbc_rdbtnProdutos = new GridBagConstraints();
		gbc_rdbtnProdutos.fill = GridBagConstraints.HORIZONTAL;
		gbc_rdbtnProdutos.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnProdutos.gridx = 1;
		gbc_rdbtnProdutos.gridy = 3;
		contentPane.add(rdbtnProdutos, gbc_rdbtnProdutos);
		
		JRadioButton rdbtnClientes = new JRadioButton("Clientes");
		GridBagConstraints gbc_rdbtnClientes = new GridBagConstraints();
		gbc_rdbtnClientes.fill = GridBagConstraints.HORIZONTAL;
		gbc_rdbtnClientes.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnClientes.gridx = 1;
		gbc_rdbtnClientes.gridy = 4;
		contentPane.add(rdbtnClientes, gbc_rdbtnClientes);
		
		JButton btnEmitirRelatorio = new JButton("Emitir Relatorio");
		btnEmitirRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmitirRelatorio rel = new EmitirRelatorio(); 
				if (rdbtnVendas.isSelected()){
					rel.relVenda();

				}
				else if (rdbtnClientes.isSelected()){
					rel.relCliente();

				}else if (rdbtnProdutos.isSelected()){
					rel.relProduto();

				}else {
					JOptionPane.showMessageDialog(rootPane, "Selecionar uma opção para exportar!");
				}

				
			}
		});
		GridBagConstraints gbc_btnEmitirRelatorio = new GridBagConstraints();
		gbc_btnEmitirRelatorio.insets = new Insets(0, 0, 0, 5);
		gbc_btnEmitirRelatorio.gridx = 3;
		gbc_btnEmitirRelatorio.gridy = 5;
		contentPane.add(btnEmitirRelatorio, gbc_btnEmitirRelatorio);
	}

}
