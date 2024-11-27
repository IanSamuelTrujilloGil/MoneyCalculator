package software.ulpgc.architecture.control;


import software.ulpgc.architecture.view.DateDialog;
import software.ulpgc.architecture.view.MoneyDialog;
import software.ulpgc.architecture.view.MoneyDisplay;




public class ResetCommand implements Command {
    private final DateDialog dateDialog;
    private final MoneyDialog moneyDialog;
    private final MoneyDisplay moneyDisplay;

    public ResetCommand(DateDialog dateDialog, MoneyDialog moneyDialog, MoneyDisplay moneyDisplay) {
        this.dateDialog = dateDialog;
        this.moneyDialog = moneyDialog;
        this.moneyDisplay = moneyDisplay;
    }

    @Override
    public void execute() {
        moneyDialog.resetMoney();
        dateDialog.resetDate();
        moneyDisplay.resetDisplay();
    }
}
