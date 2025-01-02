package software.ulpgc.moneycalculator.apps.windows;

import software.ulpgc.moneycalculator.architecture.model.Currency;

import javax.swing.*;
import java.awt.*;

public class SwingUIStyles {
    public static void setTitleStyle(JLabel jLabel) {
        jLabel.setForeground(new Color(169, 204, 227));
        jLabel.setFont( new Font( "Monospaced", Font.BOLD, 35) );
    }

    public static void setTitleStyle(JPanel panel) {
        panel.setBackground(new Color(72, 77, 144));
        panel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
    }

    public static void setDefaultStyle(JLabel jLabel) {
        jLabel.setForeground(Color.white);
        jLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
    }

    public static void setDefaultStyle(JTextField jTextField) {
        jTextField.setFont(new Font("Monospaced", Font.BOLD, 20));
        jTextField.setBackground(Color.WHITE);
    }

    public static void setDefaultBackground(JPanel panel) {
        panel.setBackground(new Color(35, 35, 72));
    }

    public static void customizeFont(JComboBox<Currency> comboBox) {
        comboBox.setFont(new Font("Monospaced", Font.BOLD, 20));
    }

    public static void setDefaultStyle(JComboBox<Currency> comboBox) {
        comboBox.setPreferredSize(new Dimension(400,40));
        comboBox.setMaximumSize(new Dimension(400,40));
        comboBox.setBackground(Color.WHITE);
        SwingUIStyles.customizeFont(comboBox);
        comboBox.setMaximumRowCount(3);
    }
}
