import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;


public class accountLoginScreen extends MainScreen implements ActionListener{
    private static JTextField userText;
    

    public accountLoginScreen(String getFileName) {
        super(getFileName);
    }

    public void screenCenter(JButton[] centerButton, JPanel panel){
        userText = getTextField("",true,(screenWidth-309)/2, 300, 605/2, 32) ;
        panel.add (userText);
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
                userText.setText(userText.getText().concat( event.getActionCommand() ));
                break;

            case "00" : 
                userText.setText(userText.getText().concat( event.getActionCommand() ));
                break;

            case "." :
                userText.setText(userText.getText().concat( event.getActionCommand() ));
                break;

            case "7" :
                userText.setText(userText.getText().concat( event.getActionCommand() ));
                break;

            case "8" :
                userText.setText(userText.getText().concat( event.getActionCommand() ));
                break;

            case "9" :
                userText.setText(userText.getText().concat( event.getActionCommand() ));
                break;

            case "6" :
                userText.setText(userText.getText().concat( event.getActionCommand() ));
                break;

            case "5" :
                userText.setText(userText.getText().concat( event.getActionCommand() ));
                break;

            case "4" :
                userText.setText(userText.getText().concat( event.getActionCommand() ));
                break;

            case "3" :
                userText.setText(userText.getText().concat( event.getActionCommand() ));
                break;

            case "2" :
                userText.setText(userText.getText().concat( event.getActionCommand() ));
                break;

            case "1" :
                userText.setText(userText.getText().concat( event.getActionCommand() ));
                break;

            case "Enter":

                try {  
                    setAccount(Integer.parseInt(userText.getText()));
                    waitingEnter = false;
                    dispose();

                } catch(NumberFormatException e){  

                } 
                break;

            case "Change" :
                userText.setText("");
                break;

            case "Cancel" :
                userText.setText("");
                break;
        }
    } // end method actionPerformed
}
