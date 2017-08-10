package workshop.com.br.example.api;

import java.math.BigDecimal;

/**
 * Created by rhawan.franco on 10/08/2017.
 */

public class ConversorMoeda implements IConversor {

    private static final BigDecimal COTACAO_DOLLAR = new BigDecimal(3.15805098);

    @Override
    public BigDecimal converter(BigDecimal dolar) throws ConversorApiException {
        if (dolar == null) {
            throw new ConversorApiException("Informe o dólar a ser convertido!");
        }
        if (dolar.compareTo(BigDecimal.ZERO) < 0) {
            throw new ConversorApiException("Dolar não pode ser negativo!");
        }
        if (dolar != null) {
            return dolar.multiply(COTACAO_DOLLAR);
        }
        return BigDecimal.ZERO;
    }
}
