import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;

public class WithdrawalMenuScreen extends MainScreen implements ActionListener{

    public WithdrawalMenuScreen(String getFileName) {
        super(getFileName);
    }
    
    public void screenCenter(JButton[] centerButton, JPanel panel){

        //end of Center
    }

    public void actionPerformed( ActionEvent event )
    {
        switch (event.getActionCommand())
        {
            case "L1" : 
                new FixedAmountWithdrawalScreen("Withdrawal100.png",100);
                dispose();
                break;
            case "L2" : 
                new FixedAmountWithdrawalScreen("Withdrawal500.png",500);
                dispose();
                break;
            case "L3" : 
                new FixedAmountWithdrawalScreen("Withdrawal1000.png",1000);
                dispose();
                break;
            case "R1" : 
                new CustomWithdrawalScreen("customWithdrawal.png");
                dispose();
                break;
            case "R3" : 
                new MainMenuScreen("MainMenu.png");
                dispose();
                break;
            case "Cancel":
                new MainMenuScreen("MainMenu.png");
                dispose();
                break;
        }
    } // end method actionPerformed
}
