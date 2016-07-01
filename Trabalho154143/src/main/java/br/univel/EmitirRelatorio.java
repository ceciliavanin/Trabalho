package br.univel;

import javax.swing.JFrame;

import br.univel.SerIMP;
import br.univel.Produto;
import br.univel.Venda;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class EmitirRelatorio {
	private void Imprimir() throws JRException {
		
	}

	public void imprimirProdutos() throws JRException {
		
		String arq = "RelatorioProdutos.jasper";
		 d = new SerIMP();
		Produto dao = new Produto();
		ProdutoJRDataSource ds = new ProdutoJRDataSource(dao.getLista());
		JasperPrint jp = JasperFillManager.fillReport(arq, null,d.getCon());
		
		JasperViewer jasperViewer = new JasperViewer(jp);
		
		jasperViewer.setBounds(50, 50, 320, 240);
		jasperViewer.setLocationRelativeTo(null);
		jasperViewer.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		jasperViewer.setVisible(true);
		
	}

	public void imprimirVendas() throws JRException {
		
		String arq = "RelatorioVendas.jasper";
		SerIMP d = new SerIMP();
		Venda dao = new Venda();
		VendaJRDataSource ds = new VendaJRDataSource(dao.getLista());
		JasperPrint jp = JasperFillManager.fillReport(arq, null,d.getCon());
		
		JasperViewer jasperViewer = new JasperViewer(jp);
		
		jasperViewer.setBounds(50, 50, 320, 240);
		jasperViewer.setLocationRelativeTo(null);
		jasperViewer.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		jasperViewer.setVisible(true);
		
	}

	public void imprimirClientes() throws JRException {
		
		String arq = "RelatorioClientes.jasper";		
		Produto dao = new Produto();
		SerIMP d = new SerIMP();
		ProdutoJRDataSource ds = new ProdutoJRDataSource(dao.getLista());
		JasperPrint jp = JasperFillManager.fillReport(arq, null,d.getCon());
		
		JasperViewer jasperViewer = new JasperViewer(jp);
		
		jasperViewer.setBounds(50, 50, 320, 240);
		jasperViewer.setLocationRelativeTo(null);
		jasperViewer.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		jasperViewer.setVisible(true);
		
	}
}
