package br.univel;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class LerXML {

	public String LerXml(Object obj) {
		JAXBContext context;
		try {
			context = JAXBContext.newInstance(obj.getClass());
			Unmarshaller unmarshaller = context.createUnmarshaller();

			obj = unmarshaller.unmarshal(new File(obj.getClass()+".xml"));

		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return obj.toString();

	}

public static void main(String[] args) {
	Cliente cl = new Cliente();
	System.out.println(new LerXML().LerXml(cl));
}
}
