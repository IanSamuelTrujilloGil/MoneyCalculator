package software.ulpgc.architecture.model;
import software.ulpgc.architecture.io.CurrencyLoader;

import java.io.IOException;
import java.util.Collection;
import java.util.List;


public class CurrencyCodeValidator implements CurrencyValidator {

    private final List<Currency> validCurrencies;
    private final CurrencyLoader loader;

    public CurrencyCodeValidator(CurrencyLoader loader) {
        this.loader = loader;
        try {
            this.validCurrencies = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean isCurrencyValid(Currency currency) {
        return validCurrencies.stream()
                .anyMatch(c -> c.getCode().equalsIgnoreCase(currency.getCode()));
    }


    public void filterInvalidCurrencies(Collection<Currency> currencies) {
        currencies.removeIf(currency -> !isCurrencyValid(currency));
    }





}
