package software.ulpgc.architecture.control;


import software.ulpgc.architecture.io.ExchangeRateLoader;
import software.ulpgc.architecture.model.Currency;
import software.ulpgc.architecture.model.ExchangeRate;
import software.ulpgc.architecture.model.Money;
import software.ulpgc.architecture.view.CurrencyDialog;
import software.ulpgc.architecture.view.DateDialog;
import software.ulpgc.architecture.view.MoneyDialog;
import software.ulpgc.architecture.view.MoneyDisplay;

import java.io.IOException;



public class CalculateCommand implements Command {
    private final DateDialog dateDialog;
    private final MoneyDialog moneyDialog;
    private final CurrencyDialog currencyDialog;
    private final ExchangeRateLoader exchangeRateLoader;
    private final MoneyDisplay moneyDisplay;

    public CalculateCommand(DateDialog dateDialog, MoneyDialog moneyDialog, CurrencyDialog currencyDialog, ExchangeRateLoader exchangeRateLoader, MoneyDisplay moneyDisplay) {
        this.dateDialog = dateDialog;
        this.moneyDialog = moneyDialog;
        this.currencyDialog = currencyDialog;
        this.exchangeRateLoader = exchangeRateLoader;
        this.moneyDisplay = moneyDisplay;
    }

    @Override
    public void execute()  {
        Money money = moneyDialog.get();
        Currency currency = currencyDialog.get();
        try {
            ExchangeRate exchangeRate = exchangeRateLoader.load(dateDialog.get(), money.getCurrency(), currency);
            Money result = new Money(money.getAmount() * exchangeRate.getRate(), currency);
            moneyDisplay.display(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
