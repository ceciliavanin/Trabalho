package br.univel;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.stream.StreamResult;

public class GravaXml {
	public String gravaXml (Object obj){
		StringWriter out = new StringWriter();
		JAXBContext context;
		Class<?> classe = obj.getClass();
		try {
			context = JAXBContext.newInstance(obj.getClass());
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			marshaller.marshal(obj, new StreamResult(out));
			String xml = out.toString();
			FileWriter fw = new FileWriter(classe.getSimpleName() +".xml");
			fw.write(xml);
			fw.close();
			return out.toString();
		} catch (JAXBException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	public static void main(String[] args) {
		Cliente cl = new Cliente();
		System.out.println(new GravaXml().gravaXml(cl));
	}
}