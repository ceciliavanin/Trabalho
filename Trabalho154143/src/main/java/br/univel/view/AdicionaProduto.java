package br.univel.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class AdicionaProduto extends JFrame {

	private JPanel contentPane;
	private JTextField txtQuantidade;
	private JTextField textField;
	private JScrollPane scrollPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdicionaProduto frame = new AdicionaProduto();
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
	public AdicionaProduto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 321);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{26, 117, 18, 0, 0};
		gbl_contentPane.rowHeights = new int[]{38, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 1.0};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblDescri = new JLabel("Descri\u00E7\u00E3o");
		GridBagConstraints gbc_lblDescri = new GridBagConstraints();
		gbc_lblDescri.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescri.gridx = 0;
		gbc_lblDescri.gridy = 0;
		contentPane.add(lblDescri, gbc_lblDescri);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 3;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		GridBagConstraints gbc_btnPesquisar = new GridBagConstraints();
		gbc_btnPesquisar.insets = new Insets(0, 0, 5, 5);
		gbc_btnPesquisar.gridx = 3;
		gbc_btnPesquisar.gridy = 1;
		contentPane.add(btnPesquisar, gbc_btnPesquisar);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		GridBagConstraints gbc_lblQuantidade = new GridBagConstraints();
		gbc_lblQuantidade.insets = new Insets(0, 0, 5, 5);
		gbc_lblQuantidade.anchor = GridBagConstraints.EAST;
		gbc_lblQuantidade.gridx = 0;
		gbc_lblQuantidade.gridy = 2;
		contentPane.add(lblQuantidade, gbc_lblQuantidade);
		
		txtQuantidade = new JTextField();
		GridBagConstraints gbc_txtQuantidade = new GridBagConstraints();
		gbc_txtQuantidade.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtQuantidade.insets = new Insets(0, 0, 5, 5);
		gbc_txtQuantidade.gridx = 1;
		gbc_txtQuantidade.gridy = 2;
		contentPane.add(txtQuantidade, gbc_txtQuantidade);
		txtQuantidade.setColumns(10);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 3;
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 3;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Descri\u00E7\u00E3o", "Pre\u00E7o"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnAdicionar = new JButton("Adicionar");
		GridBagConstraints gbc_btnAdicionar = new GridBagConstraints();
		gbc_btnAdicionar.insets = new Insets(0, 0, 0, 5);
		gbc_btnAdicionar.gridx = 3;
		gbc_btnAdicionar.gridy = 6;
		contentPane.add(btnAdicionar, gbc_btnAdicionar);
	}

}
