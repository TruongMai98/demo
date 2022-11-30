package controller;

import model.Customer;
import service.CustomerDB;
import service.CustomerDBTest;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/customers")
public class CustomerServlet extends HttpServlet {
    public static final int TOTAL_PER_PAGE = 5;
    private CustomerDB customerDB = new CustomerDBTest();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateCustomer(request, response);
                break;
            case "edit":
                showEditCustomer(request, response);
                break;
            case "delete":
                showDeleteCustomer(request, response);
                break;
            case "view":
                showViewCustomer(request, response);
                break;
            case "keyWord":
                showSearchByName(request, response);
                break;
            default:
                showListCustomer(request, response);
                break;
        }
    }

    private void showSearchByName(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerDB.search(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/search.jsp");

    }

    private void showViewCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = this.customerDB.search(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view.jsp");
        request.setAttribute("customer", customer);
        dispatcher.forward(request, response);
    }

    private void showDeleteCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       int id = Integer.parseInt(request.getParameter("id"));
       Customer customer = this.customerDB.search(id);
       RequestDispatcher dispatcher = request.getRequestDispatcher("/delete.jsp");
       request.setAttribute("customer", customer);
       dispatcher.forward(request, response);

    }

    private void showEditCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = this.customerDB.search(id);
        request.setAttribute("customer", customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void showCreateCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showListCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("search");
        List<Customer> customerList;
        if (search == null) {
            customerList = this.customerDB.findAll();

        } else {
             customerList = this.customerDB.searchByName(search);

        }

        String pageIds = request.getParameter("page");
        List<Customer> customerList1 = getCustomerPagination(customerList, pageIds);

        request.setAttribute("customers", customerList1);
        request.setAttribute("totalPage", customerList.size() / TOTAL_PER_PAGE + 1);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/list.jsp");
        dispatcher.forward(request, response);

    }

    private static List<Customer> getCustomerPagination(List<Customer> customerList, String pageIds) {
        int pageId;
        if (pageIds == null) {
            pageId = 1;
        } else {
            pageId = Integer.parseInt(pageIds);
        }

        List<Customer> customerList1 = new ArrayList<>();

        for (int i = ((pageId - 1) * TOTAL_PER_PAGE); (i < pageId * TOTAL_PER_PAGE) && (i < customerList.size()); i++) {
            customerList1.add(customerList.get(i));
        }
        return customerList1;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createCustomer(request, response);
                break;
            case "edit":
                editCustomer(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
                break;

        }
    }

    private void searchById(HttpServletRequest request, HttpServletResponse response) {

    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        customerDB.delete(id);
        response.sendRedirect("/customers");

    }

    private void editCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        Customer customerUpdate = new Customer(id, name, address, email);
        customerDB.update(id, customerUpdate);
        response.sendRedirect("/customers");


    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = (int) (Math.random() * 100);
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        Customer customer = new Customer(id, name, address, email);
        this.customerDB.create(customer);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/create.jsp");
        dispatcher.forward(request, response);
    }
}
