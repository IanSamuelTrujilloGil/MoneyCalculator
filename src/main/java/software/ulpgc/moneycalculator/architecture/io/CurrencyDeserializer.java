package software.ulpgc.moneycalculator.architecture.io;

import software.ulpgc.moneycalculator.architecture.model.Currency;

public interface CurrencyDeserializer {
    Currency deserialize(String line);
}
