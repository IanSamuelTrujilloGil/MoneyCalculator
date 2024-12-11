package software.ulpgc.architecture.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ERIOExchangeRateReader implements ExchangeRateReader{
    @Override
    public String read(LocalDate date) throws IOException {
        try(InputStream inputStream = buildUrl(date).openStream()){
            return new String(inputStream.readAllBytes());
        }
    }


    private URL buildUrl(LocalDate date) throws IOException {
        return new URL("https://api.exchangeratesapi.io/v1/" + date.format(getFormatDate()) +
                "?access_key=" + ERIOApi.key);
    }

    private DateTimeFormatter getFormatDate() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd");
    }
}
