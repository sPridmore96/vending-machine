

public class Products {

    private final String name;
    private final String type;
    private final String brand;
    private int stockAmount;
    private boolean isInStock;



    public Products(String name, String type, String brand) {
        this.name = name;
        this.type = type;
        this.brand = brand;
        this.stockAmount = (int) (Math.random() * 5 +1);
        this.isInStock = this.stockAmount > 0;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public String getType() {
        return type;
    }

    public int getStockAmount() {
        return stockAmount;
    }


    public void setStockAmount(int stockAmount) {
        this.stockAmount = stockAmount;
    }

    public boolean isInStock() {
        return isInStock;
    }

    public void setInStock(boolean inStock) {
        isInStock = inStock;
    }
}
