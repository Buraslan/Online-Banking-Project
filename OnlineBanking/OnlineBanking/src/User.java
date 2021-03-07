import java.util.ArrayList;
import java.util.List;

public class User {

    private String customerName;
    private String customerSurname;
    private String customerNo;
    private String eMail;
    private String password;
    private String phoneNum;
    
    ArrayList<Account> bankAccount = new ArrayList<Account>();    
    ArrayList<CreditCard> bankCreditCard =new ArrayList<CreditCard>();
    


    public User(String customerName, String customerSurname, String customerNo, String eMail, String password,String phoneNum) {
        this.customerName = customerName;
        this.customerSurname = customerSurname;
        this.customerNo = customerNo;
        this.eMail = eMail;
        this.password = password;
        this.phoneNum = phoneNum;

    }

    Account account = new Account(00000, 0.0, "0000", "0000");
    CreditCard creditcard = new CreditCard(0.0, 00000, 0.0, 0.0);
    

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerSurname() {
        return customerSurname;
    }

    public void setCustomerSurname(String customerSurname) {
        this.customerSurname = customerSurname;
    }

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public List<Account> getBankAccount() {
        return bankAccount;
    }

    public ArrayList<CreditCard> getBankCreditCard() {
        return bankCreditCard;
    }

    public void setBankCreditCard(ArrayList<CreditCard> bankCreditCard) {
        this.bankCreditCard = bankCreditCard;
    }

    public CreditCard getCreditcard() {
        return creditcard;
    }

    public void setCreditcard(CreditCard creditcard) {
        this.creditcard = creditcard;
    }

    public void setBankAccount(List<Account> bankAccount) {
        this.bankAccount = (ArrayList<Account>) bankAccount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}

