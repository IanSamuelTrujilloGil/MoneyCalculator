package software.ulpgc.moneycalculator.apps.windows;

import software.ulpgc.moneycalculator.architecture.control.CalculateCommand;
import software.ulpgc.moneycalculator.architecture.control.ResetCommand;
import software.ulpgc.moneycalculator.architecture.io.*;
import software.ulpgc.moneycalculator.architecture.model.Currency;
import java.io.File;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Currency> currencyList = new FileCurrencyLoader(Main.class.getResourceAsStream("/currencies.tsv"),
                new TsvCurrencyDeserializer()).load();
        MainFrame mainFrame = new MainFrame(currencyList);
        mainFrame.put("calculate", new CalculateCommand(
                mainFrame.getDateDialog(),
                mainFrame.getMoneyDialog(),
                mainFrame.getCurrencyDialog(),
                new ExchangeRateLoader(new ERIOExchangeRateReader(), new ERIOExchangeRateDeserializer(), new ERIOExchangeRateAdapter()),
                mainFrame.getMoneyDisplay()
        ))
        .put("reset", new ResetCommand(
                mainFrame.getDateDialog(),
                mainFrame.getMoneyDialog(),
                mainFrame.getMoneyDisplay(),
                mainFrame.getCurrencyDialog()
        ));
        mainFrame.setVisible(true);
    }
}
