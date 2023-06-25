import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;


public class MainScreen extends JFrame implements ActionListener{

    protected static JButton leftButton[] = new JButton[4];
    protected static JButton centerButton[] = new JButton[1];
    protected static JButton rightButton[] = new JButton[4];
    protected static JButton bottomOfCenterButton[] = new JButton[16];
    protected static BankDatabase bankDatabase = new BankDatabase();
    protected static CashDispenser cashDispenser = new CashDispenser();
    protected boolean waitingEnter = true;
  
    protected static int userAccount = 0;
    private static int userPassword = 0;
    public final int screenWidth = 1024;
    public final int screenHeight = 768;
    

    public BankDatabase getBankDatabase() {
        return bankDatabase;
    }

    public CashDispenser getCashDispenser() {
        return cashDispenser;
    }

    public int getPassword() {
        return userPassword;
    }

    public int getAccount() {
        return userAccount;
    }

    public void setPassword(int pass) {
        userPassword = pass;
    }

    public void setAccount(int ac) {
        userAccount = ac;
    }

    public void logout() {
        userAccount = 0;
        userPassword = 0;
    }

    public void screenCenter(JButton[] centerButton, JPanel panel) {
    }

    public MainScreen() {
    }

    public MainScreen(String backgroundFileName) {
        setResizable(false);
        setSize (screenWidth, screenHeight);
        setVisible(true);
        JPanel panel = new JPanel ();

        panel.setLayout(new BorderLayout());
        getLeftButton(leftButton,panel);
        getRightButton(rightButton,panel);
        getBottomOfCenterButton(bottomOfCenterButton,panel);
        screenCenter(centerButton,panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel background=new JLabel(new ImageIcon(backgroundFileName));
        panel.add(background);
        add(panel);
    }

    public void getLeftButton(JButton[] leftButton, JPanel panel){
        for ( int count = 0; count < 3; count++ ) 
        {
            leftButton[count] = new JButton( ">>" );
            leftButton[count].setActionCommand("L"+Integer.toString(count+1));
            leftButton[count].addActionListener(this); 
            leftButton[count].setBounds (0, 95*(count+1)+35, 180, 50);
            panel.add(leftButton[count]); 
        } // end for
    }

    public void getRightButton(JButton[] rightButton, JPanel panel){
        for ( int count = 0; count < 3; count++ ) 
        {
            rightButton[count] = new JButton( "<<" );
            rightButton[count].setActionCommand("R"+Integer.toString(count+1));
            rightButton[count].setBounds(screenWidth-180-15, 95*(count+1)+35, 180, 50);
            rightButton[count].addActionListener(this); 
            panel.add(rightButton[count]); 
        } // end for
    }

    public void getBottomOfCenterButton(JButton[] bottomOfCenterButton, JPanel panel){
        String keypad[]={"0","00",".","Enter","7","8","9","Change","4","5","6","Cancel","1","2","3",""};
        int buttonCount = 0;
        for ( int runTimes = 0; runTimes < 4; runTimes++) {
            for ( int count = 0; count < 4; count++ ) 
            {
                bottomOfCenterButton[buttonCount] = new JButton( keypad[buttonCount] );
                bottomOfCenterButton[buttonCount].setBounds (screenWidth/2-160+80*(count), screenHeight-30*(runTimes+2)-100, 80, 25);
                bottomOfCenterButton[buttonCount].addActionListener(this); 
                panel.add(bottomOfCenterButton[buttonCount]); 
                buttonCount++;
            } // end for
        }
    }

    public JTextField getTextField(String defaultString, boolean editable, int bound_a, int bound_b, int bound_c, int bound_d) {
        JTextField genTextField = new JTextField(defaultString,20);
        genTextField.setEditable( editable );
        genTextField.setBackground(new Color(0,0,0,80));
        genTextField.setOpaque(false);
        genTextField.setForeground(Color.WHITE);

        Font fontSetting = new Font("SansSerif", Font.BOLD, 28);
        genTextField.setFont(fontSetting);
        genTextField.setBounds (bound_a, bound_b, bound_c, bound_d);
        return genTextField;
    }

    public JPasswordField getPasswordTextField(String defaultString, boolean editable, int bound_a, int bound_b, int bound_c, int bound_d) {
        JPasswordField getPasswordTextField = new JPasswordField(defaultString,20);
        getPasswordTextField.setEditable( editable );
        getPasswordTextField.setBackground(new Color(0,0,0,80));
        getPasswordTextField.setOpaque(false);
        getPasswordTextField.setForeground(Color.WHITE);

        Font fontSetting = new Font("SansSerif", Font.BOLD, 28);
        getPasswordTextField.setFont(fontSetting);
        getPasswordTextField.setBounds (bound_a, bound_b, bound_c, bound_d);
        return getPasswordTextField;
    }

    public void show(String text) {
        JOptionPane.showMessageDialog( null, text ); 
    }

    public void actionPerformed( ActionEvent event )
    {
        JOptionPane.showMessageDialog( null, "You are in MainScreen." ); 
    } // end method actionPerformed

}
