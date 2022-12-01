package service;

import model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CustomerDBReal implements CustomerDB{
    private static final String URL = "jdbc:mysql://localhost:3306/customer";
    private static final String USER_NAME = "root";
    private static final String PASS = "admin";

    private static final String SELECT_ALL_CUSTOMER = "select * from customer";
    private static final String SEARCH_BY_NAME_CUSTOMER = "select * from customer where name like ? '%'";
    private static final String SORT_BY_NAME = "select * from customer order by name";
    private static final String CREATE_CUSTOMER = "insert into customer(name, email, address) values (?, ?, ?)";
    private static final String UPDATE_CUSTOMER = "update customer set name = ?,email= ?, address = ? where id = ?";
    private static final String SEARCH_BY_ID = "select * from customer where id = ?";
    private static final String DELETE_CUSTOMER = "delete from customer where id = ?;";

    public CustomerDBReal() {
    }
    Connection connection;
    protected Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL,USER_NAME,PASS);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    @Override
    public void create(Customer customer) {
        try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(CREATE_CUSTOMER)){
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getEmail());
            preparedStatement.setString(3, customer.getAddress());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> list = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                Customer customer = new Customer(id, name, email, address);
                list.add(customer);
            }
        } catch (SQLException e) {
            throw  new RuntimeException(e);
        }
        return list;
    }

    @Override
    public boolean update(int id, Customer customer) {
//        Customer c = search(id);
//        if (c != null) {
            try (Connection connection = getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER)) {
                preparedStatement.setString(1, customer.getName());
                preparedStatement.setString(2, customer.getEmail());
                preparedStatement.setString(3, customer.getAddress());
                preparedStatement.setInt(4, id);
                preparedStatement.executeUpdate();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
//        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CUSTOMER)){
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Customer search(int id) {
        Customer customer = new Customer();
        try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BY_ID)){
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id1 = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                customer = new Customer(id1, name, email, address);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public List<Customer> searchByName(String name) {
        List<Customer> newCustomer = new ArrayList<>();
        try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BY_NAME_CUSTOMER)) {
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id1 = resultSet.getInt("id");
                String name1 = resultSet.getString("name");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                Customer customer = new Customer(id1, name1, email, address);
                newCustomer.add(customer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newCustomer;
    }

    @Override
    public List<Customer> sortByName() {
        List<Customer> newCustomer = new ArrayList<>();
        try (Connection connection1 = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SORT_BY_NAME)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name1 = resultSet.getString("name");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                Customer customer = new Customer(id, name1, email, address);
                newCustomer.add(customer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newCustomer;
    }
}
