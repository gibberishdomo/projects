package service;

import model.Customer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class CustomerService {
    public static ArrayList<Customer> customers = new ArrayList();

    public CustomerService() {

    }

    public void addCustomer(String email, String firstName, String lastName) {
        Customer customer = new Customer(firstName, lastName, email);
        customers.add(customer);


    }

    public List<Customer> getCustomersCollection(String Email) {
        List<Customer> customerList = new ArrayList();
        Iterator alpha = customers.iterator();

        while(alpha.hasNext()) {
            Customer customer = (Customer) alpha.next();
            if (customer.getEmail().equals(Email)){
                customerList.add(customer);
            }
        }

        return customerList;

    }

    public Customer getCustomer(String Email) {
        Iterator beta = customers.iterator();

        Customer customer;
        do {
            if (!beta.hasNext()) {
                return null;
            }

            customer = (Customer) beta.next();
        } while(!customer.getEmail().equals(Email));

        return customer;
        }

    public List<Customer> getAllCustomers() { return customers;}
}
