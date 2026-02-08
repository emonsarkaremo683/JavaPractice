package bankaccount;

import bankaccount.util.BankQuery;

public class BankAccount {

    public static void main(String[] args) {
        BankQuery bq = new BankQuery();

        bq.setDeposit(5000);
        System.out.println(bq.getBalance());

        bq.setWithdraw(1000);
        System.out.println(bq.getBalance());
        
        bq.setWithdraw(1000);
        System.out.println(bq.getBalance());
    }

}
