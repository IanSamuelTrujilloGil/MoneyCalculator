package software.ulpgc.apps.windows;

import software.ulpgc.architecture.model.Currency;

import javax.swing.*;
import java.awt.*;

public class SwingUIStyles {
    public static void customizeFont(JLabel jLabel) {
        jLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
    }

    public static void customizeFont(JComboBox<Currency> comboBox) {
        comboBox.setFont(new Font("Monospaced", Font.BOLD, 20));
    }

    public static void customizeFont(JTextField jTextField) {
        jTextField.setFont(new Font("Monospaced", Font.BOLD, 20));
    }
}
