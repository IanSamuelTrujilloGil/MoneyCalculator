package software.ulpgc.architecture.io;

import com.google.gson.Gson;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import software.ulpgc.architecture.model.Currency;
import software.ulpgc.architecture.model.ExchangeRate;

import java.io.IOException;
import java.io.InputStream;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class ERIOExchangeRateLoader implements ExchangeRateLoader {

    @Override
    public ExchangeRate load(LocalDate date, Currency from, Currency to) throws IOException {
        return jsonToExchangeRate(loadJson(date), date, from, to);
    }

    private String loadJson(LocalDate date) throws IOException {
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

    private ExchangeRate jsonToExchangeRate(String json, LocalDate date, Currency from, Currency to) {
        Map<String, JsonElement> codeToEuroRate = new Gson().fromJson(json, JsonObject.class).get("rates").getAsJsonObject().asMap();
        double rate = codeToEuroRate.get(to.getCode()).getAsDouble() / codeToEuroRate.get(from.getCode()).getAsDouble() ;
        return new ExchangeRate(rate, date, from, to);
    }
}

