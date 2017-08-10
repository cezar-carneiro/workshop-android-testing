package workshop.com.br.example.api;

import static junit.framework.Assert.*;
import junit.framework.TestCase;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by rhawan.franco on 10/08/2017.
 */

public class ConversorMoedaTest {

    private IConversor conversorMoeda;

    @Before
    public void setUp() throws Exception {
        conversorMoeda = new ConversorMoeda();
    }

    @Test
    public void converterDolarParaRealSucesso() {
        try {
            assertEquals(new BigDecimal("3.16").setScale(2, BigDecimal.ROUND_HALF_DOWN),
                    conversorMoeda.converter(BigDecimal.ONE).setScale(2, BigDecimal.ROUND_HALF_DOWN));
        } catch (ConversorApiException e) {
            fail();
        }
    }

    @Test
    public void converterDolarParaRealValorNulo() {
        try {
            conversorMoeda.converter(null);
            fail();
        } catch (ConversorApiException e) {
            assertEquals("Informe o dólar a ser convertido!", e.getMessage());
        }
    }

    @Test
    public void converterDolarParaRealValorNegativo() {
        try {
            conversorMoeda.converter(new BigDecimal("-1"));
            fail();
        } catch (ConversorApiException e) {
            assertEquals("Dolar não pode ser negativo!", e.getMessage());
        }
    }

}
