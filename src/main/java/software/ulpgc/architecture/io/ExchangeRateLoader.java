package software.ulpgc.architecture.io;
import software.ulpgc.architecture.model.Currency;
import software.ulpgc.architecture.model.ExchangeRate;
import java.io.IOException;

import java.time.LocalDate;

public interface ExchangeRateLoader {
    ExchangeRate load(LocalDate date, Currency from, Currency to) throws  IOException;
}
