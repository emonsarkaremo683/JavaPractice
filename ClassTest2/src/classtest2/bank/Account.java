
package classtest2.bank;


public class Account {
    private String accNo;
    private String accHolderName;
    private double balance;
    private double deposit;
    

    public Account() {
    }

    public Account(String accNo, String accHolderName, double balance) {
        this.accNo = accNo;
        this.accHolderName = accHolderName;
        this.balance = balance;
    }

    public Account(String accNo, double balance) {
        this.accNo = accNo;
        this.balance = balance;
    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public String getAccHolderName() {
        return accHolderName;
    }

    public void setAccHolderName(String accHolderName) {
        this.accHolderName = accHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance += balance;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
        setBalance(deposit);
    }
    
    
    public void displayAccountInfo(){
        System.out.println("Name: " + accHolderName + "\n" +
                "Account Number" + accNo);
    
    }
    
    
}
