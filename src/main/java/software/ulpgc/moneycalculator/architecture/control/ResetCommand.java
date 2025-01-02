package software.ulpgc.moneycalculator.architecture.control;


import software.ulpgc.moneycalculator.architecture.view.CurrencyDialog;
import software.ulpgc.moneycalculator.architecture.view.DateDialog;
import software.ulpgc.moneycalculator.architecture.view.MoneyDialog;
import software.ulpgc.moneycalculator.architecture.view.MoneyDisplay;




public class ResetCommand implements Command {
    private final DateDialog dateDialog;
    private final MoneyDialog moneyDialog;
    private final MoneyDisplay moneyDisplay;
    private final CurrencyDialog currencyDialog;

    public ResetCommand(DateDialog dateDialog, MoneyDialog moneyDialog, MoneyDisplay moneyDisplay, CurrencyDialog currencyDialog) {
        this.dateDialog = dateDialog;
        this.moneyDialog = moneyDialog;
        this.moneyDisplay = moneyDisplay;
        this.currencyDialog = currencyDialog;
    }

    @Override
    public void execute() {
        moneyDialog.reset();
        dateDialog.resetDate();
        moneyDisplay.resetDisplay();
        currencyDialog.reset();
    }
}
