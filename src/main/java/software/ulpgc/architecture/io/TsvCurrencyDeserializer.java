package software.ulpgc.architecture.io;

import software.ulpgc.architecture.model.Currency;

public class TsvCurrencyDeserializer implements CurrencyDeserializer {
    @Override
    public Currency deserialize(String line) {
        return deserialize(line.split("\t"));
    }

    private Currency deserialize(String[] fields) {
        return new Currency(
                fields[1],
                fields.length == 3 ? fields[2] : null,
                fields[0]

        );
    }

}
