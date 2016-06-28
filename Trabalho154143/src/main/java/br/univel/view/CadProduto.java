package br.univel.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadProduto extends JPanel {
	private JTextField tfDescricao;
	private JTextField txtTfpreco;

	/**
	 * Create the panel.
	 */
	public CadProduto() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{16, 81, 121, 175, 0};
		gridBagLayout.rowHeights = new int[]{0, 27, 28, 135, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblProdutos = new JLabel("Produtos");
		lblProdutos.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblProdutos = new GridBagConstraints();
		gbc_lblProdutos.insets = new Insets(0, 0, 5, 5);
		gbc_lblProdutos.gridx = 2;
		gbc_lblProdutos.gridy = 0;
		add(lblProdutos, gbc_lblProdutos);
		
		JLabel lblNewLabel = new JLabel("Descri\u00E7\u00E3o");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);
		
		tfDescricao = new JTextField();
		GridBagConstraints gbc_tfDescricao = new GridBagConstraints();
		gbc_tfDescricao.gridwidth = 2;
		gbc_tfDescricao.insets = new Insets(0, 0, 5, 0);
		gbc_tfDescricao.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfDescricao.gridx = 2;
		gbc_tfDescricao.gridy = 1;
		add(tfDescricao, gbc_tfDescricao);
		tfDescricao.setColumns(10);
		
		JLabel lblPre = new JLabel("Pre\u00E7o");
		GridBagConstraints gbc_lblPre = new GridBagConstraints();
		gbc_lblPre.anchor = GridBagConstraints.EAST;
		gbc_lblPre.insets = new Insets(0, 0, 5, 5);
		gbc_lblPre.gridx = 1;
		gbc_lblPre.gridy = 2;
		add(lblPre, gbc_lblPre);
		
		txtTfpreco = new JTextField();
		GridBagConstraints gbc_txtTfpreco = new GridBagConstraints();
		gbc_txtTfpreco.insets = new Insets(0, 0, 5, 5);
		gbc_txtTfpreco.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTfpreco.gridx = 2;
		gbc_txtTfpreco.gridy = 2;
		add(txtTfpreco, gbc_txtTfpreco);
		txtTfpreco.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		GridBagConstraints gbc_btnCadastrar = new GridBagConstraints();
		gbc_btnCadastrar.insets = new Insets(0, 0, 0, 5);
		gbc_btnCadastrar.gridx = 1;
		gbc_btnCadastrar.gridy = 3;
		add(btnCadastrar, gbc_btnCadastrar);
		
		JButton btnLimpar = new JButton("Limpar");
		GridBagConstraints gbc_btnLimpar = new GridBagConstraints();
		gbc_btnLimpar.insets = new Insets(0, 0, 0, 5);
		gbc_btnLimpar.gridx = 2;
		gbc_btnLimpar.gridy = 3;
		add(btnLimpar, gbc_btnLimpar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				System.exit(0);
			
			}
		});
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.gridx = 3;
		gbc_btnCancelar.gridy = 3;
		add(btnCancelar, gbc_btnCancelar);

	}

}
