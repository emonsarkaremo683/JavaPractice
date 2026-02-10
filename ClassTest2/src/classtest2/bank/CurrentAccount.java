
package classtest2.bank;


public class CurrentAccount extends Account{
    
    private int overdraftLimit;
    

    public CurrentAccount() {
    }

    public CurrentAccount(int overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    public CurrentAccount(int overdraftLimit, String accNo, String accHolderName, double balance) {
        super(accNo, accHolderName, balance);
        this.overdraftLimit = overdraftLimit;
    }

    public CurrentAccount(int overdraftLimit, String accNo, double balance) {
        super(accNo, balance);
        this.overdraftLimit = overdraftLimit;
    }

    public int getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(int overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    
    
    

    @Override
    public void displayAccountInfo() {
        
        if(super.getBalance() >= overdraftLimit){
            System.out.println("Successfully Withdrawn:" + overdraftLimit);
            System.out.println("Remaining Balance:" + (super.getBalance() - overdraftLimit));
        } else{
            System.out.println("Insufficient Balance");
        }
        
    }
    
    
    
}
