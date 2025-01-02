package software.ulpgc.moneycalculator.apps.windows;

import software.ulpgc.moneycalculator.architecture.view.DateDialog;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class SwingDateDialog extends JPanel implements DateDialog {
    private final JTextField dateField;

    public SwingDateDialog() {
        setLayout(new FlowLayout(FlowLayout.CENTER));
        this.add(dateLabel());
        this.add(this.dateField = dateField());
        this.setMaximumSize(new Dimension(Integer.MAX_VALUE,20));
        SwingUIStyles.setDefaultBackground(this);
    }

    private static JLabel dateLabel() {
        JLabel jLabel = new JLabel("Date:");
        SwingUIStyles.setDefaultStyle(jLabel);
        return jLabel;

    }

    private JTextField dateField() {
        JTextField textField = new JTextField(defaultDate(),11);
        SwingUIStyles.setDefaultStyle(textField);
        return textField;
    }

    private static String defaultDate() {
        return LocalDate.now().toString();
    }

    @Override
    public LocalDate get() {
        return parseDateFromTextField();
    }

    @Override
    public void resetDate() {
        dateField.setText(defaultDate());
    }

    private LocalDate parseDateFromTextField() {
        return LocalDate.parse(dateField.getText());
    }

}
