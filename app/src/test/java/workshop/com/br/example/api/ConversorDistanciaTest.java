package workshop.com.br.example.api;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;

/**
 * Created by rhawan.franco on 10/08/2017.
 */

public class ConversorDistanciaTest {

    private IConversor conversorDistancia;

    @Before
    public void setUp() throws Exception {
        conversorDistancia = new ConversorDistancia();
    }

    @Test
    public void converterMilhaParaQuilometroSucesso() {
        try {
            assertEquals(new BigDecimal("1.61").setScale(2, BigDecimal.ROUND_HALF_DOWN),
                    conversorDistancia.converter(BigDecimal.ONE).setScale(2, BigDecimal.ROUND_HALF_DOWN));
        } catch (ConversorApiException e) {
            fail();
        }
    }

    @Test
    public void converterMilhaParaQuilometroValorNulo() {
        try {
            conversorDistancia.converter(null);
            fail();
        } catch (ConversorApiException e) {
            assertEquals("Informe a distancia em milhas a ser convertido!", e.getMessage());
        }
    }

    @Test
    public void converterMilhaParaQuilometroValorNegativo() {
        try {
            conversorDistancia.converter(new BigDecimal("-1"));
            fail();
        } catch (ConversorApiException e) {
            assertEquals("Milhas não pode ser negativo!", e.getMessage());
        }
    }

}
