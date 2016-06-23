package br.univel;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class LerXML {

	public LerXML(Object obj) {
		Class<?> classe = obj.getClass();
		JAXBContext context;
		try {
			context = JAXBContext.newInstance(obj.getClass());
			Unmarshaller unmarshaller = context.createUnmarshaller();

			obj = unmarshaller.unmarshal(new File(obj.getClass()+".xml"));

		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}

public static void main(String[] args) {

}
}
