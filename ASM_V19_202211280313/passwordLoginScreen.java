
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;


public class passwordLoginScreen extends MainScreen implements ActionListener{
    private JPasswordField passwordText;
    

    public passwordLoginScreen(String getFileName) {
        super(getFileName);
    }

    public void screenCenter(JButton[] centerButton, JPanel panel){
        passwordText = getPasswordTextField("",true,(screenWidth-309)/2, 300, 605/2, 32);
        panel.add (passwordText);

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
                passwordText.setText(passwordText.getText().concat( event.getActionCommand() ));
                break;

            case "00" : 
                passwordText.setText(passwordText.getText().concat( event.getActionCommand() ));
                break;

            case "." :
                passwordText.setText(passwordText.getText().concat( event.getActionCommand() ));
                break;

            case "7" :
                passwordText.setText(passwordText.getText().concat( event.getActionCommand() ));
                break;

            case "8" :
                passwordText.setText(passwordText.getText().concat( event.getActionCommand() ));
                break;

            case "9" :
                passwordText.setText(passwordText.getText().concat( event.getActionCommand() ));
                break;

            case "6" :
                passwordText.setText(passwordText.getText().concat( event.getActionCommand() ));
                break;

            case "5" :
                passwordText.setText(passwordText.getText().concat( event.getActionCommand() ));
                break;

            case "4" :
                passwordText.setText(passwordText.getText().concat( event.getActionCommand() ));
                break;

            case "3" :
                passwordText.setText(passwordText.getText().concat( event.getActionCommand() ));
                break;

            case "2" :
                passwordText.setText(passwordText.getText().concat( event.getActionCommand() ));
                break;

            case "1" :
                passwordText.setText(passwordText.getText().concat( event.getActionCommand() ));
                break;

            case "Enter":

                try {  
                    setPassword(Integer.parseInt(passwordText.getText()));
                    waitingEnter = false;
                    dispose();  
                } catch(NumberFormatException e){  

                } 

                break;

            case "Change" :
                passwordText.setText("");
                break;

            case "Cancel" :
                passwordText.setText("");
                break;
        }
    } // end method actionPerformed
}
