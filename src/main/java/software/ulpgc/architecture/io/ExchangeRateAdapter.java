package software.ulpgc.architecture.io;

import software.ulpgc.architecture.model.Currency;
import software.ulpgc.architecture.model.ExchangeRate;

public interface ExchangeRateAdapter {
    ExchangeRate adapt(Object object, Currency from, Currency to);
}
