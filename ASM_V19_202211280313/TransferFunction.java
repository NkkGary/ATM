
/**
 * Write a description of class runLogin here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TransferFunction extends MainScreen
{   private Confirmation confirmation;
    private String userID="";
    private String amount="" ;
    public TransferFunction() {

        boolean loop= true;
        do{
            TransferMoneyUserID transferMoneyUserID = new TransferMoneyUserID("TransferMoneyUserID.png");
            transferMoneyUserID.setVisible(true);
            transferMoneyUserID.waiting();

            TransferMoneyAmount transferMoneyAmount = new TransferMoneyAmount("TransferMoneyAmount.png");
            transferMoneyAmount.setVisible(true);
            transferMoneyAmount.waiting();
            try{
                userID = transferMoneyUserID.getTransferMoneyUserID();
                amount = transferMoneyAmount.getTransferMoneyAmount();
            }
            catch(Exception ex){
            }
            transferMoneyUserID = null;
            transferMoneyAmount = null;

            try{
                Confirmation confirmation = new Confirmation("Confirmation.png",Integer.parseInt(userID),Double.parseDouble(amount));
                confirmation.setVisible(true);
                loop=false;
            }
            catch(Exception ex){}

        }while(loop);
    }
}
