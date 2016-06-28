package br.univel;
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

	
	@Parameters(name = "Teste {index}: prasubtract({0}-{1})={2})")
	public static Iterable<Object[]> data1() {
		return Arrays.asList(new Object[][] { 
			{ 120.00, 110.00, 10.00 }, 
			{ 12.0, 9.0, 3.0 }, 
			{ 20.0, 10.0, 10.0 }, 
			{ 41.0, 22.0, 19.0 }, 
			{ 10.0, 10.0, 0.0 }			
		});
	}

	@Test
	public void testaTroco() {	
		assertEquals(valorTroco, RealizaVenda.troco(valorRecebido, valorTotal));
	}
	
	

}