import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class MainPanel {
    
    private static Scanner s = new Scanner(System.in);


    private static ArrayList<User> users = new ArrayList<User>();


    public static void main(String[]args) {
       

        users.add(new User("Meltem", "Baykal","170315068", "meltem@gmail.com","1234", "54229000000"));

        users.add(new User("Yasin Anil", "Bostanci", "170315053", "yasin@gmail.com", "2345","5072030000"));

        users.get(0).account.setBalance(100000);
        users.get(0).account.setIbanNoInfo("TR 9000 1234");
        users.get(0).account.setAccountNumber("123456");
        users.get(1).account.setBalance(200000);
        users.get(1).account.setIbanNoInfo("TR 9000 2345");
        users.get(1).account.setAccountNumber("234567");

        users.get(0).creditcard.setCreditCardLimit(20000);
        users.get(0).creditcard.setCreditCardNumber(12345678);
        users.get(0).creditcard.setTotalDebt(500);
        users.get(0).creditcard.setMinDebt(50);
        users.get(1).creditcard.setCreditCardLimit(25000);
        users.get(1).creditcard.setCreditCardNumber(23456789);
        users.get(1).creditcard.setTotalDebt(1000);
        users.get(1).creditcard.setMinDebt(500);
        

        System.out.println("Welcome, Please Enter The Account Number and Password ");
        System.out.print("Account Number: ");
        String acc = s.nextLine();
        System.out.print("Password: ");
        String pass = s.nextLine();
        boolean flag1 = false;

        for(int j=0;j<users.size();j++){
            if(users.get(j).account.getAccountNumber().equals(acc)){

                if(users.get(j).getPassword().equals(pass)){
                    flag1=true;

                    run(users.get(j));
                }
            }            
        }
            if(!flag1)
                System.out.println("Login failed..");
        
        
        System.out.println("Welcome, Please Enter The Account Number and Password ");
        System.out.print("Account Number: ");
        String acc2 = s.nextLine();
        System.out.print("Password: ");
        String pass2 = s.nextLine();
        boolean flag2 = false;


        for(int j=0;j<users.size();j++){
            if(users.get(j).account.getAccountNumber().equals(acc2)){

                if(users.get(j).getPassword().equals(pass2)){

                    flag2 = true;
                    run(users.get(j));
                }
            }

            if(!flag2) 
                System.out.println("Login failed..");
        }
    
        
    }

    public static void run(User user) {

        System.out.println("Welcome "+ user.getCustomerName()+ ", please choose a operation which you want; ");

        System.out.println("1. Show Balance\n"
                + "2. Debt Payment\n"
                + "3. Eft Transactions\n"
                + "4. Credit Card Limit\n"
                + "5. Total Credit Card Debt\n"
                + "6. Get a New Credit Card\n"
                + "7. Create a New Account\n"
                + "8. Exit ");



        boolean loop = false;
        
        while (!loop) {
             System.out.print("---------------------------------------");
            System.out.print("\nYour Choice: ");

            int choice = s.nextInt();
            
            s.nextLine();


            switch (choice) {
                case 1:
                    
                    System.out.println("\nBalance=" +user.account.getBalance());
                    
                    break;

                case 2:

                    System.out.print("\nTotal Creditcard debt=" +user.creditcard.getTotalDebt());
                    System.out.print("\nMinimum Creditcard debt=" +user.creditcard.getMinDebt());
                    System.out.print("\nPlease enter the amount that you want to withdraw: ");
                    Double amount=s.nextDouble();
                    boolean flag3 = false;                  
                    
               
                   for(int i=0;i<users.size();i++){
                   
                    if (users.get(i).creditcard.getMinDebt()>(amount)) {                       
                           
                        flag3=true;                     
                        System.out.println("You have to withdraw minimum debt amount at least!!");
                        break;
                    }
                    
                     else if(users.get(i).creditcard.getMinDebt()==(amount)|| users.get(i).creditcard.getTotalDebt()>(amount)){
                        users.get(i).account.credicartbalance(amount);
                        users.get(i).creditcard.totaldebtbalance(amount);
                        flag3=true;                         
                        break;
                    }
                        
                    else  if(users.get(i).creditcard.getTotalDebt()==(amount)|| users.get(i).creditcard.getMinDebt()<(amount)){
                        users.get(i).account.credicartbalance(amount);
                        users.get(i).creditcard.totaldebtbalance(amount);
                        flag3=true;                       
                        break;
                    }
                     
                    if(!flag3)
                        System.out.println("The amount that you gave is higher than your total debt!!");    
                    break;
                    
                                            
                  }      
                    break;
                    
                    
                case 3:
                    
                    System.out.println("Please write receiver user's IBAN number info: ");
                    String iban = s.nextLine(); 
                    boolean flag4 = false;
                    
                    
                    for(int i=0;i<users.size();i++){
                        
                        if(users.get(i).account.getIbanNoInfo().equals(iban)){
                            
                            flag4 = true;
                            user.account.eftTransactions(users.get(i));
                            break;
                        }
                        else if(flag4)
                             System.out.println("IBAN number that you entered is incorrect. Please write IBAN number again.");                        
                    }
                      
                    break;


                case 4:
                    
                    System.out.println("\nCredit Card Limit:" +user.creditcard.getCreditCardLimit());
                    
                    break;



                case 5:

                    System.out.println("\nTotal Credit Card Debt: " +user.creditcard.getTotalDebt());

                    break;

                case 6:
                    
                    boolean flag5 = false;
                    
                    for(int j=0;j<users.size();j++){
                        flag5 = true;
                        
                        if(users.get(j).bankCreditCard.size()<2){

                            users.get(j).bankCreditCard.add(new CreditCard(0.0,0000, 0.0, 0.0));

                            System.out.println("\nNew creditcard is created....");
                            
                            Random rand = new Random();
                            
                            int n = 100+rand.nextInt(100);
                            
                            users.get(j).creditcard.setCreditCardLimit(3000);
                            users.get(j).creditcard.setCreditCardNumber(n);
                            
                            break;

                        }
                        
                        
                        if(!flag5)                            
                          System.out.println("\nLimit of creditcard size must be just 2....");                        
                        break;
                    }
                    break;



                case 7:
                    for(int j=0;j<users.size();j++){
                        
                        if(users.get(j).bankAccount.size()<5){

                            users.get(j).bankAccount.add(new Account(00000, 0.0, "1111111", "1111111"));

                            System.out.println("\nNew account is created....");


                            System.out.print("\nPlease enter your balance: ");
                            double newBalance = s.nextDouble();


                            users.get(j).account.setBalance(newBalance);
                            users.get(j).account.setIbanNoInfo("TR 9000 3456");
                            users.get(j).account.setAccountNumber("345678");
                            break;

                        }
                        else
                            System.out.println("\nLimit of account size must be just 5....");
                        break;
                    }
                    break;


                case 8:

                    System.out.println("\nLogout...");
                    loop = true;

                    break;
                    
            }
            
        }
    }
}