
package bankaccount.util;


public class BkashLimited {
    
    private String accNo;
    private BankQuery bq;
    private String priyoNumber;

    public String getPriyoNumber() {
        return priyoNumber;
    }

    public void setPriyoNumber(String priyoNumber) {
        this.priyoNumber = priyoNumber;
    }
    
    
    

    public BkashLimited() {
    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public double sendMoney(String number, double bal){
        double result;
        if(bq.getBalance() >= bal){
            if(getPriyoNumber().equals(number)){
                if(bal > 25000 ){
                    result = bal + 5;
                }else if(bal > 50000){
                    result = bal + 10;
                }
            }
        
        }
        
        
    
    }
    
}
