package br.univel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import br.univel.view.ImportarXml;

public class LerXML {

	public boolean LerXml(Object obj) {
		JAXBContext context;
		Class<?> classe = obj.getClass();

		try {
			context = JAXBContext.newInstance(obj.getClass());
			Unmarshaller unmarshaller = context.createUnmarshaller();
			obj = unmarshaller.unmarshal(new FileInputStream(classe.getSimpleName()+".xml"));
			
			return true;
		} catch (JAXBException e) {
			
			return false;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}
	}


}
