package project.rexkyoo.Customer;

import project.rexkyoo.Feedback.Model.FeedbackModel;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

public class CustomerModel
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

    public CustomerModel()
    {
    }

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

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public List<Double> getPayments()
    {
        return payments;
    }

    public void setPayments(List<Double> payments)
    {
        this.payments = payments;
    }

    public List<Double> getExpenses()
    {
        return expenses;
    }

    public void setExpenses(List<Double> expenses)
    {
        this.expenses = expenses;
    }

    public List<String> getAmbassadors()
    {
        return ambassadors;
    }

    public void setAmbassadors(List<String> ambassadors)
    {
        this.ambassadors = ambassadors;
    }

    public String getZipCode()
    {
        return zipCode;
    }

    public void setZipCode(String zipCode)
    {
        this.zipCode = zipCode;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

}
