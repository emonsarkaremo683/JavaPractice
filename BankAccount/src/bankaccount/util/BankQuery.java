
package bankaccount.util;


public class BankQuery {

    private int accNo;
    private double balance;
    private int deposit;
    private double withdraw;

    public BankQuery() {
    }

    public int getAccNo() {
        return accNo;
    }

    public void setAccNo(int accNo) {
        this.accNo = accNo;
    }

    public double getBalance() {

        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
        deposit();
    }

    public double getWithdraw() {
        return withdraw;
    }

    public void setWithdraw(double withdraw) {
        this.withdraw = withdraw;
        withdraw();
    }

    public double deposit() {
        balance += getDeposit();
        return balance;
    }

    public double withdraw() {
        if (balance >= getWithdraw()) {
            balance -= getWithdraw();
        }
        return balance;
    }

}
