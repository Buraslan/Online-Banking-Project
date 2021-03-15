import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class MainPanel {


    private static Scanner s = new Scanner(System.in);


    private static ArrayList<User> users = new ArrayList<User>();


    public static void main(String[]args) {
       



        users.add(new User("name", "surname","465465", "name@gmail.com","1234", "54229000000"));

        users.add(new User("name2", "surname2", "45566", "name2@gmail.com", "2345","5072030000"));

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
                System.out.println("Giris Basarisiz");
            
        
        System.out.println("Welcome, Please Enter The Account Number and Password ");
        System.out.print("Account Number: ");
        String acc2 = s.nextLine();
        System.out.print("Password: ");
        String pass2 = s.nextLine();
        boolean flag2 = false;

        for(int j=0;j<users.size();j++){
            if(users.get(j).account.getAccountNumber().equals(acc2)){

                if(users.get(j).getPassword().equals(pass2)){
                    flag2=true;

                    run(users.get(j));
                }
            }

            
        }
            if(!flag2)
                System.out.println("Giris Basarisiz");
        
     
        
        
    }

    public static void run(User user) {

        System.out.println("Welcome "+ user.getCustomerName()+ ", please choose a operation which you want; ");

        System.out.println("1. Show Balance\n"
                + "2. Debt Payment\n"
                + "3. Credit Card Limit\n"
                + "4. Eft Transactions\n"
                + "5. Total Credit Card Debt\n"
                + "6. Get a New Credit Card\n"
                + "7. Create a New Account\n"
                + "8. Exit ");



        boolean dongu = false;
        while (!dongu) {


            System.out.print("\nYour Choice: ");

            int choice = s.nextInt();

            s.nextLine();


            switch (choice) {
                case 1:
                    System.out.print("\nBalance=" +user.account.getBalance());
                    break;

                case 2:

                    System.out.print("\nTotal Creditcard debt=" +user.creditcard.getTotalDebt());
                    System.out.print("\nMinimum Creditcard debt=" +user.creditcard.getMinDebt());
                    System.out.print("\nPlease enter the amount that you want to withdraw: ");
                    Double amount=s.nextDouble();
                    //CreditCard.withdrawDebt(amount,user.account.getBalance());
                    user.creditcard.withdrawDebt(amount,user.account.getBalance());
                    break;
                case 3:

                    System.out.print("\nCredit Card Limit:" +user.creditcard.getCreditCardLimit());

                    break;


                case 4:
                    System.out.println("Please write receiver user's IBAN number info: ");
                    String iban = s.nextLine(); 
                    
                    boolean flag = false;
                    for(int i=0;i<users.size();i++){
                        
                        if(users.get(i).account.getIbanNoInfo().equals(iban)){
                            
                            user.account.eftTransactions(users.get(i));
                            flag =true;
                        }
                      
                    }
                    if(!flag)
                      System.out.println("IBAN number that you entered is incorrect. Please write IBAN number again.");
                      
                    break;



                case 5:

                    System.out.print("\nTotal Credit Card Debt: " +user.creditcard.getTotalDebt());

                    break;

                case 6:

                    for(int j=0;j<users.size();j++){
                        if(users.get(j).bankCreditCard.size()<2){

                            users.get(j).bankCreditCard.add(new CreditCard(0.0,0000, 0.0, 0.0));

                            System.out.print("\nNew creditcard is created....");
                            
                            Random rand = new Random();
                            
                            int n = 100+rand.nextInt(100);

                            
                            users.get(j).creditcard.setCreditCardLimit(3000);
                            users.get(j).creditcard.setCreditCardNumber(n);


                            break;

                        }
                        else
                            System.out.print("\nLimit of creditcard size must be just 2....");
                        break;
                    }
                    break;



                case 7:
                    for(int j=0;j<users.size();j++){
                        if(users.get(j).bankAccount.size()<5){

                            users.get(j).bankAccount.add(new Account(00000, 0.0, "1111111", "1111111"));

                            System.out.print("\nNew account is created....");


                            System.out.print("\nPlease enter your balance: ");
                            double newBalance = s.nextDouble();


                            users.get(j).account.setBalance(newBalance);
                            users.get(j).account.setIbanNoInfo("TR 9000 3456");
                            users.get(j).account.setAccountNumber("345678");
                            break;

                        }
                        else
                            System.out.print("\nLimit of account size must be just 5....");
                        break;
                    }
                    break;


                case 8:

                    System.out.print("\nLogout...");
                    dongu = true;

                    break;




            }


        }



    }
}