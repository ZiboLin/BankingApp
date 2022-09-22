package bankaccountapp;

//if we don't want to create object from account, then we can make it Abstract
// but we can create object inherited from "Account" abstract class
public abstract class Account implements IBaseRate{
    //List common properties for savings and checking accounts
    private String name;
    private String sSN;
    private double balance;

    private static int index = 10000;

    protected String accountNumber;
    protected double rate;

    //constructor to set base properties and initalised the account
    public Account(String name, String sSN, double initDeposit){
        this.name = name;
        this.sSN = sSN;
        this.balance = initDeposit;

//        System.out.println("NAME: " + name + " SSN: " + sSN + " BALANCE: $" + initDeposit);

        //Set account number
        index++;
        this.accountNumber = setAccountNumber();

        setRate();
    }
    public abstract void setRate();
    private String setAccountNumber() {
        String lastTwoOfSSN = sSN.substring(sSN.length()-2, sSN.length());
        int uniqueID = index;
        int randomNum = (int)(Math.random() * Math.pow(10,3));
        return lastTwoOfSSN + uniqueID + randomNum;
    }

    //List common methods
    public void showInfo(){
        System.out.println(
                "NAME: " + name +
                        "\nACCOUNT NUMBER: " + accountNumber +
                        "\nBALANCE: " + balance +
                        "\nRATE: " + rate + "%"
        );
    }

    public void compound(){
        double accruedInterest = balance * (rate/100);
        System.out.println("Accrued Interest" + accruedInterest);
        balance+=accruedInterest;
        printBalance();
    }
    public void deposit(double amount){
        balance+=amount;
        System.out.println("Depositing $" + amount);
        printBalance();
    }
    public void withdraw(double amount){
        balance-=amount;
        System.out.println("Withdrawing $" + amount);
        printBalance();
    }
    public void transfer(String toWhere, double amount){
        balance-=amount;
        System.out.println("Transfering $" + amount + " to " + toWhere);
        printBalance();
    }
    public void printBalance(){
        System.out.println("Your balance is now: $" + balance);
    }
}
