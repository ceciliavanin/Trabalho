package br.univel;

import java.io.StringWriter;
import java.math.BigDecimal;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.transform.stream.StreamResult;

@XmlRootElement(name = "Produto")
//@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "Produto",
        propOrder = {"id", "descricao", "valor"},
        namespace = "http://mballem.com/"
)
public class GravaProdutoXML {
     Produto p = new Produto();
	@XmlElement(name = "id", required = true)
    private int id = p.getId();
    @XmlElement(name = "descricao", required = true)
    private String descricao = p.getDescricao();
    
    @XmlElement(name = "valor", required = true)
    private BigDecimal valor = p.getValor();

    //Gerar métodos get/set

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + descricao + '\'' +
                ", valor='" + valor  +
                '}';
    }
    public String marshal(Object object) {
        final StringWriter out = new StringWriter();
        JAXBContext context = null;
        try {
            context = JAXBContext.newInstance(object.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(
                    javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT,
                    Boolean.TRUE
            );
            marshaller.marshal(object, new StreamResult(out));
        } catch (PropertyException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return out.toString();
    } 
    
    public static void main(String[] args) {
    	Produto produto = new Produto();
    	System.out.println(new GravaProdutoXML().marshal(produto));
	}
}