package br.univel.view;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.univel.CadClientes;

import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class CadCliente extends JPanel {
	private JTextField tfNomeCliente;
	private JTextField tfCidade;
	private JTextField tfEstado;
	private JTextField tfTelefone;

	/**
	 * Create the panel.
	 */
	public CadCliente() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{46, 50, 89, 213, 0};
		gridBagLayout.rowHeights = new int[]{32, 20, 20, 20, 20, 23, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblClientes = new JLabel("Clientes");
		lblClientes.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblClientes = new GridBagConstraints();
		gbc_lblClientes.insets = new Insets(0, 0, 5, 5);
		gbc_lblClientes.gridx = 2;
		gbc_lblClientes.gridy = 0;
		add(lblClientes, gbc_lblClientes);
		
		JLabel lblNome = new JLabel("Nome");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.gridx = 0;
		gbc_lblNome.gridy = 1;
		add(lblNome, gbc_lblNome);
		
		tfNomeCliente = new JTextField();
		GridBagConstraints gbc_tfNomeCliente = new GridBagConstraints();
		gbc_tfNomeCliente.anchor = GridBagConstraints.NORTH;
		gbc_tfNomeCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfNomeCliente.insets = new Insets(0, 0, 5, 0);
		gbc_tfNomeCliente.gridwidth = 3;
		gbc_tfNomeCliente.gridx = 1;
		gbc_tfNomeCliente.gridy = 1;
		add(tfNomeCliente, gbc_tfNomeCliente);
		tfNomeCliente.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Cidade");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		add(lblNewLabel, gbc_lblNewLabel);
		
		tfCidade = new JTextField();
		GridBagConstraints gbc_tfCidade = new GridBagConstraints();
		gbc_tfCidade.anchor = GridBagConstraints.NORTH;
		gbc_tfCidade.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfCidade.insets = new Insets(0, 0, 5, 0);
		gbc_tfCidade.gridwidth = 3;
		gbc_tfCidade.gridx = 1;
		gbc_tfCidade.gridy = 2;
		add(tfCidade, gbc_tfCidade);
		tfCidade.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado");
		GridBagConstraints gbc_lblEstado = new GridBagConstraints();
		gbc_lblEstado.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblEstado.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstado.gridx = 0;
		gbc_lblEstado.gridy = 3;
		add(lblEstado, gbc_lblEstado);
		
		tfEstado = new JTextField();
		GridBagConstraints gbc_tfEstado = new GridBagConstraints();
		gbc_tfEstado.anchor = GridBagConstraints.NORTH;
		gbc_tfEstado.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfEstado.insets = new Insets(0, 0, 5, 0);
		gbc_tfEstado.gridwidth = 3;
		gbc_tfEstado.gridx = 1;
		gbc_tfEstado.gridy = 3;
		add(tfEstado, gbc_tfEstado);
		tfEstado.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone");
		GridBagConstraints gbc_lblTelefone = new GridBagConstraints();
		gbc_lblTelefone.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblTelefone.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefone.gridx = 0;
		gbc_lblTelefone.gridy = 4;
		add(lblTelefone, gbc_lblTelefone);
		
		tfTelefone = new JTextField();
		GridBagConstraints gbc_tfTelefone = new GridBagConstraints();
		gbc_tfTelefone.anchor = GridBagConstraints.NORTH;
		gbc_tfTelefone.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfTelefone.insets = new Insets(0, 0, 5, 5);
		gbc_tfTelefone.gridwidth = 2;
		gbc_tfTelefone.gridx = 1;
		gbc_tfTelefone.gridy = 4;
		add(tfTelefone, gbc_tfTelefone);
		tfTelefone.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			
			private Component rootPane;

			@Override
			public void actionPerformed(ActionEvent e) {
				CadClientes cli = new CadClientes();
				try {
					cli.cadastro(tfNomeCliente.getText(), tfCidade.getText(), tfEstado.getText(), tfTelefone.getText());
					JOptionPane.showMessageDialog(rootPane,	"Arquivo importado com sucesso!");
					} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		GridBagConstraints gbc_btnCadastrar = new GridBagConstraints();
		gbc_btnCadastrar.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnCadastrar.insets = new Insets(0, 0, 0, 5);
		gbc_btnCadastrar.gridwidth = 2;
		
		gbc_btnCadastrar.gridx = 0;
		gbc_btnCadastrar.gridy = 6;
		add(btnCadastrar, gbc_btnCadastrar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfNomeCliente.setText("");
				tfCidade.setText("");
				tfEstado.setText("");
				tfTelefone.setText("");
				
			}
		});
		GridBagConstraints gbc_btnLimpar = new GridBagConstraints();
		gbc_btnLimpar.anchor = GridBagConstraints.NORTH;
		gbc_btnLimpar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnLimpar.insets = new Insets(0, 0, 0, 5);
		gbc_btnLimpar.gridx = 2;
		gbc_btnLimpar.gridy = 6;
		add(btnLimpar, gbc_btnLimpar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0); 
			}

			private void Dispose() {
				
			}
		});
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnCancelar.gridx = 3;
		gbc_btnCancelar.gridy = 6;
		add(btnCancelar, gbc_btnCancelar);

	}

}
