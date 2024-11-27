package software.ulpgc.architecture.model;

import java.time.LocalDate;

public class ExchangeRate {
    private final double rate;
    private final LocalDate date;
    private final Currency from_currency;
    private final Currency to_currency;

    public ExchangeRate(double rate, LocalDate date, Currency from_currency, Currency to_currency) {
        this.rate = rate;
        this.date = date;
        this.from_currency = from_currency;
        this.to_currency = to_currency;
    }

    public double getRate() {
        return rate;
    }

    public LocalDate getDate() {
        return date;
    }

    public Currency getFrom_currency() {
        return from_currency;
    }

    public Currency getTo_currency() {
        return to_currency;
    }

    @Override
    public String toString() {
        return "ChangeRate{" +
                "rate=" + rate +
                ", date=" + date +
                ", from_currency=" + from_currency +
                ", to_currency=" + to_currency +
                '}';
    }
}
