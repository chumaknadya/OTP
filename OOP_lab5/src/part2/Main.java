package part2;

public class Main {
    public static void main(String[] args) {
        InternetShop internetShop = new InternetShop();
        Colleague store = new Storage(internetShop);
        Colleague customer = new Customer(internetShop);
        internetShop.Customer = customer;
        internetShop.Storage = store;
        customer.send("6 mobile phones");

    }
}
