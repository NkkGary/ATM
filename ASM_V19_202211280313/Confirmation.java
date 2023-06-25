import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;


public class Confirmation extends MainScreen {
    private JTextField confirmUserID;
    private JTextField confirmAmount;
    private int transferAccount;
    private double amount;

    public Confirmation(String getFileName,int userID,double tranAmount) {
        super(getFileName);
        confirmUserID.setText(Integer.toString(userID));
        confirmAmount.setText(Double.toString(tranAmount));
        transferAccount = userID;
        amount = tranAmount;
    }

    public void screenCenter(JButton[] centerButton, JPanel panel){

        confirmUserID = getTextField("",false,(screenWidth)/2+45, 167, 240, 32);
        panel.add (confirmUserID);

        confirmAmount = getTextField("",false,(screenWidth)/2+45, 265, 240, 32);
        panel.add (confirmAmount);
        //end of Center
    }

    private void execute() {
        double availableBalance; // amount available for withdrawal
        if( transferAccount == getAccount()) {
            new ShowMessageScreen("AccountOrBalanceError.png",false,3); // Cannot transfer to same account
            dispose();
        } else {
            if(bankDatabase.checkAccountExist(transferAccount)) {
                // get available balance of account involved
                availableBalance = 
                bankDatabase.getAvailableBalance( getAccount() );

                // check whether the user has enough money in the account 
                if ( amount <= availableBalance && amount > 0)
                {   
                    // update the account involved to reflect withdrawal
                    bankDatabase.debit( getAccount(), amount );
                    bankDatabase.transferAdd( transferAccount, amount );

                    new ShowMessageScreen("TransferSuccessful.png",false,3); //Successfully transferred
                    dispose();

                    //screen.displayMessageLine( 
                    //    "\nSuccessfully transferred." );
                } // end if
                else // not enough money available in user's account
                {
                    new ShowMessageScreen("AccountOrBalanceError.png",false,3); //Insufficient funds in your account.
                    dispose();
                    //screen.displayMessageLine( 
                    //    "\nInsufficient funds in your account." +
                    //    "\n\nPlease enter a smaller amount or positive amount." );
                } // end else
            } else {
                //transfer account not exist
                new ShowMessageScreen("AccountOrBalanceError.png",false,3); //Transfer account does not exist. Please try again.
                dispose();
                //screen.displayMessageLine( 
                //    "\nTransfer account does not exist. Please try again." );
            }
        }
    }

    public void actionPerformed( ActionEvent event )
    {
        switch (event.getActionCommand())
        {
            case "Enter" : 
                execute();
                break;
            case "Change" : 
                new Thread(() -> new TransferFunction()).start();
                dispose();
                break;
            case "Cancel":
                new MainMenuScreen("MainMenu.png");
                dispose();
                break;
        }
    } // end method actionPerformed
}

