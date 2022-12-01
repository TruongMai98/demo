package service;

import model.Customer;

import java.util.List;

public interface CustomerDB {
    void create(Customer customer);

    List<Customer> findAll();

    boolean update(int id, Customer customer);

    boolean delete(int id);

    Customer search(int id);

    List<Customer> searchByName(String name);
    List<Customer> sortByName();
}
