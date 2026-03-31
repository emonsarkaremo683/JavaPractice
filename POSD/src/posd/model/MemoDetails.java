
package posd.model;


public class MemoDetails {
    
    int id;
    int salesId;
    int productId;
    double quantity;
    double unitPrice;
    double totalAmount, discountRate, discountPrice, actualPrice;
    
    String productName;

    public MemoDetails() {
    }

    public MemoDetails(int salesId, int productId, double quantity, double unitPrice, double totalAmount, double discountRate, double discountPrice, double actualPrice) {
        this.salesId = salesId;
        this.productId = productId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totalAmount = totalAmount;
        this.discountRate = discountRate;
        this.discountPrice = discountPrice;
        this.actualPrice = actualPrice;
    }

    public MemoDetails(int id, int salesId, double quantity, double unitPrice, double totalAmount, double discountRate, double discountPrice, double actualPrice, String productName) {
        this.id = id;
        this.salesId = salesId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totalAmount = totalAmount;
        this.discountRate = discountRate;
        this.discountPrice = discountPrice;
        this.actualPrice = actualPrice;
        this.productName = productName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSalesId() {
        return salesId;
    }

    public void setSalesId(int salesId) {
        this.salesId = salesId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(double discountPrice) {
        this.discountPrice = discountPrice;
    }

    public double getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(double actualPrice) {
        this.actualPrice = actualPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "MemoDetails{" + "id=" + id + ", salesId=" + salesId + ", productId=" + productId + ", quantity=" + quantity + ", unitPrice=" + unitPrice + ", totalAmount=" + totalAmount + ", discountRate=" + discountRate + ", discountPrice=" + discountPrice + ", actualPrice=" + actualPrice + ", productName=" + productName + '}';
    }
}
