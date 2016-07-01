package br.univel.view;

import javax.swing.JFrame;

import br.univel.DaoImp;
import br.univel.ListaProdutos;
import br.univel.reports.ProdutoJRDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class EmitirRelatorio {

	public void relCliente(){
		String arq = "Cliente.jasper";		
		JasperPrint jp = JasperFillManager.fillReport(arq, null,.getCon());
		
		JasperViewer jasperViewer = new JasperViewer(jp);
		
		jasperViewer.setBounds(50, 50, 320, 240);
		jasperViewer.setLocationRelativeTo(null);
		jasperViewer.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		jasperViewer.setVisible(true);
		
	}
	public void relProduto(){
		
	}
	public void relVenda(){
		
	}
}
