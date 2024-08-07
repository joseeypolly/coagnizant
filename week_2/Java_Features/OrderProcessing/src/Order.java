import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderId;
    private String customerName;
    private double orderAmount;
    private String status;

    public Order(int orderId, String customerName, double orderAmount, String status) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.orderAmount = orderAmount;
        this.status = status;
    }
    @FunctionalInterface
    public interface OrderFilter {
        boolean filter(Order order);
    }

    @FunctionalInterface
    public interface OrderProcessor {
        void process(Order order);
    }

    // Getters and Setters

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customerName='" + customerName + '\'' +
                ", orderAmount=" + orderAmount +
                ", status='" + status + '\'' +
                '}';
    }
    
    OrderFilter highValueOrderFilter = order -> order.getOrderAmount() > 100;

    OrderProcessor statusUpdater = order -> order.setStatus("PROCESSED");

    public static void filterOrders(List<Order> orders, OrderFilter filter) {
        for (Order order : orders) {
            if (filter.filter(order)) {
                System.out.println("Filtered Order: " + order);
            }
        }
    }
    
    public static void processOrders(List<Order> orders, OrderProcessor processor) {
        for (Order order : orders) {
            processor.process(order);
            System.out.println("Processed Order: " + order);
        }
    }

    public static void main(String[] args) {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(1, "Afsha", 150.0, "NEW"));
        orders.add(new Order(2, "Samba", 200.0, "NEW"));
        orders.add(new Order(3, "Teja", 50.0, "NEW"));
        orders.add(new Order(4, "Swathi", 300.0, "NEW"));

        // Filter orders with amount > 100
        OrderFilter highValueOrderFilter = order -> order.getOrderAmount() > 100;
        System.out.println("Filtering orders with amount > 100:");
        filterOrders(orders, highValueOrderFilter);

        // Process all orders
        OrderProcessor statusUpdater = order -> order.setStatus("PROCESSED");
        System.out.println("Processing all orders:");
        processOrders(orders, statusUpdater);
    }


}
