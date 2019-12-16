package project.rexkyoo.CustomerPaymentDate.Model;

import project.rexkyoo.Customer.Model.CustomerModel;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CustomerPaymentDate")
public class CustomerPaymentDateModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "customerPaymentDate_id")
    private int id;
    private String actualPaymentDate = "Afventer betaling";
    private String expectedPaymentDate;
    private String month;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private CustomerModel customer;

    public CustomerPaymentDateModel()
    {
    }

    public CustomerPaymentDateModel(String actualPaymentDate, String expectedPaymentDate, String month, CustomerModel customer)
    {
        this.actualPaymentDate = actualPaymentDate;
        this.expectedPaymentDate = expectedPaymentDate;
        this.month = month;
        this.customer = customer;
    }

    public int getId()
    {
        return id;
    }

    public String getActualPaymentDate()
    {
        return actualPaymentDate;
    }

    public void setActualPaymentDate(String actualPaymentDate)
    {
        this.actualPaymentDate = actualPaymentDate;
    }

    public String getExpectedPaymentDate()
    {
        return expectedPaymentDate;
    }

    public void setExpectedPaymentDate(String expectedPaymentDate)
    {
        this.expectedPaymentDate = expectedPaymentDate;
    }

    public String getMonth()
    {
        return month;
    }

    public void setMonth(String month)
    {
        this.month = month;
    }

    public CustomerModel getCustomer()
    {
        return customer;
    }

    public void setCustomer(CustomerModel customer)
    {
        this.customer = customer;
    }
}
