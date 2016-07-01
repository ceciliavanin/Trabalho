package br.univel.reports;

import java.util.List;

import br.univel.Cliente;
import br.univel.Produto;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class ProdutoRel {

	private String path;
	
	private String pathToReportPackage; 
	public ProdutoRel() {
		this.path = this.getClass().getClassLoader().getResource("").getPath();
		this.pathToReportPackage = this.path + "br/com/rdtecnologia/jasper/";
		System.out.println(path);
	}
	
	
	public void imprimir(List<Produto> produtos) throws Exception	
	{
		JasperReport report = JasperCompileManager.compileReport(this.getPathToReportPackage() + "Cliente.jrxml");
		
		JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(produtos));
 
		JasperExportManager.exportReportToPdfFile(print, "c:/Relatorio_de_Clientes.pdf");		
	}
 
	public String getPathToReportPackage() {
		return this.pathToReportPackage;
	}
	
	public String getPath() {
		return this.path;
	}

}
