package software.ulpgc.architecture.io;

import java.io.IOException;
import java.time.LocalDate;

public interface ExchangeRateReader {
    String read(LocalDate date) throws IOException;
}
