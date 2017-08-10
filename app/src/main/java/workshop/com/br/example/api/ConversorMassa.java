package workshop.com.br.example.api;

import java.math.BigDecimal;

/**
 * Created by rhawan.franco on 10/08/2017.
 */

public class ConversorMassa implements IConversor {

    private static final BigDecimal FATOR_QUILOGRAMA = new BigDecimal(0.453592);

    @Override
    public BigDecimal converter(BigDecimal libras) throws ConversorApiException {
        if (libras != null) {
            return libras.multiply(FATOR_QUILOGRAMA);
        }
        throw new ConversorApiException("Informe a quantidade de libras a ser convertido!");
    }
}
