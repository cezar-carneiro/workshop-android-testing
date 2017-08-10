package workshop.com.br.example.api;

import java.math.BigDecimal;

/**
 * Created by rhawan.franco on 10/08/2017.
 */

public class ConversorDistancia implements IConversor {

    private static final BigDecimal FATOR_KM = new BigDecimal(1.60934);

    @Override
    public BigDecimal converter(BigDecimal milhas) throws ConversorApiException {
        if (milhas == null) {
            throw new ConversorApiException("Informe a distancia em milhas a ser convertido!");
        }
        if (milhas.compareTo(BigDecimal.ZERO) < 0) {
            throw new ConversorApiException("Milhas não pode ser negativo!");
        }
        if (milhas != null) {
            return milhas.multiply(FATOR_KM);
        }
        return BigDecimal.ZERO;
    }
}
