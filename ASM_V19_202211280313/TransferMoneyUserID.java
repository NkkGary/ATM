import javax.swing.JTextField;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;

public class TransferMoneyUserID extends MainScreen implements ActionListener{

    private JTextField transferMoneyUserID;

    public TransferMoneyUserID(String getFileName) {
        super(getFileName);
    }

    public String getTransferMoneyUserID() {
        return transferMoneyUserID.getText();
    }

    public void screenCenter(JButton[] centerButton, JPanel panel){

        transferMoneyUserID = getTextField("",true,(screenWidth-309)/2, 300, 605/2, 32) ;
        panel.add (transferMoneyUserID);
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
                transferMoneyUserID.setText(transferMoneyUserID.getText().concat( event.getActionCommand() ));
                break;

            case "00" : 
                transferMoneyUserID.setText(transferMoneyUserID.getText().concat( event.getActionCommand() ));
                break;

            case "." :
                transferMoneyUserID.setText(transferMoneyUserID.getText().concat( event.getActionCommand() ));
                break;

            case "7" :
                transferMoneyUserID.setText(transferMoneyUserID.getText().concat( event.getActionCommand() ));
                break;

            case "8" :
                transferMoneyUserID.setText(transferMoneyUserID.getText().concat( event.getActionCommand() ));
                break;

            case "9" :
                transferMoneyUserID.setText(transferMoneyUserID.getText().concat( event.getActionCommand() ));
                break;

            case "6" :
                transferMoneyUserID.setText(transferMoneyUserID.getText().concat( event.getActionCommand() ));
                break;

            case "5" :
                transferMoneyUserID.setText(transferMoneyUserID.getText().concat( event.getActionCommand() ));
                break;

            case "4" :
                transferMoneyUserID.setText(transferMoneyUserID.getText().concat( event.getActionCommand() ));
                break;

            case "3" :
                transferMoneyUserID.setText(transferMoneyUserID.getText().concat( event.getActionCommand() ));
                break;

            case "2" :
                transferMoneyUserID.setText(transferMoneyUserID.getText().concat( event.getActionCommand() ));
                break;

            case "1" :
                transferMoneyUserID.setText(transferMoneyUserID.getText().concat( event.getActionCommand() ));
                break;

            case "Enter":

                    waitingEnter = false;
                    dispose();   


                break;
            case "Change" :
                transferMoneyUserID.setText("");
                break;

            case "Cancel" :
                new MainMenuScreen("MainMenu.png");
                dispose();
                break;
        }

    } // end method actionPerformed

}
