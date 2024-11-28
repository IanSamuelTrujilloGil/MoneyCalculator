package software.ulpgc.apps.windows;

import software.ulpgc.architecture.control.CalculateCommand;
import software.ulpgc.architecture.control.ResetCommand;
import software.ulpgc.architecture.io.ERIOCurrencyLoader;
import software.ulpgc.architecture.io.ERIOExchangeRateLoader;
import software.ulpgc.architecture.io.FileCurrencyLoader;
import software.ulpgc.architecture.io.TsvCurrencyDeserializer;
import software.ulpgc.architecture.model.Currency;
import software.ulpgc.architecture.model.CurrencyCodeValidator;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {


    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\Ian\\IdeaProjects\\moneyCalculator\\src\\main\\resources\\currencies.tsv");
        List<Currency> currencyList = new FileCurrencyLoader(file, new TsvCurrencyDeserializer()).load();
        new CurrencyCodeValidator(new ERIOCurrencyLoader()).filterInvalidCurrencies(currencyList);
        MainFrame mainFrame = new MainFrame(currencyList);
        mainFrame.put("calculate", new CalculateCommand(
                mainFrame.getDateDialog(),
                mainFrame.getMoneyDialog(),
                mainFrame.getCurrencyDialog(),
                new ERIOExchangeRateLoader(),
                mainFrame.getMoneyDisplay()
        ));
        mainFrame.put("reset", new ResetCommand(
                mainFrame.getDateDialog(),
                mainFrame.getMoneyDialog(),
                mainFrame.getMoneyDisplay(),
                mainFrame.getCurrencyDialog()
        ));
        mainFrame.setVisible(true);
    }
}
