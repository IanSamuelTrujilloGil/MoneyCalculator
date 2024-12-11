package software.ulpgc.architecture.io;

import software.ulpgc.architecture.model.Currency;
import software.ulpgc.architecture.model.ExchangeRate;

import java.io.IOException;

import java.time.LocalDate;


public class ExchangeRateLoader  {

    private final ExchangeRateReader reader;
    private final ExchangeRateDeserializer deserializer;
    private final ExchangeRateAdapter adapter;

    public ExchangeRateLoader(ExchangeRateReader reader, ExchangeRateDeserializer deserializer, ExchangeRateAdapter adapter) {
        this.reader = reader;
        this.deserializer = deserializer;
        this.adapter = adapter;
    }

    public ExchangeRate load(LocalDate date, Currency from, Currency to) throws IOException {
        return adapter.adapt(deserializer.deserialize(reader.read(date)), from, to);
    }

}

