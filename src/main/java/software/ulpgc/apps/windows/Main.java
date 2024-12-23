package software.ulpgc.apps.windows;

import software.ulpgc.architecture.control.CalculateCommand;
import software.ulpgc.architecture.control.ResetCommand;
import software.ulpgc.architecture.io.*;
import software.ulpgc.architecture.model.Currency;
import java.io.File;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        File file = new File("src/main/resources/currencies.tsv");
        List<Currency> currencyList = new FileCurrencyLoader(file, new TsvCurrencyDeserializer()).load();
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
