package br.univel.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.univel.Cliente;
import br.univel.GravaXml;
import br.univel.Produto;

import java.awt.GridBagLayout;
import javax.swing.JRadioButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class ExportaXml extends JFrame {

	private JPanel contentPane;
	private JTextField tfLocal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExportaXml frame = new ExportaXml();
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
	public ExportaXml() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 58, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		
		JLabel lblLocal = new JLabel("Local");
		GridBagConstraints gbc_lblLocal = new GridBagConstraints();
		gbc_lblLocal.anchor = GridBagConstraints.EAST;
		gbc_lblLocal.insets = new Insets(0, 0, 5, 5);
		gbc_lblLocal.gridx = 3;
		gbc_lblLocal.gridy = 2;
		contentPane.add(lblLocal, gbc_lblLocal);
		
		tfLocal = new JTextField();
		GridBagConstraints gbc_tfLocal = new GridBagConstraints();
		gbc_tfLocal.insets = new Insets(0, 0, 5, 0);
		gbc_tfLocal.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfLocal.gridx = 4;
		gbc_tfLocal.gridy = 2;
		contentPane.add(tfLocal, gbc_tfLocal);
		tfLocal.setColumns(10);
		
		JRadioButton rdbtnVenda = new JRadioButton("Venda");
		GridBagConstraints gbc_rdbtnVenda = new GridBagConstraints();
		gbc_rdbtnVenda.fill = GridBagConstraints.HORIZONTAL;
		gbc_rdbtnVenda.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnVenda.gridx = 1;
		gbc_rdbtnVenda.gridy = 3;
		contentPane.add(rdbtnVenda, gbc_rdbtnVenda);
		
		JButton btnNewButton = new JButton("Exportar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GravaXml g = new GravaXml();
				if (rdbtnVenda.isSelected()){
					
					g.gravaXml(Venda.class);
					JOptionPane.showMessageDialog(rootPane, "Arquivo exportado com sucesso\nLocal: C:/Users/Vanessa/git/Trabalho/Trabalho154143!");

				}
				else if (rdbtnCliente.isSelected()){
					g.gravaXml(Cliente.class);
					JOptionPane.showMessageDialog(rootPane, "Arquivo exportado com sucesso\nLocal: C:/Users/Vanessa/git/Trabalho/Trabalho154143!");

				}else if (rdbtnProduto.isSelected()){
					g.gravaXml(Produto.class);
					JOptionPane.showMessageDialog(rootPane, "Arquivo exportado com sucesso\nLocal: C:/Users/Vanessa/git/Trabalho/Trabalho154143!");

				}else {
					JOptionPane.showMessageDialog(rootPane, "Selecionar uma opção para exportar!");
				}
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 4;
		contentPane.add(btnNewButton, gbc_btnNewButton);
	}

}
