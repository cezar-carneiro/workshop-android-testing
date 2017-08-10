package workshop.com.br.example.api;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;

/**
 * Created by rhawan.franco on 10/08/2017.
 */

public class ConversorMassaTest {

    private IConversor conversorMassa;

    @Before
    public void setUp() throws Exception {
        conversorMassa = new ConversorMassa();
    }

    @Test
    public void converterLibraParaQuiloSucesso() {
        try {
            assertEquals(new BigDecimal("0.45").setScale(2, BigDecimal.ROUND_HALF_DOWN),
                    conversorMassa.converter(BigDecimal.ONE).setScale(2, BigDecimal.ROUND_HALF_DOWN));
        } catch (ConversorApiException e) {
            fail();
        }
    }

    @Test
    public void converterLibraParaQuiloValorNulo() {
        try {
            conversorMassa.converter(null);
            fail();
        } catch (ConversorApiException e) {
            assertEquals("Informe a quantidade de libras a ser convertido!", e.getMessage());
        }
    }

    @Test
    public void converterLibraParaQuiloValorNegativo() {
        try {
            conversorMassa.converter(new BigDecimal("-1"));
            fail();
        } catch (ConversorApiException e) {
            assertEquals("Libras não pode ser negativo!", e.getMessage());
        }
    }

}
