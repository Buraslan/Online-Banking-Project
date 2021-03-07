import java.util.Scanner;

public class Account {

    private double balance;
    private double minimumBalanceLimit;
    private String accountNumber;
    private String ibanNoInfo;

    Scanner scan = new Scanner(System.in);




    public Account(double balance, double minimumBalanceLimit, String accountNumber, String ibanNoInfo) {
        this.balance = balance;
        this.minimumBalanceLimit = minimumBalanceLimit;
        this.accountNumber = accountNumber;
        this.ibanNoInfo = ibanNoInfo;
    }

   
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinimumBalanceLimit() {
        return minimumBalanceLimit;
    }

    public void setMinimumBalanceLimit(double minimumBalanceLimit) {
        this.minimumBalanceLimit = minimumBalanceLimit;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getIbanNoInfo() {
        return ibanNoInfo;
    }

    public void setIbanNoInfo(String ibanNoInfo) {
        this.ibanNoInfo = ibanNoInfo;
    }

    public void eftTransactions(User user) {

        System.out.println("Write the amount you want to send for eft transaction:");
        
        double eft = scan.nextDouble();
        
        if(balanceCheck(eft)){
        
        balance=balance - eft;
        
        user.account.balance+=eft;
        
        System.out.println("Your eft transaction has been completed..\n Your balance: " + getBalance());
        
        }
        else 
            System.out.println("There is no enough balance. Your balance: " + getBalance());
        
        }
    
    
    public boolean balanceCheck(double givenAmount) {

        if (getBalance() >= givenAmount)            
            return true;
        
        else
            return false;        
    }  
      
   public void credicartbalance(Double amount){
       
       balance=balance-amount;
       System.out.println("Your new balance: " + balance);
       System.out.println("--------------------------------------");
       
       
   }


    }