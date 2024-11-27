package software.ulpgc.apps.windows;

import software.ulpgc.architecture.model.Money;
import software.ulpgc.architecture.view.MoneyDisplay;


import javax.swing.*;
import java.awt.*;
import java.util.Locale;


public class SwingMoneyDisplay extends JPanel implements MoneyDisplay {
    private JLabel displayLabel;
    private JTextField resultField;

    public SwingMoneyDisplay() {
        this.setLayout(new FlowLayout());
        this.add(createDisplayLabel());
        this.add(createResultField());
        this.setMaximumSize(new Dimension(Integer.MAX_VALUE,20));
    }

    private JTextField createResultField() {
        this.resultField = new JTextField();
        this.resultField.setColumns(20);
        disableUserInput(resultField);
        SwingUIStyles.customizeFont(resultField);
        this.resultField.setBackground(Color.WHITE);
        return resultField;
    }

    private void disableUserInput(JTextField resultField) {
        this.resultField.setEditable(false);
    }

    private JLabel createDisplayLabel() {
        this.displayLabel = new JLabel("Result:");
        SwingUIStyles.customizeFont(displayLabel);
        this.displayLabel.setHorizontalAlignment(SwingConstants.CENTER);
        return displayLabel;
    }

    @Override
    public void display(Money money) {
        resultField.setText(formatAmountForDisplay(money.getAmount()));
    }

    public String formatAmountForDisplay(double amount) {
        return String.format(Locale.US, "%.2f", amount);
    }

    @Override
    public void resetDisplay(){
        resultField.setText("");
    }
}
