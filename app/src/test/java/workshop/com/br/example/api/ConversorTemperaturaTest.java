package workshop.com.br.example.api;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;

/**
 * Created by rhawan.franco on 10/08/2017.
 */

public class ConversorTemperaturaTest {

    private IConversor conversorTemperatura;

    @Before
    public void setUp() throws Exception {
        conversorTemperatura = new ConversorTemperatura();
    }

    @Test
    public void converterCelsiusParaFahrenheitSucesso() {
        try {
            assertEquals(new BigDecimal("33.80"),
                    conversorTemperatura.converter(BigDecimal.ONE));
        } catch (ConversorApiException e) {
            fail();
        }
    }

    @Test
    public void converterCelsiusParaFahrenheitNegativoSucesso() {
        try {
            assertEquals(new BigDecimal("23.00"),
                    conversorTemperatura.converter(new BigDecimal("-5")));
        } catch (ConversorApiException e) {
            fail();
        }
    }

    @Test
    public void converterCelsiusParaFahrenheitDuasCasasSucesso() {
        try {
            assertEquals(new BigDecimal("40.46"),
                    conversorTemperatura.converter(new BigDecimal("4.7")));
        } catch (ConversorApiException e) {
            fail();
        }
    }

    @Test
    public void converterCelsiusParaFahrenheitZerado() {
        try {
            assertEquals(new BigDecimal("32.00"),
                    conversorTemperatura.converter(new BigDecimal("0")));
        } catch (ConversorApiException e) {
            fail();
        }
    }

    @Test
    public void converterCelsiusParaFahrenheitValorNulo() {
        try {
            conversorTemperatura.converter(null);
            fail();
        } catch (ConversorApiException e) {
            assertEquals("Informe a temperatura a ser convertido!", e.getMessage());
        }
    }

}
