package software.ulpgc.architecture.io;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import software.ulpgc.architecture.model.Currency;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class ERIOCurrencyLoader implements CurrencyLoader{
    @Override
    public List<Currency> load() throws IOException {
        try (InputStream inputStream = buildUrl().openStream()) {
            return jsonToList(new String(inputStream.readAllBytes()));
        }
    }

    private URL buildUrl() throws IOException {
        return new URL("https://api.exchangeratesapi.io/v1/symbols?access_key=" + ERIOApi.key);
    }



    private List<Currency> jsonToList(String json) throws IOException {
        List<Currency> currencies = new ArrayList<>();
        Map<String, JsonElement> symbols = new Gson().fromJson(json, JsonObject.class).getAsJsonObject("symbols").asMap();
        for (String symbol : symbols.keySet()) {
            currencies.add(new Currency(symbols.get(symbol).getAsString(),null, symbol));
        }
        return currencies;
    }

}
