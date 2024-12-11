package software.ulpgc.architecture.io;

import software.ulpgc.architecture.io.pojos.ERIOExchangeRateGetResponse;
import software.ulpgc.architecture.model.Currency;
import software.ulpgc.architecture.model.ExchangeRate;

import java.time.LocalDate;
import java.util.Map;

public class ERIOExchangeRateAdapter implements ExchangeRateAdapter{
    @Override
    public ExchangeRate adapt(Object object, Currency from, Currency to) {
        return adaptOf((ERIOExchangeRateGetResponse) object,from, to );
    }

    private ExchangeRate adaptOf(ERIOExchangeRateGetResponse ERIOExchangeRateGetResponse, Currency from, Currency to) {
        return new ExchangeRate(calculateRate(ERIOExchangeRateGetResponse.rates(),from,to),
                LocalDate.parse(ERIOExchangeRateGetResponse.date()),
                from,
                to);
    }

    private double calculateRate(Map<String, Double> rates, Currency from, Currency to) {
        return rates.get(to.getCode())/rates.get(from.getCode()) ;
    }


}
