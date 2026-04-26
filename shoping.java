import java.util.*;

interface ShoppingOperations {
    void addProduct(Product p);
    void addCustomer(Customer c);
    void placeOrder(Order o);
    void showProducts();
    void showCustomers();
    void showOrders();
}
class Product {
    private int id;
    private String name;
    private double price;
    Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
 double getPrice() {
        return price;
    }
    void display() {
        System.out.println(id + " " + name + " Rs." + price);
    }
}
class Customer {
    private int id;
    private String name;
    private String mobile;
    Customer(int id, String name, String mobile) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
    }
    void display() {
        System.out.println(id + " " + name + " " + mobile);
    }
}
class Order {
    private Product product;
    private int quantity;
    Order(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
    double getTotal() {
        return product.getPrice() * quantity;
    }
    void display() {
        product.display();
        System.out.println("Qty: " + quantity + " Total: Rs." + getTotal());
    }
}
class ShoppingSystem implements ShoppingOperations {
    private List<Product> products = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();

    public void addProduct(Product p) {
        products.add(p);
    }
    public void addCustomer(Customer c) {
        customers.add(c);
    }
    public void placeOrder(Order o) {
        orders.add(o);
    }
    public void showProducts() {
        for (Product p : products)
            p.display();
    }
    public void showCustomers() {
        for (Customer c : customers)
            c.display();
    }
    public void showOrders() {
        for (Order o : orders)
            o.display();
    }
}
public class Main {
    public static void main(String[] args) {
        ShoppingSystem shop = new ShoppingSystem();
        Product p1 = new Product(1, "Laptop", 100000);
        Customer c1 = new Customer(101, "sakthi", "8015880158");
        Order o1 = new Order(p1, 2);

        shop.addProduct(p1);
        shop.addCustomer(c1);
        shop.placeOrder(o1);

        shop.showProducts();
        shop.showCustomers();
        shop.showOrders();
    }
}
