
package classtest2;

import classtest2.bank.CurrentAccount;
import classtest2.bank.SavingsAccount;


public class ClassTest2 {

    
    public static void main(String[] args) {
        
        
        SavingsAccount sa = new SavingsAccount();
       
        sa.setDeposit(50000);
        sa.setInterestRate(10);
        System.out.println("After Deposit: " + sa.getBalance());
        sa.displayAccountInfo();
        
        CurrentAccount ca = new CurrentAccount();
        ca.setBalance(50000);
        ca.setOverdraftLimit(20000);
        
        ca.displayAccountInfo();
                
    }
    
}
