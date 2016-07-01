package br.univel.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.univel.Cliente;
import br.univel.Produto;
import br.univel.SerIMP;
import br.univel.Venda;

import java.awt.GridBagLayout;
import javax.swing.JRadioButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class ImportarBinario extends JFrame {

	private JPanel contentPane;
	private JTextField Local;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ImportarBinario frame = new ImportarBinario();
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
	public ImportarBinario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0, 99, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JRadioButton rdbtnCliente = new JRadioButton("Cliente");
		GridBagConstraints gbc_rdbtnCliente = new GridBagConstraints();
		gbc_rdbtnCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_rdbtnCliente.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnCliente.gridx = 1;
		gbc_rdbtnCliente.gridy = 1;
		contentPane.add(rdbtnCliente, gbc_rdbtnCliente);

		JRadioButton rdbtnProduto = new JRadioButton("Produto");
		GridBagConstraints gbc_rdbtnProduto = new GridBagConstraints();
		gbc_rdbtnProduto.fill = GridBagConstraints.HORIZONTAL;
		gbc_rdbtnProduto.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnProduto.gridx = 1;
		gbc_rdbtnProduto.gridy = 2;
		contentPane.add(rdbtnProduto, gbc_rdbtnProduto);

		JRadioButton rdbtnVenda = new JRadioButton("Venda");
		GridBagConstraints gbc_rdbtnVenda = new GridBagConstraints();
		gbc_rdbtnVenda.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnVenda.fill = GridBagConstraints.HORIZONTAL;
		gbc_rdbtnVenda.gridx = 1;
		gbc_rdbtnVenda.gridy = 3;
		contentPane.add(rdbtnVenda, gbc_rdbtnVenda);

		JButton btnImportar = new JButton("Importar");
		btnImportar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				SerIMP s = new SerIMP();
				if (rdbtnVenda.isSelected()) {
					File f = new File("Venda"); 
					s.gravar(Venda.class, f);
					JOptionPane.showMessageDialog(rootPane,
							"Arquivo importado com sucesso!");

				} else if (rdbtnCliente.isSelected()) {
					File f = new File("Cliente"); 
					s.gravar(Cliente.class, f);
					JOptionPane.showMessageDialog(rootPane,
							"Arquivo importado com sucesso!");

				} else if (rdbtnProduto.isSelected()) {
					File f = new File("Produto"); 
					s.gravar(Produto.class,f);
					JOptionPane.showMessageDialog(rootPane,
						"Arquivo importado com sucesso!");
				}

			}

		});
		GridBagConstraints gbc_btnImportar = new GridBagConstraints();
		gbc_btnImportar.insets = new Insets(0, 0, 0, 5);
		gbc_btnImportar.gridx = 3;
		gbc_btnImportar.gridy = 4;
		contentPane.add(btnImportar, gbc_btnImportar);
	}

}
