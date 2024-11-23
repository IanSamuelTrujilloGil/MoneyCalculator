package software.ulpgc.model;

import java.util.Objects;

public class Currency {
    private final String name;
    private final String symbol;
    private final String code;

    public Currency(String name, String symbol, String code) {
        this.name = name;
        this.symbol = symbol;
        this.code = code;
    }

    public String getName() {
        return name;
    }


    public String getSymbol() {
        return symbol;
    }

    public String getCode() {
        return code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Currency currency = (Currency) o;
        return Objects.equals(name, currency.name) && Objects.equals(symbol, currency.symbol) && Objects.equals(code, currency.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, symbol, code);
    }

    @Override
    public String toString() {
        return "Currency{" +
                "name='" + name + '\'' +
                ", symbol='" + symbol + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

}
