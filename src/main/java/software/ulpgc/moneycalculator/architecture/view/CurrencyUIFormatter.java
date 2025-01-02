package software.ulpgc.moneycalculator.architecture.view;

import software.ulpgc.moneycalculator.architecture.model.Currency;

public class CurrencyUIFormatter {
    public static String formatForDialog(Currency currency) {
        return  currency.getName() +" " + currency.getCode() +" "+ getSymbolOrEmpty(currency);
    }
    private static String getSymbolOrEmpty(Currency currency) {
        return (currency.getSymbol() != null) ? currency.getSymbol() : "";
    }

}
