package workshop.com.br.example.api;

import java.math.BigDecimal;

/**
 * Created by rhawan.franco on 10/08/2017.
 */

public class ConversorTemperatura implements IConversor {

    @Override
    public BigDecimal converter(BigDecimal celsius) throws ConversorApiException {
        if (celsius == null) {
            throw new ConversorApiException("Informe a temperatura a ser convertido!");
        }
        if (celsius != null) {
            return celsius.multiply(new BigDecimal("1.8")).add(new BigDecimal("32")).setScale(2, BigDecimal.ROUND_HALF_UP);
        }
        return BigDecimal.ZERO;
    }
}
