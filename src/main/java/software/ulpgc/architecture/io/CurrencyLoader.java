package software.ulpgc.architecture.io;

import software.ulpgc.architecture.model.Currency;

import java.io.IOException;
import java.util.List;

public interface CurrencyLoader {
    List<Currency> load() throws IOException;
}
