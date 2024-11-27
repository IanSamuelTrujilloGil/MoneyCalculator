package software.ulpgc.architecture.view;

import software.ulpgc.architecture.model.Money;

public interface MoneyDisplay {
    void display(Money money);
    void resetDisplay();
}
