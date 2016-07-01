package br.univel.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.univel.Cliente;
import br.univel.GravaXml;
import br.univel.Produto;
import br.univel.SerIMP;
import br.univel.Venda;

import java.awt.GridBagLayout;
import javax.swing.JRadioButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class ExportaBinario extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExportaBinario frame = new ExportaBinario();
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
	public ExportaBinario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 381, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JRadioButton rdbtnCliente = new JRadioButton("Cliente");
		GridBagConstraints gbc_rdbtnCliente = new GridBagConstraints();
		gbc_rdbtnCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_rdbtnCliente.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnCliente.gridx = 2;
		gbc_rdbtnCliente.gridy = 1;
		contentPane.add(rdbtnCliente, gbc_rdbtnCliente);
		
		JRadioButton rdbtnProduto = new JRadioButton("Produto");
		GridBagConstraints gbc_rdbtnProduto = new GridBagConstraints();
		gbc_rdbtnProduto.fill = GridBagConstraints.HORIZONTAL;
		gbc_rdbtnProduto.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnProduto.gridx = 2;
		gbc_rdbtnProduto.gridy = 2;
		contentPane.add(rdbtnProduto, gbc_rdbtnProduto);
		
		JRadioButton rdbtnVenda = new JRadioButton("Venda");
		GridBagConstraints gbc_rdbtnVenda = new GridBagConstraints();
		gbc_rdbtnVenda.fill = GridBagConstraints.HORIZONTAL;
		gbc_rdbtnVenda.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnVenda.gridx = 2;
		gbc_rdbtnVenda.gridy = 3;
		contentPane.add(rdbtnVenda, gbc_rdbtnVenda);
		
		JButton btnExportar = new JButton("Exportar");
		btnExportar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SerIMP s = new SerIMP();
				
				if (rdbtnVenda.isSelected()){
					File f = new File("Venda");
					s.gravar(Venda.class, f);
					JOptionPane.showMessageDialog(rootPane, "Arquivo exportado com sucesso!");

				}
				else if (rdbtnCliente.isSelected()){
					File f = new File("Cliente");
					s.gravar(Cliente.class, f);
					JOptionPane.showMessageDialog(rootPane, "Arquivo exportado com sucesso!");

				}else if (rdbtnProduto.isSelected()){
					File f = new File("Produto");
					s.gravar(Produto.class, f);
					JOptionPane.showMessageDialog(rootPane, "Arquivo exportado com sucesso!");

				}else {
					JOptionPane.showMessageDialog(rootPane, "Selecionar uma opção para exportar!");
				}
			
			}
		});
		GridBagConstraints gbc_btnExportar = new GridBagConstraints();
		gbc_btnExportar.insets = new Insets(0, 0, 0, 5);
		gbc_btnExportar.gridx = 3;
		gbc_btnExportar.gridy = 5;
		contentPane.add(btnExportar, gbc_btnExportar);
	}

}
