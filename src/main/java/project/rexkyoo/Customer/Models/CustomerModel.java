package project.rexkyoo.Customer.Models;

import java.util.List;

public class Customer
{
    private String name;
    private String phone;
    private String address;
    private String email;
    private List<Double> payments;
    private List<Double> expenses;
    private List<String> ambassadors;
    private String zipCode;
    private String city;

    public Customer(String name, String phone, String address, String email, List<Double> payments, List<Double> expenses, List<String> ambassadors, String zipCode, String city)
    {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.payments = payments;
        this.expenses = expenses;
        this.ambassadors = ambassadors;
        this.zipCode = zipCode;
        this.city = city;
    }
}
