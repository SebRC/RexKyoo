package project.rexkyoo.Customer.Models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Customers")
public class CustomerModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String name;
    private String phone;
    private String address;
    private String email;
    private List<Double> payments;
    private List<Double> expenses;
    private List<String> ambassadors;
    private String zipCode;
    private String city;

    public CustomerModel(String name, String phone, String address, String email, List<Double> payments, List<Double> expenses, List<String> ambassadors, String zipCode, String city)
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
