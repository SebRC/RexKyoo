package project.rexkyoo.Customer.Private.Model;

import project.rexkyoo.Customer.CustomerModel;

import java.util.List;

public class PrivateCustomerModel extends CustomerModel
{
    private String lastName;

    public PrivateCustomerModel()
    {

    }

    public PrivateCustomerModel(int id, String name, String phone, String address, String email, List<Double> payments, List<Double> expenses, List<String> ambassadors, String zipCode, String city, String lastName)
    {
        super(id, name, phone, address, email, payments, expenses, ambassadors, zipCode, city);
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
