package br.univel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

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
			e.printStackTrace();
			return false;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}
		

	}

public static void main(String[] args) {
	Cliente cl = new Cliente();
	System.out.println(new LerXML().LerXml(cl));
}
}
