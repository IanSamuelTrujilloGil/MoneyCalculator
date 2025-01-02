package software.ulpgc.moneycalculator.architecture.io;

import software.ulpgc.moneycalculator.architecture.model.Currency;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileCurrencyLoader implements CurrencyLoader {

    private final File file;
    private final CurrencyDeserializer deserializer;

    public FileCurrencyLoader(File file, CurrencyDeserializer deserializer) {
        this.file = file;
        this.deserializer = deserializer;
    }

    @Override
    public List<Currency> load() {
        try (FileReader fileReader = new FileReader(file)) {
            return  loadFromBufferedReader(new BufferedReader(fileReader));
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
