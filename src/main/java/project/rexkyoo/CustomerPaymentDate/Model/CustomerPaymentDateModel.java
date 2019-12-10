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
    @Column (name = "CustomerPaymentDate_id")
    private int id;
    private String actualPaymentDate;
    private Date expectedPaymentDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private CustomerModel customer;

    public CustomerPaymentDateModel()
    {
    }

    public CustomerPaymentDateModel(String actualPaymentDate, Date expectedPaymentDate, CustomerModel customer)
    {
        this.actualPaymentDate = actualPaymentDate;
        this.expectedPaymentDate = expectedPaymentDate;
        this.customer = customer;
    }

    public String getActualPaymentDate()
    {
        return actualPaymentDate;
    }

    public void setActualPaymentDate(String actualPayday)
    {
        this.actualPaymentDate = actualPayday;
    }

    public Date getExpectedPaymentDate()
    {
        return expectedPaymentDate;
    }

    public void setExpectedPaymentDate(Date expectedPayday)
    {
        this.expectedPaymentDate = expectedPayday;
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
