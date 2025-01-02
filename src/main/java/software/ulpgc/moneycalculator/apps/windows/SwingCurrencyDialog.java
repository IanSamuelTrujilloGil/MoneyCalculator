package software.ulpgc.moneycalculator.apps.windows;

import software.ulpgc.moneycalculator.architecture.model.Currency;
import software.ulpgc.moneycalculator.architecture.view.CurrencyDialog;
import software.ulpgc.moneycalculator.architecture.view.CurrencyUIFormatter;

import javax.swing.*;

import java.awt.*;

import java.util.List;

public class SwingCurrencyDialog extends JPanel implements CurrencyDialog {
    private final List<Currency> currencies;
    private final JComboBox<Currency> selector;

    public SwingCurrencyDialog(List<Currency> currencies) {
        this.currencies = sortCurrenciesByName(currencies);
        this.add(selector = selector());
        SwingUIStyles.setDefaultBackground(this);
    }

    private JComboBox<Currency> selector() {
        JComboBox<Currency> comboBox = new JComboBox<>();
        for (Currency currency : currencies)
            comboBox.addItem(currency);
        configureComboBoxRenderer(comboBox);
        SwingUIStyles.setDefaultStyle(comboBox);
        return comboBox;
    }



    private List<Currency> sortCurrenciesByName(List<Currency> currencies) {
        currencies.sort((a,b) -> a.getName().compareTo(b.getName()));
        return currencies;
    }

    private void configureComboBoxRenderer(JComboBox<Currency> comboBox) {
        comboBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value,
                                                          int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Currency currency)
                    setText(CurrencyUIFormatter.formatForDialog(currency));

                return this;
            }
        });
    }

    @Override
    public Currency get() {
        return currencies.get(selector.getSelectedIndex());
    }

    @Override
    public void reset() {
        if (!currencies.isEmpty())
            selector.setSelectedIndex(0);

    }

}
