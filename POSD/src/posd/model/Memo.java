
package posd.model;

import java.util.Date;


public class Memo {

    int id;
    int userId;
    Date date;
    double totalAmount;
    String invoiceNo;
    String name;

    public Memo() {
    }

    public Memo(int userId, Date date, double totalAmount, String invoiceNo) {
        this.userId = userId;
        this.date = date;
        this.totalAmount = totalAmount;
        this.invoiceNo = invoiceNo;
    }

    public Memo(int id, Date date, double totalAmount, String invoiceNo, double discountRate, String name) {
        this.id = id;
        this.date = date;
        this.totalAmount = totalAmount;
        this.invoiceNo = invoiceNo;       
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Memo{" + "id=" + id + ", userId=" + userId + ", date=" + date + ", totalAmount=" + totalAmount + ", invoiceNo=" + invoiceNo + ", name=" + name + '}';
    }
    
    

  
    
   

}
