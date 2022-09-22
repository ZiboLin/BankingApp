package bankaccountapp;

public class Savings extends Account{

    //List properties specific to the savings account
    private int safetyDepositBoxID;
    private int safetyDepositBoxKey;


    public Savings(String name, String sSN, double initDeposit){
        super(name,sSN,initDeposit);
        accountNumber = "1" + accountNumber;
        setSafetyDepositBox();
    }
    //List any methods
    @Override
    public void setRate(){
        rate = getBaseRate() - 0.25;
    }
    private void setSafetyDepositBox(){
        safetyDepositBoxID = (int)( Math.random() * Math.pow(10,3));
        safetyDepositBoxKey = (int)( Math.random() * Math.pow(10,4));
    }
    public void showInfo(){
        super.showInfo();
        System.out.println(
                "Your Saving Account Features" +
                "\n Safety Deposit Box ID: " + safetyDepositBoxID +
                "\n Safety Deposit Box Key: " + safetyDepositBoxKey
                );
    }


}
