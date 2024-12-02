package com.example.budgetwise.tabs;

import com.example.budgetwise.models.Account;
import com.example.budgetwise.models.AccountType;
import com.example.budgetwise.models.Currency;
import com.example.budgetwise.models.TransactionType;
import com.example.budgetwise.tables.*;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 * This class allows the user to edit a account
 */
public class EditAccountTab extends Tab {

    private static EditAccountTab instance;

    private ComboBox<Account> accountComboBox = new ComboBox<>();

    private EditAccountTab(){
        this.setText("Edit Account");

        GridPane root = new GridPane();

        root.setPadding(new Insets(10,10,10,10));
        root.setVgap(10);
        root.setHgap(10);
        root.getStyleClass().add("tab-background");


        Label accountLabel = new Label("Account");

        accountComboBox.getStyleClass().add("textfield-style");


        refresh();


        root.add(accountLabel,0,1);
        root.add(accountComboBox,1,1);

        /**
         * creating label and textfield for account form
         */
        Label nameLabel = new Label("New Account Name:");
        TextField nameField = new TextField();
        nameField.getStyleClass().add("textfield-style");
        nameField.setPrefWidth(150);
        root.add(nameLabel,0,2);
        root.add(nameField,1,2);

        Label transactionTypeLabel = new Label("Account Type:");
        ComboBox<AccountType> accountTypeComboBox = new ComboBox<>();
        accountTypeComboBox.getStyleClass().add("textfield-style");
        accountTypeComboBox.setValue(AccountTypeTable.getInstance().getAllAccountTypes().get(0));


        accountTypeComboBox.setItems(FXCollections.observableArrayList(AccountTypeTable.getInstance().getAllAccountTypes()));
        root.add(transactionTypeLabel,0,3);
        root.add(accountTypeComboBox,1,3);

        Label currency = new Label("New Currency:");
        ComboBox<Currency> currencyComboBox = new ComboBox<>();
        currencyComboBox.getStyleClass().add("textfield-style");
        currencyComboBox.setItems(FXCollections.observableArrayList(CurrencyTable.getInstance().getAllCurrency()));
        currencyComboBox.setValue(CurrencyTable.getInstance().getAllCurrency().get(0));

        root.add(currency, 0,4);
        root.add(currencyComboBox,1,4);

        Button editBtn = new Button("Edit Account");
        editBtn.getStyleClass().add("button-style");
        root.add(editBtn,1,5);

        Button deleteBtn  = new Button("Delete Account");
        deleteBtn.getStyleClass().add("button-style");
        root.add(deleteBtn,2,5);


        Text error = new Text("Please fill all fields");
        error.setFill(Color.rgb(255,0,0,0));
        root.add(error,1,6);


        Text success = new Text("Account successfully updated");
        success.setFill(Color.rgb(0,255,0,0));

        root.add(success,1,6);


        this.setOnSelectionChanged(event -> {
            error.setFill(Color.rgb(255,0,0,0));

            success.setFill(Color.rgb(0,255,0,0));

        });

        String css = getClass().getResource("/styles.css").toExternalForm();
        root.getStylesheets().add(css); // Ensure this line is executed

        this.setContent(root);


        deleteBtn.setOnAction(event -> {
            Account selectedAccount = accountComboBox.getValue();


            if (selectedAccount != null){
                error.setFill(Color.rgb(255,0,0,0));
                success.setFill(Color.rgb(0,255,0,1));
                AccountTable.getInstance().deleteAccount(selectedAccount);
                success.setText("Account Successfully deleted");
                ViewAccountsTab.getInstance().refresh();
                AddTransactionTab.getInstance().refresh();
                refresh();
            }else{
                error.setFill(Color.rgb(255,0,0,1));
                success.setFill(Color.rgb(0,255,0,0));
                error.setText("Please Choose an account");
            }



        });

        editBtn.setOnAction(event -> {
            Account selectedAccount = accountComboBox.getValue();
            Currency selectedCurrency = currencyComboBox.getValue();
            AccountType selectedAccountType = accountTypeComboBox.getValue();
            String selectedName = nameField.getText();

            if (selectedName.length() >=1 && selectedAccount != null){
                selectedAccount.setName(selectedName);
                selectedAccount.setCurrency_id(selectedCurrency.getId());
                selectedAccount.setType_id(selectedAccountType.getId());
                AccountTable.getInstance().updateAccount(selectedAccount);
                error.setFill(Color.rgb(255,0,0,0));
                success.setFill(Color.rgb(0,255,0,1));
                success.setText("Account successfully updated");
                ViewAccountsTab.getInstance().refresh();
                AddTransactionTab.getInstance().refresh();
                refresh();
            }else{
                error.setFill(Color.rgb(255,0,0,1));
                success.setFill(Color.rgb(0,255,0,0));
                error.setText("Please fill all fields");
            }



        });


    }

    /**
     * This method will refresh the comboBox when the user modifies the database
     */
    public void refresh(){
        accountComboBox.setItems(FXCollections.observableArrayList(AccountTable.getInstance().getAllAccounts()));

        if (AccountTable.getInstance().getAllAccounts().size() >=1){
            accountComboBox.setValue(AccountTable.getInstance().getAllAccounts().get(0));
        }else{
            accountComboBox.setPlaceholder(new Text("Please create an account"));
        }

    }

    public static EditAccountTab getInstance(){
        if (instance == null){
            instance = new EditAccountTab();
        }
        return instance;
    }


}
