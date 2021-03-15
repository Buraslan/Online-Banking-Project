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

    public void withdrawDebt (double givenAmount,double balance) {
        if ( givenAmount < getMinDebt()) {
            System.out.println("You have to withdraw minimum debt amount at least!!");
        }
        else if (givenAmount == getMinDebt() || givenAmount < getTotalDebt()) {
            balance -= givenAmount;
            System.out.println("Minimum debt is withdrawn. Your new balance: " + balance);
            minDebt -= givenAmount;
            totalDebt -= givenAmount;
        }
        else if (givenAmount > getMinDebt() && givenAmount == getTotalDebt()) {
            balance -= givenAmount;
            System.out.println("Total debt is withdrawn. Your new balance: " + balance);
            minDebt -= givenAmount;
            totalDebt -= givenAmount;
        }
        else {
            System.out.println("The amount that you gave is higher than your total debt!!");
        }
    }
}