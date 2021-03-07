public class CreditCard {

    private double creditCardLimit;
    private int creditCardNumber;
    private double totalDebt;
    private double minDebt;
    

    public CreditCard(double creditCardLimit, int creditCardNumber, double totalDebt, double minDebt) {
        this.creditCardLimit = creditCardLimit;
        this.creditCardNumber = creditCardNumber;
        this.totalDebt = totalDebt;
        this.minDebt = minDebt;
    }
    
       

    public double getCreditCardLimit() {
        return creditCardLimit;
    }

    public void setCreditCardLimit(double creditCardLimit) {
        this.creditCardLimit = creditCardLimit;
    }

    public int getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(int creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public double getTotalDebt() {
        return totalDebt;
    }

    public void setTotalDebt(double totalDebt) {
        this.totalDebt = totalDebt;
    }

    public double getMinDebt() {
        return minDebt;
    }

    public void setMinDebt(double minDebt) {
        this.minDebt = minDebt;
    }


    public void totaldebtbalance(Double amount){
               
          totalDebt-=amount;  
          System.out.println("Total creditcard debt =" +totalDebt);   
           
        minDebt-=amount;
       
        if(minDebt>0)  
          System.out.println("Minumum creditcard debt =" +minDebt);
        else
            minDebt=0;
            System.out.println("Minumum creditcard debt ="+minDebt);
    }
            
}
