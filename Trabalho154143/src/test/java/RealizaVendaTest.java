import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import br.univel.RealizaVenda;


@RunWith(value = Parameterized.class)
public class RealizaVendaTest {

	private BigDecimal valorTotal;
	private BigDecimal valorTroco;
	private BigDecimal valorRecebido;

	
	

	public RealizaVendaTest(BigDecimal valorRecebido, BigDecimal valorTotal, BigDecimal valorTroco) {
		
		this.valorTotal = valorTotal;
		this.valorTroco = valorTroco;
		this.valorRecebido = valorRecebido;
	}

	
	@Parameters(name = "Teste {index}: éprasomar({0}-{1})={2}")
	public static Iterable<Object[]> data1() {
		return Arrays.asList(new Object[][] { 
			{ 120, 110, 10 }, 
			{ 12, 9, 3 }, 
			{ 20, 10, 10 }, 
			{ 41, 22, 19 }, 
			{ 10, 10, 0 }			
		});
	}

	@Test
	public void test_sub() {	
		assertEquals(valorTroco, RealizaVenda.troco(valorRecebido, valorTotal));
	}
	@Test
	public void testaTroco(){
		assertEquals(valorTroco, RealizaVenda.troco(valorRecebido, valorTotal));
	}
	

}