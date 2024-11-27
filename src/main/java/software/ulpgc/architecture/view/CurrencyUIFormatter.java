package software.ulpgc.architecture.view;

import software.ulpgc.architecture.model.Currency;

public class CurrencyUIFormatter {
    public static String formatForDialog(Currency currency) {
        return  currency.getName() +" " + currency.getCode() +" "+ getSymbolOrEmpty(currency);
    }
    private static String getSymbolOrEmpty(Currency currency) {
        return (currency.getSymbol() != null) ? currency.getSymbol() : "";
    }

}
