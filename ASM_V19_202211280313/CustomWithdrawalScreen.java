import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;


public class CustomWithdrawalScreen extends MainScreen implements ActionListener{
    private static JTextField amountText;
    private boolean waitingEnter = true;

    public CustomWithdrawalScreen(String getFileName) {
        super(getFileName);
    }

    public String getAmount() {
        return amountText.getText();
    }

    public void execute()
    {
        double availableBalance; // amount available for withdrawal
        // get available balance of account involved
        availableBalance = 
        bankDatabase.getAvailableBalance( getAccount() );
        int withdrawlAmount = Integer.parseInt(getAmount());
        if(withdrawlAmount % 100 == 0) {
            // check whether the user has enough money in the account 
            if ( withdrawlAmount <= availableBalance && withdrawlAmount > 0)
            {   
                // check whether the cash dispenser has enough money
                if ( cashDispenser.isSufficientCashAvailable( withdrawlAmount ) )
                {
                    new confirmWithdrawalScreen("ConfirmWithdrawal.png",withdrawlAmount); //Insufficient cash available in the ATM.
                    dispose();
                } // end if
                else {// cash dispenser does not have enough cash
                    new ShowMessageScreen("ATMInsufficientCash.png",false,3); //Insufficient cash available in the ATM.
                    dispose();

                    /*screen.displayMessageLine( 
                    "\nInsufficient cash available in the ATM." +
                    "\n\nPlease choose a smaller amount." );*/
                }
            } // end if
            else // not enough money available in user's account
            {
                new ShowMessageScreen("AccountOrBalanceError.png",false,3); //Insufficient funds in your account.
                dispose();

                /*
                screen.displayMessageLine( 
                "\nInsufficient funds in your account." +
                "\n\nPlease enter a smaller amount or positive amount." );*/
            } // end else
        } else {
            new ShowMessageScreen("ErrorWithdrawal.png",false,3); //Only the multiples of HKD100, HKD500, or HKD1000 are allowed. Try again.
            dispose();
            // screen.displayMessageLine( "\nOnly the multiples of HKD100, HKD500, or HKD1000 are allowed. Try again." );
        }

    } // end method execute

    public void screenCenter(JButton[] centerButton, JPanel panel){
        amountText = getTextField("",true,(screenWidth-309)/2, 300, 605/2, 32);
        panel.add (amountText);
        //end of Center
    }

    public void waiting() { 
        while(waitingEnter) {
            try
            {
                Thread.sleep(1);
            }
            catch (InterruptedException ie)
            {
                ie.printStackTrace();
            }
        }
    }

    public void actionPerformed( ActionEvent event )
    {

        switch (event.getActionCommand())
        {
            case "0" : 
                amountText.setText(amountText.getText().concat( event.getActionCommand() ));
                break;

            case "00" : 
                amountText.setText(amountText.getText().concat( event.getActionCommand() ));
                break;

            case "." :
                amountText.setText(amountText.getText().concat( event.getActionCommand() ));
                break;

            case "7" :
                amountText.setText(amountText.getText().concat( event.getActionCommand() ));
                break;

            case "8" :
                amountText.setText(amountText.getText().concat( event.getActionCommand() ));
                break;

            case "9" :
                amountText.setText(amountText.getText().concat( event.getActionCommand() ));
                break;

            case "6" :
                amountText.setText(amountText.getText().concat( event.getActionCommand() ));
                break;

            case "5" :
                amountText.setText(amountText.getText().concat( event.getActionCommand() ));
                break;

            case "4" :
                amountText.setText(amountText.getText().concat( event.getActionCommand() ));
                break;

            case "3" :
                amountText.setText(amountText.getText().concat( event.getActionCommand() ));
                break;

            case "2" :
                amountText.setText(amountText.getText().concat( event.getActionCommand() ));
                break;

            case "1" :
                amountText.setText(amountText.getText().concat( event.getActionCommand() ));
                break;

            case "Enter":
                //call withdrawl function here
                execute();
                waitingEnter = false;
                dispose();
                break;

            case "Change" :
                amountText.setText("");
                break;

            case "Cancel" :
                new MainMenuScreen("MainMenu.png");
                dispose();
                break;
        }
    } // end method actionPerformed
}
