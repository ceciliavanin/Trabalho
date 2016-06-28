package br.univel.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.univel.Cliente;
import br.univel.GravaXml;
import br.univel.LerXML;
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

public class ImportarXml extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ImportarXml frame = new ImportarXml();
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
	public ImportarXml() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 96, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
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
		
		JLabel lblLocalDoArquivo = new JLabel("Local do Arquivo");
		GridBagConstraints gbc_lblLocalDoArquivo = new GridBagConstraints();
		gbc_lblLocalDoArquivo.anchor = GridBagConstraints.EAST;
		gbc_lblLocalDoArquivo.insets = new Insets(0, 0, 5, 5);
		gbc_lblLocalDoArquivo.gridx = 4;
		gbc_lblLocalDoArquivo.gridy = 2;
		contentPane.add(lblLocalDoArquivo, gbc_lblLocalDoArquivo);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 5;
		gbc_textField.gridy = 2;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JRadioButton rdbtnVenda = new JRadioButton("Venda");
		GridBagConstraints gbc_rdbtnVenda = new GridBagConstraints();
		gbc_rdbtnVenda.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnVenda.fill = GridBagConstraints.HORIZONTAL;
		gbc_rdbtnVenda.gridx = 2;
		gbc_rdbtnVenda.gridy = 3;
		contentPane.add(rdbtnVenda, gbc_rdbtnVenda);
		
		JButton btnImportar = new JButton("Importar");
		btnImportar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LerXML g = new LerXML();
				if (rdbtnVenda.isSelected()){
					g.LerXml(Venda.class);
					JOptionPane.showMessageDialog(rootPane, "Arquivo importado com sucesso\nLocal: C:/Users/Vanessa/git/Trabalho/Trabalho154143!");

				}
				else if (rdbtnCliente.isSelected()){
					g.LerXml(Cliente.class);
					JOptionPane.showMessageDialog(rootPane, "Arquivo imporatdo com sucesso\nLocal: C:/Users/Vanessa/git/Trabalho/Trabalho154143!");

				}else if (rdbtnProduto.isSelected()){
					g.LerXml(Produto.class);
					JOptionPane.showMessageDialog(rootPane, "Arquivo importado com sucesso\nLocal: C:/Users/Vanessa/git/Trabalho/Trabalho154143!");

				}else {
					JOptionPane.showMessageDialog(rootPane, "Selecionar uma opção para exportar!");
				}
			}
			
		});
		GridBagConstraints gbc_btnImportar = new GridBagConstraints();
		gbc_btnImportar.insets = new Insets(0, 0, 0, 5);
		gbc_btnImportar.gridx = 4;
		gbc_btnImportar.gridy = 5;
		contentPane.add(btnImportar, gbc_btnImportar);
	}

}
