package software.ulpgc.apps.windows;

import software.ulpgc.architecture.view.DateDialog;

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
    }

    private static JLabel dateLabel() {
        JLabel jLabel = new JLabel("Date:");
        SwingUIStyles.customizeFont(jLabel);
        return jLabel;

    }

    private JTextField dateField() {
        JTextField textField = new JTextField(defaultDate(),11);
        SwingUIStyles.customizeFont(textField);
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
