package software.ulpgc.apps.windows;

import software.ulpgc.architecture.control.Command;
import software.ulpgc.architecture.model.Currency;
import software.ulpgc.architecture.view.CurrencyDialog;
import software.ulpgc.architecture.view.MoneyDialog;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class MainFrame extends JFrame {
    private final List<Currency> currencies;
    private SwingMoneyDialog moneyDialog;
    private SwingCurrencyDialog currencyDialog;
    private SwingDateDialog dateDialog;
    private SwingMoneyDisplay moneyDisplay;
    private final Map<String, Command> commands;

    public MainFrame(List<Currency> currencies) throws HeadlessException {
        this.currencies = currencies;
        this.commands = new HashMap<>();
        this.setTitle("MoneyCalculator");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(900, 800);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.add(toolbar(), BorderLayout.SOUTH);
        this.add(createTitle(), BorderLayout.NORTH);
        this.add(createCenterPanel(),BorderLayout.CENTER);
    }

    public MoneyDialog getMoneyDialog() {
        return moneyDialog;
    }

    public SwingMoneyDisplay getMoneyDisplay() {
        return moneyDisplay;
    }

    public SwingDateDialog getDateDialog() {
        return dateDialog;
    }

    public CurrencyDialog getCurrencyDialog() {
        return currencyDialog;
    }

    public void put(String key, Command value) {
        commands.put(key, value);
    }

    private Component createTitle() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
        jPanel.add(createTitleLabel());
        jPanel.add(createNameLabel());
        SwingUIStyles.setTitleStyle(jPanel);
        return jPanel;
    }

    private JLabel createTitleLabel(){
        JLabel title = new JLabel("Money Calculator");
        SwingUIStyles.setTitleStyle(title);
        centerAlignComponent(title);
        return title;
    }

    private JLabel createNameLabel() {
        JLabel name = new JLabel("Ian Samuel Trujillo Gil");
        SwingUIStyles.setDefaultStyle(name);
        centerAlignComponent(name);
        return name;
    }



    private JPanel createCenterPanel() {
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        addFlexibleVerticalSpace(centerPanel);
        centerPanel.add(this.dateDialog = new SwingDateDialog());
        addFlexibleVerticalSpace(centerPanel);
        addFromComponents(centerPanel);
        addFlexibleVerticalSpace(centerPanel);
        addToComponents(centerPanel);
        SwingUIStyles.setDefaultBackground(centerPanel);
        return centerPanel;
    }

    private void addToComponents(JPanel panel) {
        panel.add(createToLabel());
        panel.add(this.moneyDisplay = new SwingMoneyDisplay());
        panel.add(this.currencyDialog = new SwingCurrencyDialog(this.currencies));
    }

    private void addFromComponents(JPanel panel) {
        panel.add(createFromLabel());
        panel.add(this.moneyDialog = new SwingMoneyDialog(new SwingCurrencyDialog(this.currencies)));
    }

    private void addFlexibleVerticalSpace(JPanel panel) {
        panel.add(Box.createVerticalGlue());
    }

    private JLabel createToLabel() {
        JLabel jLabel = new JLabel("To");
        SwingUIStyles.setDefaultStyle(jLabel);
        return jLabel;
    }

    private JLabel createFromLabel() {
        JLabel jLabel = new JLabel("From");
        SwingUIStyles.setDefaultStyle(jLabel);
        return jLabel;
    }

    private void centerAlignComponent(JComponent component) {
        component.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    private Component toolbar() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(button("reset"));
        panel.add(button("calculate"));
        SwingUIStyles.setDefaultBackground(panel);
        return panel;
    }

    private Component button(String name) {
        JButton button = new JButton(name);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                commands.get(name).execute();
            }
        });
        return button;
    }
}
