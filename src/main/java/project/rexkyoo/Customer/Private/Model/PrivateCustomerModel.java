package project.rexkyoo.Customer.Private.Model;

import project.rexkyoo.Customer.CustomerModel;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PrivateCustomer")
public class PrivateCustomerModel extends CustomerModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "privateCustomer_id")
    private int id;
    private String lastName;

    public PrivateCustomerModel()
    {}

    public PrivateCustomerModel(String name, String phone, String address, String email, List<Double> payments, List<Double> expenses, List<String> ambassadors, String zipCode, String city, String lastName)
    {
        super(name, phone, address, email, payments, expenses, ambassadors, zipCode, city);
        this.lastName = lastName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
}
