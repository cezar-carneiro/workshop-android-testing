package workshop.com.br.example.api;

import java.math.BigDecimal;

/**
 * Created by rhawan.franco on 10/08/2017.
 */

public interface IConversor {

    BigDecimal converter(BigDecimal valor) throws ConversorApiException;
}
