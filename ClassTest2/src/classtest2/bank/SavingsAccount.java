
package classtest2.bank;


public class SavingsAccount extends Account{
    private double interestRate;

    public SavingsAccount() {
    }

    public SavingsAccount(double interestRate) {
        this.interestRate = interestRate;
    }

    public SavingsAccount(double interestRate, String accNo, String accHolderName, double balance) {
        super(accNo, accHolderName, balance);
        this.interestRate = interestRate;
    }

    public SavingsAccount(double interestRate, String accNo, double balance) {
        super(accNo, balance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public void displayAccountInfo() {
        
        System.out.println("Interest Balance: "+ (super.getBalance() * (interestRate / 100)) +"\nNew Balance: " + (super.getBalance() + (super.getBalance() * (interestRate / 100))));
    }
    
    
    
    
}
