package software.ulpgc.io;
import software.ulpgc.model.Currency;
import software.ulpgc.model.ExchangeRate;
import java.io.IOException;

import java.time.LocalDate;

public interface ExchangeRateLoader {
    ExchangeRate load(LocalDate date, Currency from, Currency to) throws  IOException;
}
