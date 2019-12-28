package project.rexkyoo.CustomerPaymentDate;

import project.rexkyoo.Customer.CustomerModel;

import javax.persistence.*;

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
    @Transient
    private String month;
    @Transient
    private String year;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private CustomerModel customer;

    public CustomerPaymentDateModel()
    {}

    public CustomerPaymentDateModel(String actualPaymentDate, String expectedPaymentDate, CustomerModel customer)
    {
        this.actualPaymentDate = actualPaymentDate;
        this.expectedPaymentDate = expectedPaymentDate;
        this.customer = customer;
    }

    public void setId(int id)
    {
        this.id = id;
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

    public String getYear()
    {
        return year;
    }

    public void setYear(String year)
    {
        this.year = year;
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
