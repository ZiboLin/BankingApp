package bankaccountapp;

import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {
    public static void main(String[] args){
//        Checking chkacc1 = new Checking("Tom Wilson","123456789",1500);
//
//        Savings savac1 = new Savings("Zibo Lin","987654321",888888888);
//        savac1.compound();
//        savac1.showInfo();
//        System.out.println("\n\n");
//        chkacc1.showInfo();

            List<Account> accounts = new LinkedList<Account>();
//        //Read a CSV file then create new accounts based on that data
          List<String[]> newAccountHolders = utilities.CSV.read("src/bankaccountapp/file.csv");
          for(String[] accountHolder : newAccountHolders){
              String name = accountHolder[0];
              String sSN = accountHolder[1];
              String accountType = accountHolder[2];
              double initDeposit = Double.parseDouble(accountHolder[3]);
              //System.out.println(name + " " + sSN + " " + accountType + " $" + initDeposit);
              if(accountType.equals("Savings")){
                  accounts.add(new Savings(name, sSN, initDeposit));
              }else if(accountType.equals("Checking")){
                  accounts.add(new Checking(name, sSN, initDeposit));
              }else{
                  System.out.println("ERROR READING ACCOUNT TYPE");
              }
          }

          for(Account acc: accounts){
              System.out.println("\n**********************************");
              acc.showInfo();

          }


    }

}
