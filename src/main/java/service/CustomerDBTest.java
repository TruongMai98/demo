package service;

import model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerDBTest implements CustomerDB{
    private static List<Customer> customers =new ArrayList<>();

    static {
        customers.add(new Customer(1, "Truong Mia", "HCM","truongmai@gai.com"));
        customers.add(new Customer(2, "hihi", "HCM","truongmai@gai.com"));
        customers.add(new Customer(3, "phu luon", "HCM","truongmai@gai.com"));
        customers.add(new Customer(4, "haha", "HCM","truongmai@gai.com"));
        customers.add(new Customer(5, "Truong Mia", "HCM","truongmai@gai.com"));
        customers.add(new Customer(6, "Truong Mia", "HCM","truongmai@gai.com"));
        customers.add(new Customer(7, "Truong Mia", "HCM","truongmai@gai.com"));
        customers.add(new Customer(1, "Truong Mia", "HCM","truongmai@gai.com"));
        customers.add(new Customer(2, "hihi", "HCM","truongmai@gai.com"));
        customers.add(new Customer(3, "phu luon", "HCM","truongmai@gai.com"));
        customers.add(new Customer(4, "haha", "HCM","truongmai@gai.com"));
        customers.add(new Customer(5, "Truong Mia", "HCM","truongmai@gai.com"));
        customers.add(new Customer(6, "Truong Mia", "HCM","truongmai@gai.com"));
        customers.add(new Customer(7, "Truong Mia", "HCM","truongmai@gai.com"));
        customers.add(new Customer(1, "Truong Mia", "HCM","truongmai@gai.com"));
        customers.add(new Customer(2, "hihi", "HCM","truongmai@gai.com"));
        customers.add(new Customer(3, "phu luon", "HCM","truongmai@gai.com"));
        customers.add(new Customer(4, "haha", "HCM","truongmai@gai.com"));
        customers.add(new Customer(5, "Truong Mia", "HCM","truongmai@gai.com"));
        customers.add(new Customer(6, "Truong Mia", "HCM","truongmai@gai.com"));
        customers.add(new Customer(7, "Truong Mia", "HCM","truongmai@gai.com"));
        customers.add(new Customer(1, "Truong Mia", "HCM","truongmai@gai.com"));
        customers.add(new Customer(2, "hihi", "HCM","truongmai@gai.com"));
        customers.add(new Customer(3, "phu luon", "HCM","truongmai@gai.com"));
        customers.add(new Customer(4, "haha", "HCM","truongmai@gai.com"));
        customers.add(new Customer(5, "Truong Mia", "HCM","truongmai@gai.com"));
        customers.add(new Customer(6, "Truong Mia", "HCM","truongmai@gai.com"));
        customers.add(new Customer(7, "Truong Mia", "HCM","truongmai@gai.com"));
    }


    @Override
    public void create(Customer customer) {
        customers.add(customer);
    }

    @Override
    public List<Customer> findAll() {
        return customers;
    }

    @Override
    public boolean update(int id, Customer customer) {
        Customer c = search(id);
        if (c != null) {
            c.setName(customer.getName());
            c.setAddress(customer.getAddress());
            c.setEmail(customer.getEmail());
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        Customer c = search(id);
        if (c != null) {
            customers.remove(c);
            return true;
        }
        return false;
    }

    @Override
    public Customer search(int id) {
        for (Customer c: customers) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    @Override
    public List<Customer> searchByName(String name) {
        List<Customer> newCustomer = new ArrayList<>();
        for (Customer c :customers) {
            if (c.getName().toLowerCase().contains(name.toLowerCase())) {
                newCustomer.add(c);
            }
        }
        return newCustomer;
    }

    @Override
    public List<Customer> sortByName() {
        return null;
    }
}
