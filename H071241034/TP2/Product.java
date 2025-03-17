public class Product {
    
    private String id;
    private String name;
    private int stock;
    private double price;

    public Product(String id, String name, int stock, double price) {
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

  
    public int getStock() {
        return stock;
    }

    
    public double getPrice() {
        return price;
    }

 
    public boolean isAvailable() {
        return stock > 0;
    }

    public void displayProductInfo() {
        System.out.println("Product ID: " + id);
        System.out.println("Product Name: " + name);
        System.out.println("Stock: " + stock);
        System.out.println("Price: $" + price);
        System.out.println("Available: " + (isAvailable() ? "Yes" : "No"));
    }

        public static void main(String[] args) {
        Product product = new Product("P001", "Laptop", 10, 1200.00);
        product.displayProductInfo();
    }
}