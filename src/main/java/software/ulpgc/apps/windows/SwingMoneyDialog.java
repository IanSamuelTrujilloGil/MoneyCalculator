package software.ulpgc.apps.windows;

import software.ulpgc.architecture.model.Money;
import software.ulpgc.architecture.view.MoneyDialog;

import javax.swing.*;
import java.awt.*;

public class SwingMoneyDialog extends JPanel implements MoneyDialog {
    private JTextField amountField;
    private final SwingCurrencyDialog currencyDialog;

    public SwingMoneyDialog(SwingCurrencyDialog currencyDialog) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(panel());
        this.add(this.currencyDialog = currencyDialog);
        this.setMaximumSize(new Dimension(Integer.MAX_VALUE,20));

    }

    private Component panel() {
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(createAmountLabel());
        panel.add(this.amountField = amountField());
        SwingUIStyles.setDefaultBackground(panel);
        return panel;
    }

    private static JLabel createAmountLabel() {
        JLabel jLabel = new JLabel("Amount:");
        SwingUIStyles.setDefaultStyle(jLabel);
        return jLabel;
    }

    private JTextField amountField() {
        JTextField textField = new JTextField(defaultMoneyAmount(),20);
        SwingUIStyles.setDefaultStyle(textField);
        return textField;
    }

    @Override
    public Money get() {
        return new Money(toDouble(amountField.getText()), currencyDialog.get());
    }

    @Override
    public void reset() {
        amountField.setText(defaultMoneyAmount());
        currencyDialog.reset();
    }

    private String defaultMoneyAmount() {
        return "0.0";
    }

    private double toDouble(String text) {
        return Double.parseDouble(text);
    }
}
