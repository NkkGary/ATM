import javax.swing.JButton;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;


public class MainMenuScreen extends MainScreen implements ActionListener{

    public MainMenuScreen(String getFileName) {
        super(getFileName);
    }

    public void screenCenter(JButton[] centerButton, JPanel panel){

        //end of Center
    }

    public void actionPerformed( ActionEvent event )
    {
        switch (event.getActionCommand())
        {
            case "L2" : 
                new WithdrawalMenuScreen("WithdrawalMenu.png");
                dispose();
                break;
            case "L3":
                new ViewBalanceScreen("ViewBalance.png");
                dispose();
                break;
            case "R2":
                new Thread(() -> new TransferFunction()).start();
                dispose();
                break;
            case "R3":
                new ShowMessageScreen("CardEjected.png",false, 2, "logout");
                dispose();
                break;
                
        }
    } // end method actionPerformed
}
