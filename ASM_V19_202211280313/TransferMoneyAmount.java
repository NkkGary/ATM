import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;



public class TransferMoneyAmount extends MainScreen implements ActionListener{
    private JTextField transferMoneyAmount;
    public TransferMoneyAmount(String getFileName) {
        super(getFileName);
    }

    public String getTransferMoneyAmount() {
        return transferMoneyAmount.getText();
    }

    public void screenCenter(JButton[] centerButton, JPanel panel){

        transferMoneyAmount = getTextField("",true,(screenWidth-309)/2, 300, 605/2, 32);
        panel.add (transferMoneyAmount);
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
                transferMoneyAmount.setText(transferMoneyAmount.getText().concat( event.getActionCommand() ));
                break;

            case "00" : 
                transferMoneyAmount.setText(transferMoneyAmount.getText().concat( event.getActionCommand() ));
                break;

            case "." :
                transferMoneyAmount.setText(transferMoneyAmount.getText().concat( event.getActionCommand() ));
                break;

            case "7" :
                transferMoneyAmount.setText(transferMoneyAmount.getText().concat( event.getActionCommand() ));
                break;

            case "8" :
                transferMoneyAmount.setText(transferMoneyAmount.getText().concat( event.getActionCommand() ));
                break;

            case "9" :
                transferMoneyAmount.setText(transferMoneyAmount.getText().concat( event.getActionCommand() ));
                break;

            case "6" :
                transferMoneyAmount.setText(transferMoneyAmount.getText().concat( event.getActionCommand() ));
                break;

            case "5" :
                transferMoneyAmount.setText(transferMoneyAmount.getText().concat( event.getActionCommand() ));
                break;

            case "4" :
                transferMoneyAmount.setText(transferMoneyAmount.getText().concat( event.getActionCommand() ));
                break;

            case "3" :
                transferMoneyAmount.setText(transferMoneyAmount.getText().concat( event.getActionCommand() ));
                break;

            case "2" :
                transferMoneyAmount.setText(transferMoneyAmount.getText().concat( event.getActionCommand() ));
                break;

            case "1" :
                transferMoneyAmount.setText(transferMoneyAmount.getText().concat( event.getActionCommand() ));
                break;

            case "Enter":

                waitingEnter = false;
                dispose();

                break;
            case "Change" :
                transferMoneyAmount.setText("");
                break;

            case "Cancel" :
                new MainMenuScreen("MainMenu.png");
                dispose();
                break;
        }

    } // end method actionPerformed

}

