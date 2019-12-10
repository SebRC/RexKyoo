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
    private String actualPayday;
    private Date expectedPayday;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private CustomerModel customer;

    public CustomerPaymentDateModel()
    {
    }

    public CustomerPaymentDateModel(String actualPayday, Date expectedPayday, CustomerModel customer)
    {
        this.actualPayday = actualPayday;
        this.expectedPayday = expectedPayday;
        this.customer = customer;
    }

    public String getActualPayday() {
        return actualPayday;
    }

    public void setActualPayday(String actualPayday) {
        this.actualPayday = actualPayday;
    }

    public Date getExpectedPayday() {
        return expectedPayday;
    }

    public void setExpectedPayday(Date expectedPayday) {
        this.expectedPayday = expectedPayday;
    }

    public CustomerModel getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerModel customer) {
        this.customer = customer;
    }
}
