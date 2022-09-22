package bankaccountapp;

public class Checking extends Account{
    //List properties specific to a Checking account
    private int debitCardNumber;
    private int debitCardPIN;

    //Constructor to initilised checking account properties
    public Checking(String name, String sSN, double initDeposit){
        super(name,sSN,initDeposit);//in order to call the parent class we need to use super() here
        accountNumber = "2" + accountNumber;
        setDebitCard();

    }
    //List any methods specific to the checking account



    public double getBaseRate() {
        return super.getBaseRate();
    }
    @Override
    public void setRate(){
       rate = getBaseRate() * 0.15;
    }
    private void setDebitCard(){
        debitCardNumber = (int)(Math.random() * Math.pow(10,12));
        debitCardPIN = (int)(Math.random() * Math.pow(10,4));
    }

    public void showInfo(){
        super.showInfo();
        System.out.println(
                "Your Checking Account Features" +
                "\n Debit Card Number: " + debitCardNumber +
                "\n Debit Card PIN: " + debitCardPIN
        );
    }
}
