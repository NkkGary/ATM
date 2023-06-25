import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;


public class confirmWithdrawalScreen extends MainScreen implements ActionListener{
    private JTextField withdrawlAmountText;
    private int withdrawlAmount;
    

    public confirmWithdrawalScreen(String getFileName, int withdrawalAmount) {
        super(getFileName);
        this.withdrawlAmount = withdrawalAmount;
        withdrawlAmountText.setText(Integer.toString(withdrawlAmount));
    }

    public void screenCenter(JButton[] centerButton, JPanel panel){
        withdrawlAmountText = getTextField("",true,(screenWidth-309)/2, 300, 605/2, 32) ;
        panel.add (withdrawlAmountText);
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
                withdrawlAmountText.setText(withdrawlAmountText.getText().concat( event.getActionCommand() ));
                break;

            case "00" : 
                withdrawlAmountText.setText(withdrawlAmountText.getText().concat( event.getActionCommand() ));
                break;

            case "." :
                withdrawlAmountText.setText(withdrawlAmountText.getText().concat( event.getActionCommand() ));
                break;

            case "7" :
                withdrawlAmountText.setText(withdrawlAmountText.getText().concat( event.getActionCommand() ));
                break;

            case "8" :
                withdrawlAmountText.setText(withdrawlAmountText.getText().concat( event.getActionCommand() ));
                break;

            case "9" :
                withdrawlAmountText.setText(withdrawlAmountText.getText().concat( event.getActionCommand() ));
                break;

            case "6" :
                withdrawlAmountText.setText(withdrawlAmountText.getText().concat( event.getActionCommand() ));
                break;

            case "5" :
                withdrawlAmountText.setText(withdrawlAmountText.getText().concat( event.getActionCommand() ));
                break;

            case "4" :
                withdrawlAmountText.setText(withdrawlAmountText.getText().concat( event.getActionCommand() ));
                break;

            case "3" :
                withdrawlAmountText.setText(withdrawlAmountText.getText().concat( event.getActionCommand() ));
                break;

            case "2" :
                withdrawlAmountText.setText(withdrawlAmountText.getText().concat( event.getActionCommand() ));
                break;

            case "1" :
                withdrawlAmountText.setText(withdrawlAmountText.getText().concat( event.getActionCommand() ));
                break;

            case "Enter":

                try {  
                    // update the account involved to reflect withdrawal
                    bankDatabase.debit( getAccount(), withdrawlAmount );

                    cashDispenser.dispenseCash( withdrawlAmount ); // dispense cash

                    new ShowMessageScreen("takeCard.png",false,3, "withdrawlComplete1"); //Please take your cash now.
                    dispose();

                } catch(NumberFormatException e){  

                } 
                break;

            case "Change" :
                withdrawlAmountText.setText("");
                break;

            case "Cancel" :
                new MainMenuScreen("MainMenu.png");
                dispose();
                break;
        }
    } // end method actionPerformed
}
