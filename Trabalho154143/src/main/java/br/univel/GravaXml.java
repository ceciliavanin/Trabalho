package br.univel;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class GravaXml {
	public boolean gravaXml (Object obj){
		StringWriter out = new StringWriter();
		JAXBContext context;
		Class<?> classe = obj.getClass();
		try {
	            context = JAXBContext.newInstance(obj.getClass());
	           Marshaller marshaller = context.createMarshaller();
	            marshaller.setProperty(
	                    javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT,
	                    Boolean.TRUE
	            );
	            String xml = out.toString();
				FileWriter fw = new FileWriter(classe.getSimpleName() +".xml");
				fw.write(xml);
				fw.close();
	            String res = "Arquivo Exportado com sucesso";
	            System.out.println(res);
			return true;
		} catch (JAXBException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
}