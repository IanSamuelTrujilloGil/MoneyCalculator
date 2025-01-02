package software.ulpgc.moneycalculator.architecture.io;

import software.ulpgc.moneycalculator.architecture.model.Currency;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileCurrencyLoader implements CurrencyLoader {

    private final InputStream fileStream;
    private final CurrencyDeserializer deserializer;

    public FileCurrencyLoader(InputStream fileStream, CurrencyDeserializer deserializer) {
        this.fileStream = fileStream;
        this.deserializer = deserializer;
    }

    @Override
    public List<Currency> load() {
        try (BufferedReader fileReader = new BufferedReader( new InputStreamReader(fileStream))) {
            return  loadFromBufferedReader(fileReader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    private List<Currency> loadFromBufferedReader(BufferedReader reader) throws IOException {
        List<Currency> currencies = new ArrayList<>();
        while (true) {
            String line = reader.readLine();
            if (line == null) break;
            currencies.add(deserializer.deserialize(line));
        }
        return currencies;
    }
}
