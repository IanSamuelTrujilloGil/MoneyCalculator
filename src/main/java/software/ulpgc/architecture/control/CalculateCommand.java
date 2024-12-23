package software.ulpgc.architecture.control;


import software.ulpgc.architecture.io.ExchangeRateLoader;
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
        try {
            ExchangeRate exchangeRate = exchangeRateLoader.load(dateDialog.get(), moneyDialog.get().getCurrency(), currencyDialog.get());
            Money result = new Money(moneyDialog.get().getAmount() * exchangeRate.getRate(), currencyDialog.get());
            moneyDisplay.display(result);
        } catch (IOException ignored) {
        }

    }
}
