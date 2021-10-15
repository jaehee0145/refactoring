package chap08;

import java.util.Collection;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Iterator;

public class ChangeValueToReference {
    class Order {
        private Customer customer;

        public Order (String customerName) {
            this.customer = Customer.getNamed(customerName);
        }

        public String getCustomerName() {
            return customer.getName();
        }

        public void setCustomer(String customerName) {
            this.customer = Customer.getNamed(customerName);
        }
    }

    static class Customer {

        private static Dictionary instances = new Hashtable();

        static void loadCustomers() {
            new Customer("A").store();
            new Customer("B").store();
        }

        private void store() {
            instances.put(this.getName(), this);
        }

        private String name;

        // 생성자를 팩토리 메서드로 전환
        private Customer(String name) {
            this.name = name;
        }
        public static Customer getNamed(String name) {
            return (Customer) instances.get(name);
        }

        public String getName() {
            return name;
        }
    }

    private static int numberOfOrdersFor(Collection orders, String customer) {
        int result = 0;
        Iterator iter = orders.iterator();
        while (iter.hasNext()) {
            Order each = (Order) iter.next();
            if (each.getCustomerName().equals(customer)) result++;
        }
        return result;
    }
}
