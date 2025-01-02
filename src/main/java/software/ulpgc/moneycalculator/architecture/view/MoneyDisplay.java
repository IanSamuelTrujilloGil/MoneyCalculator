package software.ulpgc.moneycalculator.architecture.view;

import software.ulpgc.moneycalculator.architecture.model.Money;

public interface MoneyDisplay {
    void display(Money money);
    void resetDisplay();
}
